package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DependencyRawData;
import tr.com.jforce.repository.DependencyRawDataRepository;
import tr.com.jforce.service.DependencyRawDataService;

@Service
public class IDependencyRawDataService implements DependencyRawDataService {

	private final DependencyRawDataRepository dependencyRawDataRepository;
	
	@Autowired
	public IDependencyRawDataService(DependencyRawDataRepository dependencyRawDataRepository) {
		this.dependencyRawDataRepository = dependencyRawDataRepository;
	}

	@Override
	public List<DependencyRawData> findAll() {
		return this.dependencyRawDataRepository.findAll();
	}

	@Override
	public DependencyRawData saveDependencyRawData(DependencyRawData dependencyRawData) {
		return this.dependencyRawDataRepository.save(dependencyRawData);
	}

	@Override
	public void deleteDependencyRawData(Long id) {
		this.dependencyRawDataRepository.deleteById(id);
	}
}
