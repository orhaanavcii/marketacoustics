package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Channel;

@Service
public interface ChannelService {
	
	List<Channel> findAll();

}
