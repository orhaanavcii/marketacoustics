package tr.com.jforce.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.CommunityGroup;
import tr.com.jforce.repository.CommunityGroupRepository;
import tr.com.jforce.service.CommunityGroupService;

@Service
@Transactional
public class ICommunityGroupService implements CommunityGroupService {

	private final CommunityGroupRepository communityGroupRepository;
	
	@Autowired
	public ICommunityGroupService(CommunityGroupRepository communityGroupRepository) {
		this.communityGroupRepository = communityGroupRepository;
	}

	@Override
	public List<CommunityGroup> findAll() {
		return this.communityGroupRepository.findAll();
	}

	@Override
	public CommunityGroup saveCommunityGroup(CommunityGroup communityGroup) {
		return this.communityGroupRepository.save(communityGroup);
	}

	@Override
	public CommunityGroup deleteCommunityGroup(Long id) {
		return this.communityGroupRepository.deleteCommunityGroupById(id);
	}

	@Override
	public void deleteComunity(Long id) {
		this.communityGroupRepository.deleteById(id);
	}
}
