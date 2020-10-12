package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.DataDictionary;

@Service
public interface DataDictionaryService {

	DataDictionary saveDataDictionary(DataDictionary dataDictionary);
	void deleteDataDictionary(Long id);
	List<DataDictionary> findAll();
}
