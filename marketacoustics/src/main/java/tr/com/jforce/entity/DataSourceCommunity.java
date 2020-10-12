package tr.com.jforce.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DataSourceCommunity")
public class DataSourceCommunity extends BaseDbEntity {
	
	
	@JoinColumn(name = "clientId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private JFClient client;
	
	@JoinColumn(name = "targetAuidanceDataSourceId", unique = true)
	@OneToOne(fetch = FetchType.LAZY)
	private DataSource targetAudianceDataSource;
	
	@JoinColumn(name = "communityId", unique = true)
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Community> communityList;
}
