package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import tr.com.jforce.entity.DataSource;
import tr.com.jforce.service.DataSourceService;

@Scope("view")
@Component(value = "dataSourceController")
@Getter @Setter
public class DataSourceController {
	
	private List<DataSource> dataSourceList;
	private String selectedDataSource;
	private DataSource dataSource;
	
	private final DataSourceService dataSourceService;
	

	@Autowired
	public DataSourceController(DataSourceService dataSourceService) {
		this.dataSourceService = dataSourceService;
	}
	
	@PostConstruct
	public void init() {
		dataPreparation();
		findAll();
	}

	public void dataPreparation() {
		this.dataSourceList = new ArrayList<DataSource>();
		this.dataSource = new DataSource();
	}

	public void findAll() {
		this.dataSourceList = this.dataSourceService.findAll();
	}
	
	public void saveDataSource() {
		this.dataSourceService.saveDataSource(dataSource);
		this.dataSource = new DataSource();
		findAll();
	}
	
	public void deleteDataSource(Long id) {
		this.dataSourceService.deleteDataSource(id);
		findAll();
	}
	
	
	
	
	
	
	
	

}
