package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.DataSourceCommunity;
import tr.com.jforce.repository.DataSourceCommunityRepository;
import tr.com.jforce.service.DataSourceCommunityService;

@Service
public class IDataSourceCommunityService implements DataSourceCommunityService {
	
	private final DataSourceCommunityRepository dataSourceCommunityRepository;
	
	@Autowired
	public IDataSourceCommunityService(DataSourceCommunityRepository dataSourceCommunityRepository) {
		this.dataSourceCommunityRepository = dataSourceCommunityRepository;
	}

	@Override
	public List<DataSourceCommunity> findByTargetAudianceDataSourceId(Long id) {
		return this.dataSourceCommunityRepository.findByTargetAudianceDataSourceId(id);
	}

}
