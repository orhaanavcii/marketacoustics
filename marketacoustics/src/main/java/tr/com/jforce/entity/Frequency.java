package tr.com.jforce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	
	@Column(name = "frequencyCode", unique = true)
	private String FrequencyCode;
	
	@Column(name = "startNo")
	private String startNo;
	
	@Column(name = "finishNo")
	private String finishNo;
}
