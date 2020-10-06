package tr.com.jforce.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "ActionChannels")
public class ActionChannels extends BaseDbEntity {
	
	
	
	@JoinColumn(name = "actionId")
	@OneToOne(optional = true,fetch = FetchType.LAZY)
	private Action action;
	
	@JoinColumn(name = "channelId")
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Channel> channelList;

}
