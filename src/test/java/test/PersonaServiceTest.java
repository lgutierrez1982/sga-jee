package test;

import static org.junit.Assert.*;

import java.util.List;


import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

public class PersonaServiceTest {
	
	private PersonaService personaService;
	
	@Before
	public void setUP() throws Exception{
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = (PersonaService) 
				contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaService");
	}
	
	@Test
	public void testEJBPersonaService(){
		System.out.println("Iniciando test EJB PersonaService");
		
		
			assertTrue(personaService != null);
			
			//assertEquals(4, personaService.listarPersonas().size());
			
			System.out.println("El nro de personas es igual a:" + personaService.listarPersonas().size());
			
			this.desplegarPersonar(personaService.listarPersonas());
			System.out.println("Fin Test EJB PersonaService");
		
		
	}

	private void desplegarPersonar(List<Persona> personas) {
		for(Persona persona : personas){
			System.out.println("Persona Imprime " + persona);
		}
		
	}

}
