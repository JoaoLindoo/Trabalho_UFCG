package main.util;
import java.util.List;
import main.elementos.Usuario;
import main.factory.RepositoryFactory;
import main.repository.UsuarioRepository;

public class Util {
	private UsuarioRepository usuarioRepository ;
	
	
	public Util() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();
		this.usuarioRepository = repositoryFactory.criaRepository();
	}
	

	public Usuario retornaUsuario(String nome,String telefone) {
		return this.usuarioRepository.recuperar(nome, telefone);
	}
	public List<Usuario> getUsuarios() {
		return usuarioRepository.getUsuarios();
	}
}
