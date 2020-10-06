package tr.com.jforce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionChannels;
import tr.com.jforce.repository.ActionChannelsRepository;
import tr.com.jforce.service.ActionChannelsService;

@Service 
public class IActionChannelsService implements ActionChannelsService {
	
	private final ActionChannelsRepository actionChannelsRepository;
	
	@Autowired
	public IActionChannelsService(ActionChannelsRepository actionChannelsRepository) {
		this.actionChannelsRepository = actionChannelsRepository;
	}

	@Override
	public ActionChannels saveAC(ActionChannels actionChannels) {
		return this.actionChannelsRepository.save(actionChannels);
	}
	
	

}
