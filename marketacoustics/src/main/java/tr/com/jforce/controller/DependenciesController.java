package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.Channel;
import tr.com.jforce.entity.Community;
import tr.com.jforce.service.CommunityService;
import tr.com.jforce.util.DependenciesCommunityRawData;

@Scope("view")
@Component(value = "dependenciesController")
@Data
public class DependenciesController {
	
	private final CommunityService communityService;
	private List<Community> sourceCommunityList = new ArrayList<Community>();
	private List<Community> targetCommunityList = new ArrayList<Community>();
	private List<String> andOr = new ArrayList<String>();
	private List<String> inOut = new ArrayList<String>();
	private List<DependenciesCommunityRawData> dependenciesCommunityRawDatas = new ArrayList<DependenciesCommunityRawData>();
	private String isAndOr;
	private String isInOut;
	@Autowired
	public DependenciesController(CommunityService communityService) {
		this.communityService = communityService;
	}
	
	@PostConstruct
	public void init() {
		this.andOr.add("AND");
		this.andOr.add("OR");
		this.inOut.add("IN");
		this.inOut.add("OUT");
		this.sourceCommunityList = this.communityService.findAll();

	}
	
	public void pushData() {
		this.targetCommunityList.forEach(x -> {
			DependenciesCommunityRawData dependenciesCommunityRawData = new DependenciesCommunityRawData();
			dependenciesCommunityRawData.setData(x.getCommunityCode());
			dependenciesCommunityRawData.setAndOr(this.isAndOr);
			dependenciesCommunityRawData.setInOut(this.isInOut);
			this.dependenciesCommunityRawDatas.add(dependenciesCommunityRawData);
		});
		
		this.targetCommunityList = new ArrayList<Community>();
	}
	

}
