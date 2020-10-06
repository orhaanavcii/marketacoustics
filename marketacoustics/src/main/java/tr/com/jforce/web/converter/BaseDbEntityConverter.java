package tr.com.jforce.web.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;
import org.springframework.stereotype.Component;

import tr.com.jforce.entity.BaseDbEntity;

@Component("baseDbEntityConverter")
@FacesConverter("baseDbEntityConverter")
public class BaseDbEntityConverter implements Converter{
	
		
	 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
	        PickList  p = (PickList) component;
	        DualListModel dl = (DualListModel) p.getValue();
	        return dl.getSource().get(Integer.valueOf(submittedValue));
	    }

	    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
	        PickList  p = (PickList) component;
	        DualListModel dl = (DualListModel) p.getValue();
	        return  String.valueOf(dl.getSource().indexOf(value));
	    }

}
