package tr.com.jforce.entity;

import java.util.Date;

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
@Table(name = "ActionFrequency")
public class ActionFrequency extends BaseDbEntity {
	
	
	
	@JoinColumn(name = "actionId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private Action action;
	
	@JoinColumn(name = "frequencyId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private Frequency frequency;
	
	@Column(name = "takeActionOn")
	private Long takeActionOn;
	
	
	
	

}
