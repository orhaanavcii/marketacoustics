package tr.com.jforce.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ActionTargetCommunityGroup")
public class ActionTargetCommunityGroup extends BaseDbEntity {
	
	
	
	@JoinColumn(name = "actionId")
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	private Action action;
	

	@JoinColumn(name = "communityId")
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Community> communityList;
	
	

}
