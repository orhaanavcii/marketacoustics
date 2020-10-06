package tr.com.jforce.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import tr.com.jforce.entity.Channel;
import tr.com.jforce.repository.ChannelRespository;
import tr.com.jforce.service.ChannelService;

@Service
@Getter @Setter
public class IChannelService implements ChannelService{
	
	@Autowired
	private  ChannelRespository channelRespository;
	
	
	public IChannelService(ChannelRespository channelRespository) {
		this.channelRespository = channelRespository;
	}

	@Override
	@Transactional
	public List<Channel> findAll() {
		return this.channelRespository.findAll();
	}

}
