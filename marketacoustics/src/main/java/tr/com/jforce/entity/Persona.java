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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Persona")
public class Persona  extends BaseDbEntity{

	
	
	@JoinColumn(name = "clientId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private JFClient client;
	
	@Column(name = "personaCode", unique = true)
	private String personaCode;
	
	@Column(name = "personaDefination")
	private String personaDefination;

}
