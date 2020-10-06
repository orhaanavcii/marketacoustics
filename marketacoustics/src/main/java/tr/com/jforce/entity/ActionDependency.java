package tr.com.jforce.entity;

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
@Table(name = "ActionDependency")
public class ActionDependency extends BaseDbEntity {
	
	
	
	@JoinColumn(name = "actionId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private Action action;
	
	@JoinColumn(name = "communityId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private Community community;
	
	

}
