package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DependencyCommunity;

@Service
public interface DependencyCommunityService {

	List<DependencyCommunity> findAll();
	DependencyCommunity saveDependencyCommunity(DependencyCommunity dependencyCommunity);
	void deleteDependencyCommunity(Long id);
}
