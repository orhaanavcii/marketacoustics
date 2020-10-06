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
@Table(name = "Channel")
public class Channel extends BaseDbEntity {
	
	
	
	@Column(name = "channelName")
	private String channelName;
	
	@JoinColumn(name = "channelGroupId")
	@OneToOne(fetch = FetchType.LAZY)
	private ChannelGroups channelGroups;
	
	@Column(name = "channelDescription")
	private String channelDescription;
	
	

}
