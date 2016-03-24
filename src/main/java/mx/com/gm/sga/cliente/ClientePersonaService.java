package mx.com.gm.sga.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente \n");
		try {
			//llamado al EJB via remoto RMI ubicado en el paquete servicio(RMI se utiliza para realizar llamados a EJB en otros servidor de aplicaciones)
			Context jndi = new InitialContext();
			PersonaServiceRemote personaService = (PersonaServiceRemote) 
					jndi.lookup("java:global/sga-jee/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
					//nombre de aplicacion/
			List<Persona> personas = personaService.listarPersonas();
			
			for(Persona persona : personas){
				System.out.println(persona);
			}
			
			System.out.println("\n Fin llamada al EJB desde el Cliente");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
