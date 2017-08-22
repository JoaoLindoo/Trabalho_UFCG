package main.util;
import java.util.List;
import main.elementos.Usuario;
import main.repository.UsuarioRepository;

public class Util {
	private UsuarioRepository usuarioRepository ;
	
	public Util(UsuarioRepository usRepositorio) {
		this.usuarioRepository = usRepositorio;
	}

	public Usuario retornaUsuario(String nome,String telefone) {
		return this.usuarioRepository.recuperar(nome, telefone);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.getUsuarios();
	}
	
}
