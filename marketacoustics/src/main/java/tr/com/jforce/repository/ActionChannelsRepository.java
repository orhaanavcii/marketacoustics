package tr.com.jforce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.ActionChannels;

@Repository
public interface ActionChannelsRepository extends JpaRepository<ActionChannels, Long>{

}
