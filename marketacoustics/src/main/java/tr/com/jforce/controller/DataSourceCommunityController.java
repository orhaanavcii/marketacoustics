package tr.com.jforce.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.Action;
import tr.com.jforce.entity.ActionTargetCommunityGroup;
import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.CommunityGroup;
import tr.com.jforce.entity.DataSourceCommunity;
import tr.com.jforce.service.ActionTargetCommunityService;
import tr.com.jforce.service.DataSourceCommunityService;

@RequestScoped
@Component(value = "dataSourceCommunityController")
@ManagedBean
@Data
public class DataSourceCommunityController {

	private Long selectedDataSourceId;
	private final DataSourceCommunityService dataSourceCommunityService;
	private final ActionTargetCommunityService actionTargetCommunityService;
	private List<DataSourceCommunity> transferCommunityList;
	private DualListModel<Community> communityDualList;
	private ActionTargetCommunityGroup actionTargetCommunityGroup;
	private List<Community> sourceList;
	private List<Community> targetList = new ArrayList<Community>();
	

	@Autowired
	public DataSourceCommunityController(DataSourceCommunityService dataSourceCommunityService,
			ActionTargetCommunityService actionTargetCommunityService) {
		this.dataSourceCommunityService = dataSourceCommunityService;
		this.actionTargetCommunityService = actionTargetCommunityService;

	}

	@PostConstruct
	public void init() {
		
		updateCommunityList();
		
	}

	public void updateCommunityList() {
		this.transferCommunityList = this.dataSourceCommunityService
				.findByTargetAudianceDataSourceId(this.selectedDataSourceId);
		List<Community> sourceCommunityList = this.transferCommunityList.stream().map(x -> x.getCommunity())
				.collect(Collectors.toList());

		updateCommunityDualList(sourceCommunityList, this.targetList);
	}

	public void updateCommunityDualList(List<Community> sourceList, List<Community> targetList) {
		this.communityDualList = new DualListModel<Community>(sourceList, targetList);
	}

	public void save(Action action) throws IOException {
		List<Community> communityList = this.communityDualList.getTarget();
		this.actionTargetCommunityGroup = new ActionTargetCommunityGroup();
		this.actionTargetCommunityGroup.setCommunityList(communityList);
		this.actionTargetCommunityGroup.setAction(action);
		System.out.println(this.actionTargetCommunityService.saveATC(actionTargetCommunityGroup));
//		System.out.println(this.actionTargetCommunityService.findATCByActionId(5L));
		
	}

}
