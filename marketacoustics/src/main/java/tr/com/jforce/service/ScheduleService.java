package tr.com.jforce.service;


import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Schedule;

@Service
public interface ScheduleService {
	
	Schedule saveSchedule(Schedule schedule);

}
