package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionContentLink;

@Service
public interface ActionContentLinkService {
	
	List<ActionContentLink> findAll();
	ActionContentLink saveActionCL(ActionContentLink actionContentLink);

}
