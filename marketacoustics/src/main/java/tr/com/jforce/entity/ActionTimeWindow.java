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
@Table(name = "ActionTimeWindow")
public class ActionTimeWindow extends BaseDbEntity {


	
	@JoinColumn(name = "actionId")
	@OneToOne(optional = true,fetch = FetchType.LAZY)
	private Action action;

	@Column(name = "startHour")
	private Long startHour;
	
	@Column(name = "startMinute")
	private Long startMinute;
	
	@Column(name = "finishHour")
	private Long finishHour;
	
	@Column(name = "finishMinute")
	private Long finishMinute;

}
