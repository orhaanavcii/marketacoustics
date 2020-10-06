package tr.com.jforce.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ActionCommunityGroups")
public class ActionCommunityGroups extends BaseDbEntity {

	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "actionId")
	private Action action;
	
	@OneToOne
	@JoinColumn(name = "communityGroupId")
	private CommunityGroup communityGroup;
}
