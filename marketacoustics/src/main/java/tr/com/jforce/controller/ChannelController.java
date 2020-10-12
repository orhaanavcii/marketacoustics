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
import tr.com.jforce.entity.ChannelGroups;
import tr.com.jforce.entity.Community;
import tr.com.jforce.service.ActionChannelsService;
import tr.com.jforce.service.ChannelGroupService;
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
	private Boolean flag;
	private Boolean isDisabled;
	private Channel channel;
	private String channelGroupId;
	

	@Autowired
	public ChannelController(ChannelService channelService, ActionChannelsService actionChannelsService) {
		this.channelService = channelService;
		this.actionChannelsService = actionChannelsService;

	}

	@PostConstruct
	public void init() {
		
		this.channel = new Channel();
		findAll();
		this.channelDualList = new DualListModel<Channel>(this.sourceChannelList, new ArrayList<Channel>());

	}

	public void updateDualList(List<Channel> sourceList, List<Channel> targetList) {
		this.channelDualList = new DualListModel<Channel>(sourceList, targetList);
	}

	public void findAll() {
		this.sourceChannelList = this.channelService.findAll();
		updateDualList(sourceChannelList, new ArrayList<Channel>());

	}

	public void save(Action action) {
		if (checkChannelGroup()) {
			this.actionChannels = new ActionChannels();
			this.actionChannels.setAction(action);
			this.actionChannels.setChannelList(this.channelDualList.getTarget());
			this.actionChannelsService.saveAC(actionChannels);
			this.isDisabled = Boolean.TRUE;

		} else {
			throwMessage();
			findAll();

		}
	}

	public Boolean checkChannelGroup() {
		this.flag = Boolean.TRUE;
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

		if (!checkChannelGroup()) {
			throwMessage();
		}

	}
	
	public void saveChannelAndBindToGroup() {
		ChannelGroups channelGroups = new ChannelGroups();
		channelGroups.setId(Long.valueOf(channelGroupId));
		channel.setChannelGroups(channelGroups);
		this.channelService.saveChannel(channel);
		this.channel = new Channel();
		
		findAll();
	}
	
	public void deleteChannel(Long id) {
		this.channelService.deleteChannel(id);
		findAll();
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

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getChannelGroupId() {
		return channelGroupId;
	}

	public void setChannelGroupId(String channelGroupId) {
		this.channelGroupId = channelGroupId;
	}

	

}
