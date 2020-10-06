package tr.com.jforce.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import tr.com.jforce.entity.Channel;
import tr.com.jforce.entity.DataSource;
import tr.com.jforce.service.DataSourceService;

@Scope("view")
@Component(value = "dataSourceController")
@Getter @Setter
public class DataSourceController {
	
	private List<DataSource> dataSourceList;
	private String selectedDataSource;
	
	private final DataSourceService dataSourceService;
	

	@Autowired
	public DataSourceController(DataSourceService dataSourceService) {
		this.dataSourceService = dataSourceService;
	}
	
	@PostConstruct
	public void init() {
		this.dataSourceList = this.dataSourceService.findAll();
	}
	
	
	
	
	
	
	
	

}
