package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionDependencies;

@Service
public interface ActionDependenciesService {
	
	List<ActionDependencies> findAll();
	ActionDependencies saveActionDependencies(ActionDependencies actionDependencies);
	void deleteActionDependencies(Long id);

}
