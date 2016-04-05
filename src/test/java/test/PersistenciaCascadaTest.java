package test;

import javax.ejb.embeddable.EJBContainer;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceLocal;

public class PersistenciaCascadaTest {

	private UsuarioServiceLocal usuarioServiceLocal;
	Logger log = Logger.getLogger("TestEntidadPersona");
	
	@Before
	public void setup() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioServiceLocal = (UsuarioServiceLocal) contenedor.getContext()
				.lookup("java:global/classes/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioServiceLocal");
	}
	
	
	@Test
	public void testEJBUsuarioServiceLocal(){
		System.out.println("Iniciando test Insercion Cascada");
		
		//tx.begin()
		usuarioServiceLocal.getEntityTransaction().begin();
		
		
		//Creamos el objeto persona(es el menos dependiente)
		Persona persona1 = new Persona("Hugo", "Sanchez", "Pinto", "hsanchez@gmail.com","0968333444");
		
		//Creamos el objeto usuario(tiene dependencia con un objeto persona)
		Usuario usuario1 = new Usuario("hsanchez", "123", persona1);
			
		//solo persistimos el objeto usuario
		//no hay necesidad de persistir el objeto Persona
		//em.persit(usuario1)
		usuarioServiceLocal.registrarUsuario(usuario1);
		
		//tx.commit()
		usuarioServiceLocal.getEntityTransaction().commit();
		
		//Ya debe tener el objeto persona y su PK asociada
		log.debug("Objeto recuperado:" + usuario1);
			
		
		
		
	}

}
