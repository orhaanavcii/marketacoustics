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
@Table(name = "ActionContentLink")
public class ActionContentLink extends BaseDbEntity {

	

	@Column(name = "ageGroup")
	private String ageGroup;

	@Column(name = "persona")
	private String persona;

	@Column(name = "lifeStage")
	private String lifeStage;

	@Column(name = "contentLink")
	private String contentLink;

	@Column(name = "basicContent")
	private String basicContent;

	@JoinColumn(name = "channelGroupId")
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	private ChannelGroups channelGroup;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "actionId")
	private Action action;
	
	@JoinColumn(name = "clientId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private JFClient client;

}
