package tr.com.jforce.util;

import lombok.Data;
import tr.com.jforce.entity.BaseDbEntity;

@Data
public class DependenciesCommunityRawData extends BaseDbEntity {

	private String data;
	private String andOr;
	private String inOut;
	
}
