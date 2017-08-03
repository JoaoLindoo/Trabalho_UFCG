package main.facade;

import easyaccept.EasyAccept;
import main.usuario.Usuario;
import main.usuario.UsuarioController;

/**
 * Classe responsabel pela interacao do administrador com o programa
 */
public class TTFacade {
	private UsuarioController usuarioController;

	public TTFacade() {
		usuarioController = new UsuarioController();
	}

	public static void main(String[] args) throws Exception {
		args = new String[] { "main.facade.TTFacade", "us/us1_test.txt", "us/us2_test.txt" };
		EasyAccept.main(args);

	}

	public void iniciarSistema() {

	}

	public void fecharSistema() {

	}

	/**
	 * Adiciona {@link Usuario} para um sistema
	 * 
	 * @param nome
	 *            nome do usuario a ser cadastrado
	 * @param telefone
	 *            telefone do usuario a ser cadastrado
	 * @param email
	 *            email do usuario a ser cadastrasdo
	 * @throws Exception
	 */
	public void cadastrarUsuario(String nome, String telefone, String email) throws Exception {
		usuarioController.adicionar(nome, telefone, email);
	}

	/**
	 * Recuperar informacoes de um usuario
	 * 
	 * @param nome
	 *            nome do usuario a ser pesquisado
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atribudo a ser atendido
	 * @return retorna uma string com atributos do ususario
	 * @throws Exception
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) throws Exception {
		return usuarioController.getInfoUsuario(nome, telefone, atributo);
	}

	/**
	 * Remove um usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @throws Exception
	 */
	public void removerUsuario(String nome, String telefone) throws Exception {
		usuarioController.removerUsuario(nome, telefone);
	}

	/**
	 * Edita um atributo de um usuario
	 * 
	 * @param nome
	 *            do usuario
	 * @param telefone
	 *            telefone
	 * @param atributo
	 *            atributo a ser atendido
	 * @param email
	 * @throws Exception
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String email) throws Exception {
		usuarioController.atualizarUsuario(nome, telefone, atributo, email);
	}
	/**
	 * Método que retorna a informação do item de acordo com o atributo.
	 * @param nome
	 * @param telefone
	 * @param itemNome
	 * @param atributo
	 * @return
	 */
	public String getInfoItem(String nome, String telefone, String itemNome, String atributo) {
		return  this.usuarioController.getInfoItem(nome, telefone, itemNome, atributo);
	}

}
