package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import tr.com.jforce.entity.Action;
import tr.com.jforce.entity.Frequency;
import tr.com.jforce.service.FrequencyService;

@Scope("view")
@Component(value = "frequencyController")
@Getter @Setter
public class FrequencyController {
	
	private final FrequencyService frequencyService;
	private List<String> frequencyPeriodList;
	private List<String> frequencyStartList;
	private List<Frequency> frequencyList;
	private Frequency frequency;
	private Boolean isDisabled;
	
	@Autowired
	public FrequencyController(FrequencyService frequencyService) {
		this.frequencyService = frequencyService;
	}
	
	@PostConstruct
	public void init() {
		
		loadData();
		
	}
	

	public void loadData() {
		this.frequencyPeriodList = new ArrayList<String>();
		this.frequencyPeriodList.add("Every Day");
		this.frequencyPeriodList.add("Every Week");
		this.frequencyPeriodList.add("Every Month");
		this.frequencyPeriodList.add("Every Year");
		
		this.frequencyStartList = new ArrayList<String>();
		this.frequencyStartList.add("1");
		this.frequencyStartList.add("2");
		this.frequencyStartList.add("3");
		this.frequencyStartList.add("4");
		this.frequencyStartList.add("5");
		
		this.frequency = new Frequency();
		this.frequencyList = new ArrayList<Frequency>();
		this.isDisabled = Boolean.FALSE;
	}
	
	public void save(Action action) {
		this.frequency.setAction(action);
		this.frequencyList.add(this.frequency);
		this.isDisabled = Boolean.TRUE;
	}

}
