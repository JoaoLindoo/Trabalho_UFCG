package main.controller;

import main.elementos.Usuario;
import main.repository.UsuarioRepository;

public class UsuarioController {
	private UsuarioRepository repository;
	private Usuario usuario;
	private static final String ATRIBUTO_EMAIL = "email";
	

	public UsuarioController() {
		repository = new UsuarioRepository();
	}

	public void adicionar(String nome, String telefone, String email) {
		usuario = new Usuario(nome, email, telefone);
		repository.adicionar(usuario);
	}

	public String getInfoUsuario(String nome, String atributo) {
		usuario = repository.recuperar(nome);
		if(usuario == null){
			return "Usuario invalido";
		}
		if (ATRIBUTO_EMAIL.equalsIgnoreCase(atributo)) {
			return usuario.getEmail();
		}
		return null;

	}
	public void removerUsuario(String nome,String telefone){
		usuario = repository.recuperar(nome);
		repository.remover(usuario);
	}
}
