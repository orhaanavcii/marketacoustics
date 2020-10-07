package tr.com.jforce.service;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Frequency;

@Service
public interface FrequencyService {

	Frequency findFrequencyByActionId(Long id);
	Frequency saveFrequency(Frequency frequency);
}
