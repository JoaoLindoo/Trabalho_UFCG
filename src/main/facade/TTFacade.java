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

	public void cadastrarUsuario(String nome, String telefone, String email) throws Exception {
		usuarioController.adicionar(nome, telefone, email);
	}
	public String getInfoUsuario(String nome,String telefone,String atributo) throws Exception{
		return usuarioController.getInfoUsuario(nome, atributo);
	}
	public void removerUsuario(String nome,String telefone) throws Exception{
		usuarioController.removerUsuario(nome, telefone);
	}
	public void atualizarUsuario(String nome,String telefone , String atributo,String email) throws Exception{
		usuarioController.atualizarUsuario(nome, telefone, atributo, email);
	}
	
}
