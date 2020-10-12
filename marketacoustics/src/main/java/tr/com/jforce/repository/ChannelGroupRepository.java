package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.ChannelGroups;

@Repository
public interface ChannelGroupRepository extends JpaRepository<ChannelGroups, Long> {

}
