package tr.com.jforce.web.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.selectmanymenu.SelectManyMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tr.com.jforce.entity.BaseDbEntity;
import tr.com.jforce.entity.Community;
import tr.com.jforce.entity.DataDictionary;
import tr.com.jforce.repository.CommunityRepository;
import tr.com.jforce.repository.DataDictionaryRepository;

@Component("selectManyMenuConverterForDbEntity")
@FacesConverter("selectManyMenuConverterForDbEntity")
public class SelectManyMenuConverterForDbEntity implements Converter{
	private final CommunityRepository cRepo;
	private final DataDictionaryRepository dRepo;

	
	@Autowired
	public SelectManyMenuConverterForDbEntity(CommunityRepository cRepo,DataDictionaryRepository dRepo) {
		this.cRepo = cRepo;
		this.dRepo = dRepo;
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
			
			if(this.cRepo.existsById(Long.valueOf(value))) {
				return this.cRepo.getOne(Long.valueOf(value));
			}else if (this.dRepo.existsById(Long.valueOf(value))) {
				return this.dRepo.getOne(Long.valueOf(value));
			}
			
			return null;
	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Long id = (value instanceof BaseDbEntity) ? ((BaseDbEntity) value).getId() : null;
        return (id != null) ? String.valueOf(id) : null;
	}
	
	
	

}
