package tr.com.jforce.service;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionTargetCommunityGroup;

@Service
public interface ActionTargetCommunityService {
	
	ActionTargetCommunityGroup saveATC(ActionTargetCommunityGroup actionTargetCommunityGroup);
	ActionTargetCommunityGroup findATCByActionId(Long id);

}
