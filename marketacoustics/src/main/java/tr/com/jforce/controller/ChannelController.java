package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import tr.com.jforce.entity.Action;
import tr.com.jforce.entity.ActionChannels;
import tr.com.jforce.entity.Channel;
import tr.com.jforce.service.ActionChannelsService;
import tr.com.jforce.service.ChannelService;

@Scope("view")
@Component(value = "channelController")
public class ChannelController {

	private final ChannelService channelService;
	private final ActionChannelsService actionChannelsService;
	private String message = "You can only use one channel per channel group !";
	private DualListModel<Channel> channelDualList;
	private List<Channel> sourceChannelList;
	private ActionChannels actionChannels;

	@Autowired
	public ChannelController(ChannelService channelService, ActionChannelsService actionChannelsService) {
		this.channelService = channelService;
		this.actionChannelsService = actionChannelsService;
	}

	@PostConstruct
	public void init() {

		findAll();
		this.channelDualList = new DualListModel<Channel>(this.sourceChannelList, new ArrayList<Channel>());

	}

	public void findAll() {
		this.sourceChannelList = this.channelService.findAll();

	}

	public void save(Action action) {
		if (checkChannelGroup()) {
			this.actionChannels = new ActionChannels();
			this.actionChannels.setAction(action);
			this.actionChannels.setChannelList(this.channelDualList.getTarget());
			this.actionChannelsService.saveAC(actionChannels);

		} else {
			throwMessage();
	
		}
	}

//	public void handleTransfer(TransferEvent event) {
//		
//        List<Channel> transferChannels = (List<Channel>) event.getItems();
//        Channel tempChannel = new Channel();
//        
//        if(event.isAdd()) {
//        	if(this.channelDualList.getTarget().size() >= 2) {
//        	transferChannels.forEach(t -> {
//        		this.channelDualList.getTarget().forEach(x -> {
//        			if(x.getChannelGroups().getId() == t.getChannelGroups().getId()) {
//        				throwMessage();
//        			}
//        		});
//        	});
//        	}
//        }
//    }
	
	Boolean flag = Boolean.TRUE;
	public Boolean checkChannelGroup() {
		
		this.channelDualList.getTarget().forEach(x -> {
			this.channelDualList.getTarget().forEach(t -> {
				if (x != t) {
					if (x.getChannelGroups().getId() == t.getChannelGroups().getId()) {
						flag = Boolean.FALSE;
					}
				}
			});
		});

		return flag;
	}
	

	public void throwMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("channelMessage",
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Attention", "Message :" + this.message));
	}
	
	
	public void transferCheck() {
		
			if(!checkChannelGroup()) {
				throwMessage();
			}
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public DualListModel<Channel> getChannelDualList() {
		return channelDualList;
	}

	public void setChannelDualList(DualListModel<Channel> channelDualList) {
		this.channelDualList = channelDualList;
	}

	public List<Channel> getSourceChannelList() {
		return sourceChannelList;
	}

	public void setSourceChannelList(List<Channel> sourceChannelList) {
		this.sourceChannelList = sourceChannelList;
	}

	public ActionChannels getActionChannels() {
		return actionChannels;
	}

	public void setActionChannels(ActionChannels actionChannels) {
		this.actionChannels = actionChannels;
	}

	public ChannelService getChannelService() {
		return channelService;
	}

	public ActionChannelsService getActionChannelsService() {
		return actionChannelsService;
	}

}
