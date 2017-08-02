package main.facade;

import main.controller.UsuarioController;

public class TTFacade {
	UsuarioController usuarioController;

	public TTFacade() {
		usuarioController = new UsuarioController();
	}

	public void iniciaSistema() {

	}

	public void fechaSistema() {

	}

	public void cadastrarUsuario(String nome, String telefone, String email) {
		usuarioController.adicionar(nome, telefone, email);
	}
	public String getInfoUsuario(String nome,String telefone,String atributo){
		return usuarioController.getInfoUsuario(nome, atributo);
	}
	public void removerUsuario(String nome,String telefone){
		usuarioController.removerUsuario(nome, telefone);
	}
}
