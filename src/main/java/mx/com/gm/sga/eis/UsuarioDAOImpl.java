package mx.com.gm.sga.eis;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mx.com.gm.sga.domain.Usuario;

@Stateless
public class UsuarioDAOImpl implements UsuarioDAO {

	// @PersistenceContext(unitName="PersonaPRUEBA") //esto es con JTA
	// EntityManager em;

	private EntityManager em = Persistence.createEntityManagerFactory("PersonaPRUEBA").createEntityManager();
	private EntityTransaction tx = em.getTransaction();

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAllUsuarios() {
		// se llama a la query ya creada en la clase Usuario
		return em.createNamedQuery("Usuario.findAll").getResultList();
	}

	@Override
	public Usuario findUsuarioById(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	@Override
	public Usuario findUsuarioByUsername(Usuario usuario) {
		return em.find(Usuario.class, usuario.getUsername());
	}

	@Override
	public void insertUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		em.merge(usuario);
		em.close();

	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		em.merge(usuario);
		em.remove(usuario);
		em.close();

	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public EntityTransaction getEntityTransaction() {
		return tx;
	}

	public void setEntityTransaction(EntityTransaction tx) {
		this.tx = tx;
	}

}
