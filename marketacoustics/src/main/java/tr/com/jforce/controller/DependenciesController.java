package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.Action;
import tr.com.jforce.entity.ActionDependencies;
import tr.com.jforce.entity.BaseDbEntity;
import tr.com.jforce.entity.Channel;
import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.DataDictionary;
import tr.com.jforce.entity.DependencyCommunity;
import tr.com.jforce.entity.DependencyRawData;
import tr.com.jforce.service.ActionDependenciesService;
import tr.com.jforce.service.CommunityService;
import tr.com.jforce.service.DataDictionaryService;
import tr.com.jforce.service.DependencyCommunityService;
import tr.com.jforce.service.DependencyRawDataService;
import tr.com.jforce.util.DependenciesCommunityRawData;

@Scope("view")
@Component(value = "dependenciesController")
@Data
public class DependenciesController {

	private final CommunityService communityService;
	private final DataDictionaryService dataDictionaryService;
	private final DependencyCommunityService dependencyCommunityService;
	private final DependencyRawDataService dependencyRawDataService;
	private final ActionDependenciesService actionDependenciesService;

	private List<DataDictionary> dataDictionaryList;
	private List<Community> sourceCommunityList;
	private List<Community> targetCommunityList;
	private List<BaseDbEntity> mainSourceList;
	private List<BaseDbEntity> targetSourceList;
	private List<String> andOr;
	private List<String> inOut;
	private List<DependenciesCommunityRawData> dependenciesCommunityRawDatas;
	private List<DataDictionary> dbDataDictionaryList;
	private List<BaseDbEntity> tableSourceList;
	private List<ActionDependencies> dependenciesList;

	private String ruleFilterName;
	private String rule;
	private String isAndOr;
	private String isInOut;
	private DependencyRawData dependencyRawData;
	private DependencyCommunity dependencyCommunity;
	private ActionDependencies actionDependencies;

	@Autowired
	public DependenciesController(CommunityService communityService, DataDictionaryService dataDictionaryService,
			DependencyCommunityService dependencyCommunityService, DependencyRawDataService dependencyRawDataService,
			ActionDependenciesService actionDependenciesService) {

		this.communityService = communityService;
		this.dataDictionaryService = dataDictionaryService;
		this.dependencyCommunityService = dependencyCommunityService;
		this.dependencyRawDataService = dependencyRawDataService;
		this.actionDependenciesService = actionDependenciesService;
	}

	@PostConstruct
	public void init() {
		dataPreparation();
		findAll();

	}

	public void findAll() {
		this.sourceCommunityList = this.communityService.findAll();
		this.dataDictionaryList = this.dataDictionaryService.findAll();
		this.dependenciesList = this.actionDependenciesService.findAll();
		updateSourceList();

	}

	public void updateSourceList() {
		
		this.mainSourceList = new ArrayList<BaseDbEntity>();
		
		this.sourceCommunityList.forEach(x -> {
			this.mainSourceList.add(x);
		});

		this.dataDictionaryList.forEach(x -> {
			this.mainSourceList.add(x);
		});
	}

	public void saveDependencies(Action action) {

		actionDependencies = new ActionDependencies();
		actionDependencies.setRuleFilterName(ruleFilterName);
		actionDependencies.setAction(action);
		actionDependencies.setDependencyNotes(rule);
		this.actionDependenciesService.saveActionDependencies(actionDependencies);

		this.tableSourceList.forEach(x -> {
			if (x instanceof DependencyRawData) {
				((DependencyRawData) x).setActionDependencies(actionDependencies);
				this.dependencyRawDataService.saveDependencyRawData((DependencyRawData) x);
			}
			if (x instanceof DependencyCommunity) {
				((DependencyCommunity) x).setActionDependencies(actionDependencies);
				this.dependencyCommunityService.saveDependencyCommunity((DependencyCommunity) x);
			}
		});
		
		findAll();
		this.rule = null;
		this.ruleFilterName = "";
		this.targetSourceList = new ArrayList<BaseDbEntity>();
	}

	public void pushData(Action action) {

		this.targetSourceList.forEach(x -> {

			if (x instanceof DataDictionary) {

				if (((DataDictionary) x).getFieldType().equals("BOOLEAN")) {

					dependencyRawData = new DependencyRawData();
					dependencyRawData.setAction(action);
					dependencyRawData.setDataDictionary((DataDictionary) x);
					dependencyRawData.setMustBeIn(isInOut == "IN" ? Boolean.TRUE : Boolean.FALSE);
					dependencyRawData.setAndOr(isAndOr == "AND" ? Boolean.TRUE : Boolean.FALSE);
					this.tableSourceList.add(dependencyRawData);
					
					rule = checkRuleEndsWithAndOr(rule);
					
					if (isAndOr == "AND") {
						rule += ((DataDictionary) x).getFieldName() + " AND ";
					} else {
						rule += ((DataDictionary) x).getFieldName() + " OR ";
					}
				}

			}

			if (x instanceof Community) {

				dependencyCommunity = new DependencyCommunity();
				dependencyCommunity.setAction(action);
				dependencyCommunity.setCommunity((Community) x);
				dependencyCommunity.setActionDependencies(null);
				dependencyCommunity.setMustBeIn(isInOut == "IN" ? Boolean.TRUE : Boolean.FALSE);
				dependencyCommunity.setAndOr(isAndOr == "AND" ? Boolean.TRUE : Boolean.FALSE);

				this.tableSourceList.add(dependencyCommunity);
				
				rule = checkRuleEndsWithAndOr(rule);
				
				if (isAndOr == "AND") {
					rule += (((Community) x).getCommunityCode()) + " AND ";
				} else {
					rule += (((Community) x).getCommunityCode()) + " OR ";
				}
			}

		});

		this.rule = formatRule(rule);
	
	}

	public void dataPreparation() {
		tableSourceList = new ArrayList<BaseDbEntity>();
		targetSourceList = new ArrayList<BaseDbEntity>();
		sourceCommunityList = new ArrayList<Community>();
		targetCommunityList = new ArrayList<Community>();
		mainSourceList = new ArrayList<BaseDbEntity>();
		dataDictionaryList = new ArrayList<DataDictionary>();
		dbDataDictionaryList = new ArrayList<DataDictionary>();
		dependenciesList = new ArrayList<ActionDependencies>();
		andOr = new ArrayList<String>();
		inOut = new ArrayList<String>();

		dependenciesCommunityRawDatas = new ArrayList<DependenciesCommunityRawData>();

		this.andOr.add("AND");
		this.andOr.add("OR");
		this.inOut.add("IN");
		this.inOut.add("OUT");
	}

	public String formatRule(String rule) {

		String formattedRule = "";

		if (rule.startsWith("null")) {
			rule = rule.replaceAll("null", "");
		}

		if (rule.endsWith("AND ") || rule.endsWith("OR ")) {

			formattedRule = rule.substring(0, rule.lastIndexOf(" ") - 3).trim();
		}

		return formattedRule;
	}
	
	public String checkRuleEndsWithAndOr(String rule) {
		if(rule != null) {
			if(!rule.endsWith("AND ") && !rule.endsWith("OR ")) {
				if(isAndOr == "AND") {
					return rule += " AND ";
				}
				if(isAndOr == "OR") {
					return rule += " OR ";
				}
			}
		}
		return rule;
	}

}
