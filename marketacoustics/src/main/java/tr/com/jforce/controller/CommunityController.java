package tr.com.jforce.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import tr.com.jforce.entity.Community;
import tr.com.jforce.service.CommunityService;


@Scope("view")
@Component(value = "communityController")
@Getter @Setter
public class CommunityController {
	
	private final CommunityService communityService;
	private DualListModel<Community> dualCommunityList;
	private List<Community> sourceCommunityList;
	private List<Community> targetCommunityList = new ArrayList<Community>();
	
	@Autowired
	public CommunityController(CommunityService communityService) {
		this.communityService = communityService;
	}
	
	
	@PostConstruct
	public void init() {
		
		this.sourceCommunityList = findAll();
		this.dualCommunityList = new DualListModel<Community>(this.sourceCommunityList, this.targetCommunityList);
		
	}
	
	
	
	public List<Community> findAll() {
		return this.communityService.findAll();
	}

}
