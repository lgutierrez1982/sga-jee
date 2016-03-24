package mx.com.gm.sga.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.eis.PersonaDAO;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService {

	@EJB
	private PersonaDAO personaDAO;
	
	public List<Persona> listarPersonas() {
		
		return personaDAO.findAllPersonas();
		
	}

	public Persona encontrarPersonaPorId(Persona persona) {
		return personaDAO.findPersonaById(persona);

	}

	public Persona encontrarPersonaPorEmail(Persona persona) {
		return personaDAO.findPersonaByEmail(persona);
	}

	public void registrarPersona(Persona persona) {
		personaDAO.insertPersona(persona);	
	}

	public void modificarPersona(Persona persona) {
		personaDAO.updatePersona(persona);

	}

	public void eliminarPersona(Persona persona) {
		personaDAO.deletePersona(persona);
	}
	

}
