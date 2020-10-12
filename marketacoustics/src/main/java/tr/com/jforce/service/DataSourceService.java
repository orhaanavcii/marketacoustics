package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DataSource;

@Service
public interface DataSourceService {
	
	List<DataSource> findAll();
	DataSource saveDataSource(DataSource dataSource);
	void deleteDataSource(Long id);

}
