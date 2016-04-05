package mx.com.gm.sga.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import mx.com.gm.sga.domain.Usuario;
import mx.com.gm.sga.eis.UsuarioDAO;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceLocal, UsuarioServiceRemote {

	@EJB 
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioDAO.findAllUsuarios();
	}

	@Override
	public Usuario encontrarUsuarioporId(Usuario usuario) {
		return usuarioDAO.findUsuarioById(usuario);
	}

	@Override
	public Usuario encontrarUsuarioporUsername(Usuario usuario) {
		return usuarioDAO.findUsuarioByUsername(usuario);
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		usuarioDAO.insertUsuario(usuario);

	}

	@Override
	public void modificiarUsuario(Usuario usuario) {
		usuarioDAO.updateUsuario(usuario);

	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		usuarioDAO.deleteUsuario(usuario);

	}
	
	/*@Override
	public void commitUsuario() {
		usuarioDAO.getEntityTransaction().commit();

	}
	
	@Override
	public void iniciaTransaccionUsuario() {
		usuarioDAO.getEntityTransaction().begin();;

	}*/
	
	
	public EntityManager getEntityManager(){
		return usuarioDAO.getEntityManager();

	}

	public EntityTransaction getEntityTransaction(){
		return  usuarioDAO.getEntityTransaction();

	}

}
