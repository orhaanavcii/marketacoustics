package tr.com.jforce.service;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionChannels;

@Service
public interface ActionChannelsService {
	
	ActionChannels saveAC(ActionChannels actionChannels);

}
