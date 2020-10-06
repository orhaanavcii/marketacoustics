package tr.com.jforce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionTargetCommunityGroup;
import tr.com.jforce.repository.ActionTargetCommunityGroupRepository;
import tr.com.jforce.service.ActionTargetCommunityService;

@Service
public class IActionTargetCommunityGroupService implements ActionTargetCommunityService {
	
	private final ActionTargetCommunityGroupRepository actionTargetCommunityGroupRepository;
	
	@Autowired
	 public IActionTargetCommunityGroupService(ActionTargetCommunityGroupRepository actionTargetCommunityGroupRepository) {
		this.actionTargetCommunityGroupRepository = actionTargetCommunityGroupRepository;
	}

	@Override
	public ActionTargetCommunityGroup saveATC(ActionTargetCommunityGroup actionTargetCommunityGroup) {
		return this.actionTargetCommunityGroupRepository.save(actionTargetCommunityGroup);
	}

	@Override
	public ActionTargetCommunityGroup findATCByActionId(Long id) {
		return this.actionTargetCommunityGroupRepository.findActionTargetCommunityGroupByActionId(id);
	}

}
