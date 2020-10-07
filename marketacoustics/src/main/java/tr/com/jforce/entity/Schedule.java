package tr.com.jforce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends BaseDbEntity {

	@Column(name = "dates")
	@Temporal(TemporalType.DATE)
	@ElementCollection
	private List<Date> dates;
	
	@Column(name = "startTime")
	private String startTime;
	
	@Column(name = "endTime")
	private String endTime;

}
