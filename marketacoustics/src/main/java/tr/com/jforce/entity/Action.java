package tr.com.jforce.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Action")
public class Action extends BaseDbEntity{

	
	
	@Column(name = "actionCode")
	private String actionCode;
	
	@Column(name = "actionName")
	private String actionName;
	
	@JoinColumn(name = "targetAuidanceDataSourceId")
	@OneToOne(fetch = FetchType.LAZY)
	private DataSource targetAudianceDataSource;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	private Date validityStart;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	private Date validityEnd;
	
	@Column(name = "status")
	private Boolean status;
	
	@JoinColumn(name = "actionTypeId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private ActionType actionType;
	
	@JoinColumn(name = "clientId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private JFClient client;
	
	@Column(name = "maxTimeWindowForCustomer")
	private Long maxTimeWindowForCustomer;
	
	@Column(name = "maxTimeWindowForSales")
	private Long maxTimeWindowForSales;
	
	@Column(name = "dynamicFirstChannel")
	private Boolean dynamicFirstChannel;
	
	@Column(name = "dynamicSecondChannel")
	private Boolean dynamicSecondChannel;
	
	
	
}
