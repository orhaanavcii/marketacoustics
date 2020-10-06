package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Action;
import tr.com.jforce.repository.ActionRepository;
import tr.com.jforce.service.ActionService;


@Service
public class IActionService implements ActionService {
	
	private final ActionRepository actionRepository;
	
	@Autowired
	public IActionService(ActionRepository actionRepository) {
		this.actionRepository = actionRepository;
	}

	@Override
	public Action addAction(Action action) {
		return this.actionRepository.save(action);
	}

	@Override
	public List<Action> findAll() {
		return this.actionRepository.findAll();
	}
	
	

}
