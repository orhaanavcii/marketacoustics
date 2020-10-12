package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.CommunityGroup;

@Repository
public interface CommunityGroupRepository extends JpaRepository<CommunityGroup, Long> {
	CommunityGroup deleteCommunityGroupById(Long id);
}
