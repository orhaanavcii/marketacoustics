package tr.com.jforce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.CommunityGroup;

@Service
@Transactional
public interface CommunityGroupService {
	
	List<CommunityGroup> findAll();
	CommunityGroup saveCommunityGroup(CommunityGroup communityGroup);
	CommunityGroup deleteCommunityGroup(Long id);
	void deleteComunity(Long id);

}
