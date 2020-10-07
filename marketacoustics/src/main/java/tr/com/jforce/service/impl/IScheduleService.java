package tr.com.jforce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Schedule;
import tr.com.jforce.repository.ScheduleRepository;
import tr.com.jforce.service.ScheduleService;

@Service
public class IScheduleService implements ScheduleService {

	private final ScheduleRepository scheduleRepository;

	@Autowired
	public IScheduleService(ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return this.scheduleRepository.save(schedule);
	}

}
