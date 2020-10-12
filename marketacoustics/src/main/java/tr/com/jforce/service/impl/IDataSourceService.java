package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DataSource;
import tr.com.jforce.repository.DataSourceRepository;
import tr.com.jforce.service.DataSourceService;

@Service
public class IDataSourceService implements DataSourceService {

	private final DataSourceRepository dataSourceRepository;

	@Autowired
	public IDataSourceService(DataSourceRepository dataSourceRepository) {
		this.dataSourceRepository = dataSourceRepository;
	}

	@Override
	public List<DataSource> findAll() {
		return this.dataSourceRepository.findAll();
	}

	@Override
	public DataSource saveDataSource(DataSource dataSource) {
		return this.dataSourceRepository.save(dataSource);
	}

	@Override
	public void deleteDataSource(Long id) {
		this.dataSourceRepository.deleteById(id);
	}

}
