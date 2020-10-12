package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.DependencyCommunity;

@Repository
public interface DependencyCommunityRepository extends JpaRepository<DependencyCommunity, Long> {

}
