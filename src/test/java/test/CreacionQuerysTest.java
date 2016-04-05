package test;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceLocal;

public class CreacionQuerysTest {

	private UsuarioServiceLocal usuarioServiceLocal;
	Logger log = Logger.getLogger("TestEntidadUsuario");

	@Before
	public void setup() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioServiceLocal = (UsuarioServiceLocal) contenedor.getContext()
				.lookup("java:global/classes/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioServiceLocal");
	}

	@Test
	public void testCrearQueriesUsuarioServiceLocal() {
		System.out.println("Iniciando test Creacion Queries");

		
		String jqpl = null;
		List<Usuario> usuarios;
		
		// tx.begin()
		usuarioServiceLocal.getEntityTransaction().begin();
		
		
		
		//1) Consulta de todos los usuarios
		log.debug("1); Consulta de todas los usuarios");
		
		jqpl = "select u from Usuario u";
		
		//para listas getResultList() para un solo valor getSingleResult()
		usuarios = usuarioServiceLocal.getEntityManager().createQuery(jqpl).getResultList();
		for(Usuario u: usuarios){
			log.debug(u);
		}
		
		
		System.out.println("Termina test Creacion Queries");
		
		
		

	}

}
