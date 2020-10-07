package tr.com.jforce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Frequency;
import tr.com.jforce.repository.FrequencyRepository;
import tr.com.jforce.service.FrequencyService;

@Service
public class IFrequencyService implements FrequencyService {
	
	private final FrequencyRepository frequencyRepository;
	
	@Autowired
	public IFrequencyService(FrequencyRepository frequencyRepository) {
		this.frequencyRepository = frequencyRepository;
	}
	

	@Override
	public Frequency findFrequencyByActionId(Long id) {
		return this.frequencyRepository.findFrequencyByActionId(id);
	}

	@Override
	public Frequency saveFrequency(Frequency frequency) {
		return this.frequencyRepository.save(frequency);
	}

}
