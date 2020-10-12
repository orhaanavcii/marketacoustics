package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tr.com.jforce.entity.CommunityGroup;
import tr.com.jforce.service.CommunityGroupService;

@Scope("view")
@Component(value = "communityGroupController")
@Data
@Slf4j
public class CommunityGroupController {
	
	private final CommunityGroupService comunityGroupService;
	private List<CommunityGroup> communityGroupList;
	private CommunityGroup communityGroup;
	
	@Autowired
	public CommunityGroupController(CommunityGroupService comunityGroupService) {
		this.comunityGroupService = comunityGroupService;
	}
	
	
	@PostConstruct
	public void init() {
		this.communityGroup = new CommunityGroup();
		this.communityGroupList = new ArrayList<CommunityGroup>();
		findAll();
	}


	public void findAll() {
		this.communityGroupList = this.comunityGroupService.findAll();
	}
	
	public void save() {
		this.comunityGroupService.saveCommunityGroup(this.communityGroup);
		this.communityGroup = new CommunityGroup();
		findAll();
	}

	public void delete(Long id) {
		log.info("ID = " + id);
		this.comunityGroupService.deleteComunity(id);
		findAll();
	}

}
