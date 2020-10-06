package tr.com.jforce.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Scope("view")
@Component(value = "testController")
public class TestController {
	private DualListModel<String> namez;
	private List<String> names; 
	private String a ;
	private Boolean checkStatus;
	private Date validateDate;
	
	
	
		@PostConstruct
		public void init() {
			
			names = new ArrayList<String>();
			names.add("Every Day");
			names.add("Every Week");
			names.add("Every Year");
			
			
			
			List<String> namezTarget = new ArrayList<String>();
			this.namez = new DualListModel<String>(this.names, namezTarget);
	
		}
	
	
	
	
	
	 public DualListModel<String> getNamez() {
		return namez;
	}





	public void setNamez(DualListModel<String> namez) {
		this.namez = namez;
	}





	public Date getValidateDate() {
		return validateDate;
	}



	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}



	public Boolean getCheckStatus() {
		return checkStatus;
	}
	
	
	public void setCheckStatus(Boolean checkStatus) {
		this.checkStatus = checkStatus;
	}



	public void onTabChange(TabChangeEvent event) {
	        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	         
	    public void onTabClose(TabCloseEvent event) {
	        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	    
	    public void gettesty() {
	    	String b = a;
	    	System.out.println(b);
	    }

	    
	public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}

	public List<String> getNames() {
	
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
	
	

	
	

}
