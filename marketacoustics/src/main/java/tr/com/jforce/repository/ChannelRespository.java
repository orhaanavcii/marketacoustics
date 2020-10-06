package tr.com.jforce.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.Channel;

@Repository
public interface ChannelRespository extends JpaRepository<Channel, Long> {
	

}
 