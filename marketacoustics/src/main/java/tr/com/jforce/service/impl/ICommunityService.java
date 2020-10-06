package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Community;
import tr.com.jforce.repository.CommunityRepository;
import tr.com.jforce.service.CommunityService;

@Service
public class ICommunityService implements CommunityService {
	
	private final CommunityRepository communityRepository;
	
	@Autowired
	public ICommunityService(CommunityRepository communityRepository) {
		this.communityRepository = communityRepository;
	}

	@Override
	public List<Community> findAll() {
		return this.communityRepository.findAll();
	}

}
