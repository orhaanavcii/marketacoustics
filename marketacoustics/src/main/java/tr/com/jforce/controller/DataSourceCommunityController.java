package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.DataSource;
import tr.com.jforce.entity.DataSourceCommunity;
import tr.com.jforce.service.DataSourceCommunityService;

@Scope("view")
@Component(value = "dataSourceCommunityC")
@Data
public class DataSourceCommunityController {
	
	private final DataSourceCommunityService dataSourceCommunityService;
	private DataSourceCommunity dataSourceCommunity;
	private List<DataSourceCommunity> dataSourceCommunityList;
	private String targetAudianceDataSourceId;
	private List<Community> communityIdList;
	
	
	@Autowired
	public DataSourceCommunityController(DataSourceCommunityService dataSourceCommunityService) {
		this.dataSourceCommunityService = dataSourceCommunityService;
	}
	
	@PostConstruct
	public void init() {
		
		dataPreparation();
		findAll();
	}

	public void dataPreparation() {
		dataSourceCommunity = new DataSourceCommunity();
		dataSourceCommunityList = new ArrayList<DataSourceCommunity>();
	}
	
	public void addDataSourceCommunity() {
		
		dataSourceCommunity.setCommunityList(this.communityIdList);
		dataSourceCommunity.setTargetAudianceDataSource(new DataSource());
		dataSourceCommunity.getTargetAudianceDataSource().setId(Long.valueOf(this.targetAudianceDataSourceId));
		this.dataSourceCommunityService.addDataSourceCommunity(dataSourceCommunity);
		this.dataSourceCommunity = new DataSourceCommunity();
		findAll();
	}
	
	public void findAll() {
		this.dataSourceCommunityList = this.dataSourceCommunityService.findAll();
	}
	
	
	public void deleteDataSourceCommunity(Long id) {
		this.dataSourceCommunityService.deleteDataSourceCommunity(id);
	}

}
