package main.facade;

import easyaccept.EasyAccept;
import main.controller.UsuarioController;

public class TTFacade {
	UsuarioController usuarioController;

	public TTFacade() {
		usuarioController = new UsuarioController();
	}

	public static void main(String[] args) throws Exception {
		args = new String[] { "main.facade.TTFacade", "us/us1_test.txt", "us/us2_test.txt"};
		EasyAccept.main(args);

	}

	public void iniciarSistema() {

	}

	public void fecharSistema() {

	}

	public void cadastrarUsuario(String nome, String telefone, String email) throws Exception {
		usuarioController.adicionar(nome, telefone, email);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) throws Exception {
		return usuarioController.getInfoUsuario(nome, atributo);
	}

	public void removerUsuario(String nome, String telefone) throws Exception {
		usuarioController.removerUsuario(nome, telefone);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String email) throws Exception {
		usuarioController.atualizarUsuario(nome, telefone, atributo, email);
	}

}
