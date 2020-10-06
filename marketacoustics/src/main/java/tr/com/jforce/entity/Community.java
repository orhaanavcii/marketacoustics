package tr.com.jforce.entity;

import java.util.List;

import javax.persistence.Column;
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
@Table(name = "Community")
public class Community extends BaseDbEntity {
	
	
	
	@Column(name = "communityCode")
	private String communityCode;
	
	@JoinColumn(name = "clientId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private JFClient client;
	
	

}
