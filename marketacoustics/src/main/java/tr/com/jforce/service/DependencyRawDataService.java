package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DependencyRawData;

@Service
public interface DependencyRawDataService {
	
	List<DependencyRawData> findAll();
	DependencyRawData saveDependencyRawData(DependencyRawData dependencyRawData);
	void deleteDependencyRawData(Long id);

}
