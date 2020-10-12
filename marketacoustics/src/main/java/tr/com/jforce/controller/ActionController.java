package tr.com.jforce.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import tr.com.jforce.entity.Action;
import tr.com.jforce.entity.ActionType;

import tr.com.jforce.entity.DataSource;
import tr.com.jforce.service.ActionService;


@Scope("view")
@Component(value = "actionController")
public class ActionController {
	private ActionType actionType;
	private DataSource dataSource;
	private final ActionService actionService;
	private Action action;
	private List<Action> actionList;
	private Boolean isDisabled = Boolean.FALSE;

	public ActionController(ActionService actionService) {
		this.actionService = actionService;
	}

	@PostConstruct
	public void init() {
		this.action = new Action();
		this.actionList = findAll();
	}

	public void addAction(Action action) {
		this.actionService.addAction(action);
	}

	public List<Action> findAll() {
		return this.actionService.findAll();
	}

	public void save() {
		this.action.setActionType(this.actionType);
		this.action.setTargetAudianceDataSource(this.dataSource);
		this.action = this.actionService.addAction(this.action);
		this.actionList = findAll();
		this.isDisabled = Boolean.TRUE;
		throwSuccessMessage();
	}
	
	public void throwSuccessMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("mainSuccess",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Message : The registration has been successfully added."));
	}

	public DataSource getDataSource() {
		if (this.dataSource == null) {
			this.dataSource = new DataSource();
			return this.dataSource;
		}
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	

	public List<Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}

	public Action getAction() {
		if (this.action == null) {
			this.action = new Action();
			return this.action;
		}
		return this.action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public ActionType getActionType() {
		if (this.actionType == null) {
			this.actionType = new ActionType();
			return this.actionType;
		}
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	

	public Action getActionService() {
		if (this.action == null) {
			return new Action();
		}
		return action;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
	
	

}
