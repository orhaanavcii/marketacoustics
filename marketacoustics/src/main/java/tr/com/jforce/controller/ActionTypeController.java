package tr.com.jforce.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.ActionType;
import tr.com.jforce.service.ActionTypeService;

@Scope("view")
@Component(value = "actionTypeController")
@Data
public class ActionTypeController {

	private final ActionTypeService actionTypeService;
	private List<ActionType> actionTypeList;
	private ActionType actionType;
	
	@Autowired
	public ActionTypeController( ActionTypeService actionTypeService) {
		this.actionTypeService = actionTypeService;
	}
	
	@PostConstruct
	public void init() {
		dataPreparation();
		findAll();
	}

	public void dataPreparation() {
		this.actionType = new ActionType();
	}

	public void findAll() {
		this.actionTypeList = this.actionTypeService.findAll();
	}
	
	public void saveActionType() {
		this.actionTypeService.saveActionType(actionType);
		findAll();
		this.actionType = new ActionType();
	}
	
	public void deleteActionType(Long id) {
		this.actionTypeService.deleteActionType(id);
		findAll();
	}
	
}
