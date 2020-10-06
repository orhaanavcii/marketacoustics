package tr.com.jforce.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tr.com.jforce.entity.ActionType;
import tr.com.jforce.service.ActionTypeService;

@Scope("view")
@Component(value = "actionTypeController")
public class ActionTypeController {

	private final ActionTypeService actionTypeService;
	private List<ActionType> actionTypeList;
	
	@Autowired
	public ActionTypeController( ActionTypeService actionTypeService) {
		this.actionTypeService = actionTypeService;
	}
	
	@PostConstruct
	public void init() {
		this.actionTypeList = this.actionTypeService.findAll();
	}
	

	public List<ActionType> getActionTypeList() {
		return actionTypeList;
	}

	public void setActionTypeList(List<ActionType> actionTypeList) {
		this.actionTypeList = actionTypeList;
	}

	public ActionTypeService getActionTypeService() {
		return actionTypeService;
	}
	
	
	
	
}
