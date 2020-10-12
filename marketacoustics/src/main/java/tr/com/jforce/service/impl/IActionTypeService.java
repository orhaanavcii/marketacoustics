package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionType;
import tr.com.jforce.repository.ActionRepository;
import tr.com.jforce.repository.ActionTypeRepository;
import tr.com.jforce.service.ActionTypeService;

@Service
public class IActionTypeService implements ActionTypeService {
	
	private ActionTypeRepository actionTypeRepository;
	
	@Autowired
	public IActionTypeService(ActionTypeRepository actionTypeRepository) {
		this.actionTypeRepository = actionTypeRepository;
	}

	@Override
	public List<ActionType> findAll() {
		return this.actionTypeRepository.findAll();
	}

	@Override
	public ActionType saveActionType(ActionType actionType) {
		return this.actionTypeRepository.save(actionType);
	}

	@Override
	public void deleteActionType(Long id) {

		this.actionTypeRepository.deleteById(id);
		
	}

}
