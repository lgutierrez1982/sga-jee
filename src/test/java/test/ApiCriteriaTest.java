package test;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.servicio.UsuarioServiceLocal;

public class ApiCriteriaTest {
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
		System.out.println("Iniciando test Creacion API Criteria");

		
		
		//1. el objeto EntotyManager crear instancia CriteriaBuilder
		CriteriaBuilder cb = usuarioServiceLocal.getEntityManager().getCriteriaBuilder();
		
		//2. Se crea un objeto CriteriaQuery
		CriteriaQuery<Usuario> criteriaQuery = cb.createQuery(Usuario.class);
		
		//3. Creamos el objeto Raiz del query
		Root<Usuario> fromUsuario = criteriaQuery.from(Usuario.class);
		
		//4. Seleccionamos lo necesario del from
		criteriaQuery.select(fromUsuario);
		
		//5. Creamos el query typesafe
		TypedQuery<Usuario> query = usuarioServiceLocal.getEntityManager().createQuery(criteriaQuery);
		
		//6. Ejecutar la consulta
		List<Usuario> usuarios = query.getResultList();
		for(Usuario u: usuarios){
			log.debug(u);
		}
		
		System.out.println("Fin test Creacion API Criteria");
		
	}

}
