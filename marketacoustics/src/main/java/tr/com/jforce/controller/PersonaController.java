package tr.com.jforce.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import tr.com.jforce.entity.ChannelGroups;
import tr.com.jforce.entity.Persona;
import tr.com.jforce.service.ChannelGroupService;
import tr.com.jforce.service.PersonaService;

@Scope("view")
@Component(value = "personaController")
@Data
public class PersonaController {

	private final PersonaService personaService;
	private List<Persona> personaList;
	private Persona persona;
	
	@Autowired
	public PersonaController(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	

	@PostConstruct
	public void init() {
		
		dataPreparation();
		findAll();
		
	}
	
	
	public void savePersona() {
		this.personaService.savePersona(persona);
		findAll();
		this.persona = new Persona();
	}
	
	public void deletePersona(Long id) {
		this.personaService.deletePersona(id);
		findAll();
	}


	private void findAll() {
		this.personaList = this.personaService.findAll();
	}

	

	private void dataPreparation() {
		this.persona = new Persona();
	}
	
}
