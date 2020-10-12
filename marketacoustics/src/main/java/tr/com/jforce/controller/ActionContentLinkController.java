package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.Action;
import tr.com.jforce.entity.ActionContentLink;
import tr.com.jforce.entity.ChannelGroups;
import tr.com.jforce.entity.Persona;
import tr.com.jforce.service.ActionContentLinkService;

@Data
@Scope("view")
@Component(value = "actionContentLinkController")
public class ActionContentLinkController {
	
	private final ActionContentLinkService actionContentLinkService;
	private List<ActionContentLink> actionContentLinkList;
	private List<String> ageGroupList;
	private List<String> lifeStage;
	private ActionContentLink actionContentLink;
	private ChannelGroups channelGroup;
	private Persona persona;
	private Boolean isDisabled ;
	
	@Autowired
	public ActionContentLinkController(ActionContentLinkService actionContentLinkService) {
		this.actionContentLinkService = actionContentLinkService;
	}
	

	@PostConstruct
	public void init() {
		
		dataPreparation();
		findAll();
		
	}


	private void findAll() {
		this.actionContentLinkList = this.actionContentLinkService.findAll();
	}


	private void dataPreparation() {
		
		this.isDisabled = Boolean.FALSE;
		this.actionContentLink = new ActionContentLink();
		this.channelGroup = new ChannelGroups();
		this.persona = new Persona();
		
		this.ageGroupList = new ArrayList<String>();
		ageGroupList.add("Gençler");
		ageGroupList.add("Orta Yaş");
		ageGroupList.add("Yaşlılar");
		
		this.lifeStage = new ArrayList<String>();
		lifeStage.add("Yeni Mezun");
		lifeStage.add("Bekar");
		lifeStage.add("Yeni Evli");
		lifeStage.add("Evli");
		lifeStage.add("Evli Ve Çocuklu");
		lifeStage.add("Evli Ve Çocuklar Evden Ayrılmış");
	}
	
	public void saveActionContentLink(Action action) {
		this.actionContentLink.setAction(action);
		this.actionContentLink.setChannelGroup(channelGroup);
		this.actionContentLink.setPersona(persona);
		this.actionContentLinkService.saveActionCL(actionContentLink);
		findAll();
		this.actionContentLink = new ActionContentLink();
		this.isDisabled = Boolean.TRUE;
	}

}
