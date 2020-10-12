package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.CommunityGroup;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
	
}
