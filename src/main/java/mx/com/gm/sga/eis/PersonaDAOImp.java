package mx.com.gm.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaDAOImp implements PersonaDAO{

	//@PersistenceContext(unitName="PersonaPRUEBA")  //esto es con JTA
	//EntityManager em;
	
	private EntityManager em = Persistence.createEntityManagerFactory("PersonaPRUEBA").createEntityManager();;
	private EntityTransaction tx = em.getTransaction();
	
		
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> findAllPersonas() {
		return em.createNamedQuery("Persona.findAll").getResultList();//se llama a la query ya creada en la clase Persona
	}

	@Override
	public Persona findPersonaById(Persona persona) {
		return em.find(Persona.class, persona.getIdPersona());
	}

	@Override
	public Persona findPersonaByEmail(Persona persona) {
		Query query = em.createQuery("from Persona p where p.email = :email");//se crea una nueva query
		query.setParameter("email", persona.getEmail());//se setea el parametro
		return (Persona) query.getSingleResult();
	}

	@Override
	public void insertPersona(Persona persona) {
		em.persist(persona);
		
	}

	@Override
	public void updatePersona(Persona persona) {
		em.merge(persona);//merge lo recupera y lo pone en memoria si ve que existen diferencias realiza el cambio y para terminar y realizar el cambio se debe realizar un commit
		em.close();
	}

	@Override
	public void deletePersona(Persona persona) {
		em.merge(persona);//lo recupera y poner en memoria
		em.remove(persona);//lo elimina no se puede remover directamente
		em.close();
	}

}
