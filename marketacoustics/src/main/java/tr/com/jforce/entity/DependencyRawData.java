package tr.com.jforce.entity;

import java.util.Date;
import java.util.List;

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
@Table(name = "DependencyRawData")
public class DependencyRawData extends BaseDbEntity {
	
	
	
	@JoinColumn(name = "actionId")
	@OneToOne(fetch = FetchType.LAZY)
	private Action action;
	
	@JoinColumn(name = "dependencyId")
	@OneToOne(fetch = FetchType.LAZY)
	private ActionDependencies actionDependencies;
	
	@Column(name = "mustBeIn")
	private Boolean mustBeIn;
	
	
	


}
