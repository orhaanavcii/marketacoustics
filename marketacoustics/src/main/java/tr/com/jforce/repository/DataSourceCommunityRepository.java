package tr.com.jforce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tr.com.jforce.entity.DataSource;
import tr.com.jforce.entity.DataSourceCommunity;

@Repository
public interface DataSourceCommunityRepository extends JpaRepository<DataSourceCommunity, Long> {
	
	List<DataSourceCommunity> findDataSourceCommunityByTargetAudianceDataSourceId(Long id);

}
