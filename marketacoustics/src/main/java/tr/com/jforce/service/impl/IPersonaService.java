package tr.com.jforce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Persona;
import tr.com.jforce.repository.PersonaRepository;
import tr.com.jforce.service.PersonaService;

@Service
public class IPersonaService implements PersonaService {
	
	private final PersonaRepository personaRepository;
	
	@Autowired
	public IPersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

	@Override
	public List<Persona> findAll() {
		return this.personaRepository.findAll();
	}

	@Override
	public Persona savePersona(Persona persona) {
		return this.personaRepository.save(persona);
	}

	@Override
	public void deletePersona(Long id) {
		this.personaRepository.deleteById(id);
	}

}
