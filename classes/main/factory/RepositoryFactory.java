package main.factory;

import main.repository.UsuarioRepository;

public class RepositoryFactory {
	
	private static UsuarioRepository usuarioRepository;
	
	public UsuarioRepository criaRepository() {
		if (usuarioRepository == null) {
			usuarioRepository = new UsuarioRepository();
		}
		return usuarioRepository ;
	}
}