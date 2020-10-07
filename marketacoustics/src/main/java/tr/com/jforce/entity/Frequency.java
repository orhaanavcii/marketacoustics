package tr.com.jforce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Frequency")
public class Frequency extends BaseDbEntity {

	
	@Column(name = "frequencyPeriod", unique = true)
	private String frequencyPeriod;
	
	@Column(name = "repeatNo")
	private String repeatNo;
	
	@JoinColumn(name = "actionId")
	@OneToOne(fetch = FetchType.LAZY,optional = true)
	private Action action;
	
	@JoinColumn(name = "scheduleId")
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	private Schedule schedule;
}
