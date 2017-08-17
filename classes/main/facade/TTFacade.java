package main.facade;

import java.text.ParseException;

import easyaccept.EasyAccept;
import main.controller.SistemaController;
import main.elementos.Usuario;
import main.exception.DadoInvalido;

/**
 * Classe responsabel pela interacao do administrador com o programa
 */
public class TTFacade {
	private SistemaController sistemaController;

	/**
	 * Contrutor da facade
	 */
	public TTFacade() {
		sistemaController = new SistemaController();

	}

	/**
	 * Metodo onde se inicia o programa
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		args = new String[] { "main.facade.TTFacade", "us/us1_test.txt", "us/us2_test.txt", "us/us3_test.txt",
				"us/us4_test.txt", "us/us5_test.txt", "us/us6_test.txt" };
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
		sistemaController.adicionar(nome, telefone, email);
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
		return sistemaController.getInfoUsuario(nome, telefone, atributo);
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
		sistemaController.removerUsuario(nome, telefone);
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
		sistemaController.atualizarUsuario(nome, telefone, atributo, email);
	}

	/**
	 * Método que retorna a informação do item de acordo com o atributo.
	 * 
	 * @param nome
	 * @param telefone
	 * @param itemNome
	 * @param atributo
	 * @return
	 * @throws Exception
	 */
	public String getInfoItem(String nome, String telefone, String itemNome, String atributo) throws Exception {
		return this.sistemaController.getInfoItem(nome, telefone, itemNome, atributo);
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
	 * @throws Exception
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws Exception {
		sistemaController.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
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
	 * @throws Exception
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws Exception {
		sistemaController.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
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
		sistemaController.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);
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
	 * @throws Exception
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {
		sistemaController.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao,
				genero, temporada);
	}

	/**
	 * Metodo que cadastra um novo blutay de filme
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param valor
	 *            valor do item
	 * @param duracao
	 *            duracao do item
	 * @param genero
	 *            genero do item
	 * @param classificacao
	 *            classificacao do item
	 * @param anoDeLancamento
	 *            ano de lancamento do filme
	 * @throws Exception
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double valor, int duracao,
			String genero, String classificacao, String anoDeLancamento) throws Exception {
		sistemaController.cadastrarBluRayFilme(nome, telefone, nomeItem, valor, duracao, genero, classificacao,
				anoDeLancamento);

	}

	/**
	 * Metodo que cadastra um show
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param valor
	 *            valor do item
	 * @param duracao
	 *            duracao do show
	 * @param numeroDeFaixas
	 *            numero de faixas do show
	 * @param artista
	 *            nome do artista do show
	 * @param classificacao
	 *            classificacao do show
	 * @throws Exception
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double valor, int duracao,
			int numeroDeFaixas, String artista, String classificacao) throws Exception {
		sistemaController.cadastrarBluRayShow(nome, telefone, nomeItem, valor, duracao, numeroDeFaixas, artista,
				classificacao);

	}

	/**
	 * Metodo que adiciona um episodio na serie
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param duracao
	 *            duracao do episodio
	 * @throws DadoInvalido
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeItem, int duracao) throws DadoInvalido {
		sistemaController.adicionarBluRay(nome, telefone, nomeItem, duracao);
	}

	/**
	 * Metodo que remove um item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @throws Exception
	 */
	public void removerItem(String nome, String telefone, String nomeItem) throws Exception {
		sistemaController.removerItem(nome, telefone, nomeItem);
	}

	/**
	 * Metodo que atualiza o nome do item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo a ser mudado
	 * @param valor
	 *            novo nome
	 * @throws Exception
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws Exception {
		sistemaController.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	/**
	 * Metodo que lista todos os objetos em ordem alfabetica.
	 * 
	 * @return uma lista em String de itens
	 */
	public String listarItensOrdenadosPorNome() {
		return this.sistemaController.listarItensOrdenadosPorNome();
	}

	/**
	 * Metodo que lista todos os objetos em ordem de valor.
	 * 
	 * @return uma lista em String de itens
	 */
	public String listarItensOrdenadosPorValor() {
		return this.sistemaController.ordenacaoItensValor();
	}

	/**
	 * Metodo que pesquisa o item com a descrição completa.
	 * 
	 * @param nome
	 *            em String
	 * @param telefone
	 *            em String
	 * @param nomeItem
	 *            em String
	 * @return a descrição do item em string
	 * @throws Exception
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) throws Exception {
		return this.sistemaController.pesquisarDetalhesItem(nome, telefone, nomeItem);
	}

	/**
	 * Metodo que registra um emprestimo
	 * 
	 * @param nomeDono
	 *            nome do dono do item
	 * @param telefoneDono
	 *            telefone do dono do item
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            telefone do requerente
	 * @param nomeItem
	 *            nome do item
	 * @param dataEmprestimo
	 *            data do emprestimo
	 * @param periodo
	 *            periodo de emprestimo
	 * @throws Exception
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws Exception {
		sistemaController.registrarEmprestimo(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, periodo);
	}

	/**
	 * Metodo que edevolve um item ao seu dono original
	 * 
	 * @param nomeDono
	 *            nome do dono do item
	 * @param telefoneDono
	 *            telefone do dono do item
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            tefelone do requerente
	 * @param nomeItem
	 *            nome do item
	 * @param dataEmprestimo
	 *            data de emprestimo
	 * @param dataDevolucao
	 *            data da devolucao
	 * @throws Exception
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws Exception {
		sistemaController.devolverItem(nomeDono, telefoneDono, nomeRequerente, telefoneRequerente, nomeItem,
				dataEmprestimo, dataDevolucao);
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) throws Exception {
		return sistemaController.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}
	
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) throws Exception {
		return sistemaController.listarEmprestimosUsuarioPegandoEmprestado(nome, telefone);
	}
	
	public String listarEmprestimosItem(String nomeItem) {
		return sistemaController.listarEmprestimosItem(nomeItem);
	}
	
	public String listarItensEmprestados() {
		return sistemaController.listarItensEmprestados();
	}
	public String  listarItensNaoEmprestados() {
		return this.sistemaController.listarItensNaoEmprestados();
	}
	
	public String listarTop10Itens() {
		return sistemaController.listarTop10Itens();
	}
	
}
