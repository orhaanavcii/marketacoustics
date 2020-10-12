package tr.com.jforce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.com.jforce.entity.Persona;

@Service
public interface PersonaService {
	
	List<Persona> findAll();
	Persona savePersona(Persona persona);
	void deletePersona(Long id);

}
