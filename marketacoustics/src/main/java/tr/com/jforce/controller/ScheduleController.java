package tr.com.jforce.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import tr.com.jforce.entity.Frequency;
import tr.com.jforce.entity.Schedule;
import tr.com.jforce.service.ScheduleService;

@Scope("view")
@Component(value = "scheduleController")
@Getter
@Setter
public class ScheduleController {

	private final ScheduleService scheduleService;
	private Schedule schedule;
	private Date startTime;
	private Date endTime;
	private List<String> dates;
	private Frequency frequency;

	@Autowired
	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@PostConstruct
	public void init() {

		loadData();

	}

	public void loadData() {

		this.schedule = new Schedule();
		this.dates = new ArrayList<String>();

	}

	public void save(Frequency frequency) {
		DateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		DateFormat dateFormatter2 = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dateFormatter3 = new SimpleDateFormat("E");
		DateFormat dateFormatter4 = new SimpleDateFormat("dd");
		DateFormat dateFormatter5 = new SimpleDateFormat("dd/MM");
		this.dates = new ArrayList<String>();
		if (frequency.getFrequencyPeriod() == "Every Day") {
			this.schedule.setDates(null);
			this.dates.add("Every Day");
		} else if (frequency.getFrequencyPeriod() == "Every Week") {

			this.schedule.getDates().forEach(x -> {
				this.dates.add(dateFormatter3.format(x));
			});

		} else if (frequency.getFrequencyPeriod() == "Every Month") {
			this.schedule.getDates().forEach(x -> {
				this.dates.add(dateFormatter4.format(x));
			});

		} else if (frequency.getFrequencyPeriod() == "Every Year") {
			this.schedule.getDates().forEach(x -> {
				this.dates.add(dateFormatter5.format(x));
			});
		} else {
			// null olma durumu
		}
		this.schedule.setStartTime(dateFormatter.format(this.startTime));
		this.schedule.setEndTime(dateFormatter.format(this.endTime));
		this.frequency = frequency;
		this.frequency.setSchedule(schedule);
	}

}
