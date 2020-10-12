package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ChannelGroups;
import tr.com.jforce.repository.ChannelGroupRepository;
import tr.com.jforce.service.ChannelGroupService;

@Service
public class IChannelGroupService implements ChannelGroupService {

	private final ChannelGroupRepository channelGroupRepository;
	@Autowired
	public IChannelGroupService(ChannelGroupRepository channelGroupRepository) {
		this.channelGroupRepository = channelGroupRepository;
	}
	@Override
	public ChannelGroups saveChannelGroup(ChannelGroups channelGroup) {
		return this.channelGroupRepository.save(channelGroup);
	}
	@Override
	public void deleteChannelGroup(Long id) {
		this.channelGroupRepository.deleteById(id);
	}
	@Override
	public List<ChannelGroups> findAll() {
		return this.channelGroupRepository.findAll();
	}
}
