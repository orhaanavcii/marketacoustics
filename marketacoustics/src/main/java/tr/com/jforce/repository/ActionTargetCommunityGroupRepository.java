package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.ActionTargetCommunityGroup;


@Repository
public interface ActionTargetCommunityGroupRepository  extends JpaRepository<ActionTargetCommunityGroup, Long>{
	
	ActionTargetCommunityGroup findActionTargetCommunityGroupByActionId(Long id);
	
}
