package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DependencyCommunity;
import tr.com.jforce.repository.DependencyCommunityRepository;
import tr.com.jforce.service.DependencyCommunityService;

@Service
public class IDependencyCommunityService implements DependencyCommunityService {
	
	private final DependencyCommunityRepository dependencyCommunityRepository;
	
	@Autowired
	public IDependencyCommunityService(DependencyCommunityRepository dependencyCommunityRepository) {
		this.dependencyCommunityRepository = dependencyCommunityRepository;
	}

	@Override
	public List<DependencyCommunity> findAll() {
		return this.dependencyCommunityRepository.findAll();
	}

	@Override
	public DependencyCommunity saveDependencyCommunity(DependencyCommunity dependencyCommunity) {
		return this.dependencyCommunityRepository.save(dependencyCommunity);
	}

	@Override
	public void deleteDependencyCommunity(Long id) {
		this.dependencyCommunityRepository.deleteById(id);
	}

}
