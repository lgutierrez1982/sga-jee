package mx.com.gm.sga.servicio;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import mx.com.gm.sga.domain.Usuario;

@Remote
public interface UsuarioServiceRemote {

	public List<Usuario> listarUsuarios();

	public Usuario encontrarUsuarioporId(Usuario usuario);

	public Usuario encontrarUsuarioporUsername(Usuario usuario);

	public void registrarUsuario(Usuario usuario);

	public void modificiarUsuario(Usuario usuario);

	public void eliminarUsuario(Usuario usuario);

	// public void commitUsuario() ;

	// public void iniciaTransaccionUsuario();

	public EntityManager getEntityManager();

	public EntityTransaction getEntityTransaction();

}
