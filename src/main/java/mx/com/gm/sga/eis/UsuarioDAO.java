package mx.com.gm.sga.eis;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import mx.com.gm.sga.domain.Usuario;

public interface UsuarioDAO {

	public List<Usuario> findAllUsuarios();

	public Usuario findUsuarioById(Usuario usuario);

	public Usuario findUsuarioByUsername(Usuario usuario);

	public void insertUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(Usuario usuario);

	public EntityManager getEntityManager(); 

	public EntityTransaction getEntityTransaction();
	
	

	
}
