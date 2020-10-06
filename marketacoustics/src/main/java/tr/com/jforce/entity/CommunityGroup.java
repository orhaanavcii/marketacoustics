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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ComminityGroup")
public class CommunityGroup extends BaseDbEntity {
	
	
	
	@Column(name = "communityGroupName")
	private String communityGroupName;
	
	@JoinColumn(name = "communityGroupId")
	@OneToMany(fetch = FetchType.LAZY)
	private List<Community> communityGroup;
	

}
