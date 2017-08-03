package main.facade;

import easyaccept.EasyAccept;
import main.usuario.Usuario;
import main.usuario.UsuarioController;

/**
 * Classe responsabel pela interacao do administrador com o programa
 */
public class TTFacade {
	UsuarioController usuarioController;

	/**
	 * Contrutor da facade
	 */
	public TTFacade() {
		usuarioController = new UsuarioController();
	}

	/**
	 * Metodo onde se inicia o programa
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		args = new String[] { "main.facade.TTFacade", "us/us1_test.txt", "us/us2_test.txt" };
		EasyAccept.main(args);

	}

	/**
	 * Metodo que inicia o sistema
	 */
	public void iniciarSistema() {

	}

	/**
	 * Metodo que fecha o sistema
	 */
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
	 * @author Giovana Brito Oliveira - 116110904
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preco do item
	 * @param plataforma
	 *            plataforma do jogo eletronico
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		usuarioController.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	/**
	 * Metodo que cadastra um novo jogo de tabuleiro
	 * 
	 * @author Giovana Brito Oliveira - 116110904
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preco do item
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		usuarioController.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	/**
	 * Metodo que adiciona uma nova peca perdida
	 * 
	 * @author Giovana Brito Oliveira - 116110904
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param nomePeca
	 *            nome da peca perdida
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		usuarioController.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
	}

	/**
	 * 
	 * Metodo que retorna o atributo que se deseja saber sobre o item desejado
	 * 
	 * @author Giovana Brito Oliveira - 116110904
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do itemd desejado
	 * @param atributo
	 *            nome do atributo que se deseja obter
	 * @return atributo desejado
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return usuarioController.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	/**
	 * Metodo que cadastra um novo bluRay de serie
	 * 
	 * @author Giovana Brito Oliveira - 116110904
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preco do item
	 * @param descricao
	 *            descricao da serie
	 * @param duracao
	 *            duracao da serie
	 * @param classificacao
	 *            classificacao da serie
	 * @param genero
	 *            genero da serie
	 * @param temporada
	 *            temporada da serie
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		usuarioController.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao,
				genero, temporada);
	}

	// cadastrarBluRayFilme nome=Maria telefone=96666-6666 nomeItem=Crepusculo
	// preco=1.99 duracao=120 genero=ROMANCE classificacao=QUATORZE_ANOS
	// anoLancamento=2008>
	// TODO Terminar metodos aqui
}
