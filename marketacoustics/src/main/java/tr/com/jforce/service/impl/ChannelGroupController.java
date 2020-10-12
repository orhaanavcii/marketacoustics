package tr.com.jforce.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.ChannelGroups;
import tr.com.jforce.service.ChannelGroupService;

@Scope("view")
@Component(value = "channelGroupController")
@Data
public class ChannelGroupController {
	
	private final ChannelGroupService channelGroupService;
	private ChannelGroups channelGroup;
	private List<ChannelGroups> channelGroupList;
	
	@Autowired
	public ChannelGroupController(ChannelGroupService channelGroupService) {
		this.channelGroupService = channelGroupService;
	}
	
	@PostConstruct
	public void init() {
		
		dataPreparation();
		findAll();
		
	}

	public void dataPreparation() {
		this.channelGroupList = new ArrayList<ChannelGroups>();
		this.channelGroup = new ChannelGroups();
	}
	
	public ChannelGroups saveChannelGroup() {
		channelGroup = this.channelGroupService.saveChannelGroup(channelGroup);
		findAll();
		this.channelGroup = new ChannelGroups();
		return channelGroup;
	}
	
	public void deleteChannelGroup(Long id) {
		this.channelGroupService.deleteChannelGroup(id);
		findAll();
	}
	
	public void findAll() {
		this.channelGroupList = this.channelGroupService.findAll();
	}
	
}
