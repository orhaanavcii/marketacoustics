package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionDependencies;
import tr.com.jforce.repository.ActionDependenciesRepository;
import tr.com.jforce.service.ActionDependenciesService;

@Service
public class IActionDependenciesService implements ActionDependenciesService{

	private final ActionDependenciesRepository actionDependenciesRepository;
	
	public IActionDependenciesService(ActionDependenciesRepository actionDependenciesRepository) {
		this.actionDependenciesRepository = actionDependenciesRepository;
	}

	@Override
	public List<ActionDependencies> findAll() {
		return this.actionDependenciesRepository.findAll();
	}

	@Override
	public ActionDependencies saveActionDependencies(ActionDependencies actionDependencies) {
		return this.actionDependenciesRepository.save(actionDependencies);
	}

	@Override
	public void deleteActionDependencies(Long id) {
		this.actionDependenciesRepository.deleteById(id);
	}
}
