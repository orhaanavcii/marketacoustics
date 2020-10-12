package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.ActionContentLink;
import tr.com.jforce.repository.ActionContentLinkRepository;
import tr.com.jforce.service.ActionContentLinkService;


@Service
public class IActionContentLinkService implements ActionContentLinkService {
	
	private final ActionContentLinkRepository actionContentLinkRepository;
	
	@Autowired
	public IActionContentLinkService(ActionContentLinkRepository actionContentLinkRepository) {
		this.actionContentLinkRepository = actionContentLinkRepository;
	}
	
	

	@Override
	public List<ActionContentLink> findAll() {
		return this.actionContentLinkRepository.findAll();
	}

	@Override
	public ActionContentLink saveActionCL(ActionContentLink actionContentLink) {
		return this.actionContentLinkRepository.save(actionContentLink);
	}

}
