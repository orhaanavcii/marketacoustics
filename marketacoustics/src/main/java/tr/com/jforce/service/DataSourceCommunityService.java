package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.DataSourceCommunity;

@Service
public interface DataSourceCommunityService {
	
	List<DataSourceCommunity> findByTargetAudianceDataSourceId(Long id);

}
