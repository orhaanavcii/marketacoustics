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
@Table(name = "DataDictionary")
public class DataDictionary extends BaseDbEntity {
	
	
	@Column(name = "fieldName")
	private String fieldName;
	
	@Column(name = "fieldDescription")
	private String fieldDescription;
	
	@Column(name = "fieldType")
	private String fieldType;
	
	@Column(name = "fieldLenght")
	private Long fieldLenght;
	
	@JoinColumn(name = "clientId")
	@OneToOne(optional = true , fetch = FetchType.LAZY)
	private JFClient client;

}
