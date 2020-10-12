package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.DataDictionary;
import tr.com.jforce.service.DataDictionaryService;

@Scope("view")
@Component(value = "dataDictionaryController")
@Data
public class DataDictionaryController {

	private final DataDictionaryService dataDictionaryService;
	private DataDictionary dataDictionary;
	private List<DataDictionary> dataDictionaryList;
	private List<String> fieldTypeList;

	@Autowired
	public DataDictionaryController(DataDictionaryService dataDictionaryService) {
		this.dataDictionaryService = dataDictionaryService;
	}
	
	@PostConstruct
	public void init() {
		dataPreparation();
	}

	public void dataPreparation() {
		
		this.fieldTypeList = new ArrayList<String>();
		fieldTypeList.add("INT");
		fieldTypeList.add("STRING");
		fieldTypeList.add("BOOLEAN");
		
		this.dataDictionary = new DataDictionary();
		this.dataDictionaryList = new ArrayList<DataDictionary>();
	}
	
	public void saveDataDictionary() {
		this.dataDictionaryService.saveDataDictionary(dataDictionary);
		this.dataDictionary = new DataDictionary();
		findAll();
	}
	public void deleteDataDictionary(Long id) {
		this.dataDictionaryService.deleteDataDictionary(id);
		findAll();
	}
	public void findAll() {
		this.dataDictionaryList = this.dataDictionaryService.findAll();
	}

}
