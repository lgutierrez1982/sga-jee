package test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceLocal;

public class UsuarioServiceTest {

	private UsuarioServiceLocal usuarioServiceLocal;

	@Before
	public void setup() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		usuarioServiceLocal = (UsuarioServiceLocal) contenedor.getContext()
				.lookup("java:global/classes/UsuarioServiceImpl!mx.com.gm.sga.servicio.UsuarioServiceLocal");
	}
	
	
	@Test
	public void testEJBUsuarioServiceLocal(){
		System.out.println("Iniciando test EJB UsuarioServiceLocal");
		
		
			assertTrue(usuarioServiceLocal != null);
			
			//assertEquals(4, personaService.listarPersonas().size());
			
			System.out.println("El nro de usuarios es igual a:" + usuarioServiceLocal.listarUsuarios().size());
			
			this.desplegarUsuarios(usuarioServiceLocal.listarUsuarios());
			System.out.println("Fin Test EJB PersonaService");
		
		
	}

	private void desplegarUsuarios(List<Usuario> usuarios) {
		for(Usuario usuario : usuarios){
			System.out.println("Usuario Imprime " + usuario);
			System.out.println("Usuario Imprime " + usuario.getPersona().getNombre());
		}
		
	}

}
