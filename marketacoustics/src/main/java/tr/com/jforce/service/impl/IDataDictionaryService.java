package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DataDictionary;
import tr.com.jforce.repository.DataDictionaryRepository;
import tr.com.jforce.service.DataDictionaryService;

@Service
public class IDataDictionaryService implements DataDictionaryService {

	private final DataDictionaryRepository dataDictionaryRepository;

	@Autowired
	public IDataDictionaryService(DataDictionaryRepository dataDictionaryRepository) {
		this.dataDictionaryRepository = dataDictionaryRepository;
	}

	@Override
	public DataDictionary saveDataDictionary(DataDictionary dataDictionary) {
		return this.dataDictionaryRepository.save(dataDictionary);
	}

	@Override
	public void deleteDataDictionary(Long id) {
		this.dataDictionaryRepository.deleteById(id);
	}

	@Override
	public List<DataDictionary> findAll() {
		return this.dataDictionaryRepository.findAll();
	}

}
