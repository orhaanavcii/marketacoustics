package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionType;



@Service
public interface ActionTypeService {
	
	List<ActionType> findAll();
	
	

}
