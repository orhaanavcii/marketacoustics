package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Community;

@Service
public interface CommunityService {
	
	List<Community> findAll();

}
