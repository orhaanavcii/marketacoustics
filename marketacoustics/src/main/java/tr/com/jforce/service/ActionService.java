package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Action;

@Service
public interface ActionService {
	
	Action addAction(Action action);
	List<Action> findAll();

}
