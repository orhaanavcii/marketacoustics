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
import tr.com.jforce.repository.CommunityRepository;

@Component("selectManyMenuConverter")
@FacesConverter("selectManyMenuConverter")
public class SelectManyMenuConverter implements Converter{
	private final CommunityRepository cRepo;
	
	@Autowired
	public SelectManyMenuConverter(CommunityRepository cRepo) {
		this.cRepo = cRepo;
	}
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return this.cRepo.getOne(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Long id = (value instanceof BaseDbEntity) ? ((BaseDbEntity) value).getId() : null;
        return (id != null) ? String.valueOf(id) : null;
	}
	
	
	

}
