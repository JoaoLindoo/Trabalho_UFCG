package main.service;
import java.util.List;

import main.elementos.Usuario;
import main.exception.DadoInvalido;
import main.factory.RepositoryFactory;
import main.repository.UsuarioRepository;

public class SistemaService {
	private UsuarioRepository usuarioRepository ;
	
	
	public SistemaService() {
		RepositoryFactory repositoryFactory = new RepositoryFactory();
		this.usuarioRepository = repositoryFactory.criaRepository();
	}
	
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws Exception {
		retornaUsuario(nome, telefone).adiconarItemJogoEletronico(nomeItem, preco, plataforma);
	}
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws Exception{
		retornaUsuario(nome, telefone).adicionarItemJogoTabuleiro(nomeItem, preco);

	}

	/**
	 * Adicionar peca percida do jogo de taboleiro
	 * 
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
		retornaUsuario(nome, telefone).adicionarPecaperdida(nomeItem, nomePeca);

	}

	/**
	 * Cadastrar BluRaySerie
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do serie
	 * @param preco
	 *            preco do serie
	 * @param descricao
	 *            descricao o serie
	 * @param duracao
	 *            duracao da serie
	 * @param classificacao
	 *            classificacao da serie
	 * @param genero
	 *            genero da serie
	 * @param temporada
	 *            temporada que da serie
	 * @throws Exception
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) throws Exception {
		retornaUsuario(nome, telefone).adicionarItemSerie(nomeItem, preco, descricao, duracao, classificacao,
				genero, temporada);
	}

	/**
	 * Cadastrar BlurayFilme
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do filme
	 * @param valor
	 *            valor do filme
	 * @param duracao
	 *            duracao total do filme
	 * @param genero
	 *            genero do filme
	 * @param classificacao
	 *            classificacao do filme
	 * @param anoDeLancamento
	 *            ano dde lancemento do filme
	 * @throws Exception
	 */
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double valor, int duracao,
			String genero, String classificacao, String anoDeLancamento) throws Exception {
		retornaUsuario(nome, telefone).adicionarItemFilme(nomeItem, valor, duracao, genero, classificacao,
				anoDeLancamento);

	}

	/**
	 * Cadastrar BlurayShow
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do BlurayShow
	 * @param valor
	 *            valor do BlurayShow
	 * @param duracao
	 *            duracao do BlurayShow
	 * @param numeroDeFaixas
	 *            numero de faixas do BlurayShow
	 * @param artista
	 *            artista do BlurayShow
	 * @param classificacao
	 *            classificacao do BlurayShow
	 * @throws Exception
	 */
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double valor, int duracao,
			int numeroDeFaixas, String artista, String classificacao) throws Exception {
		retornaUsuario(nome, telefone).adicionarItemShow(nomeItem, valor, duracao, numeroDeFaixas, artista,
				classificacao);
	}

	/**
	 * Metodo que adiciona um episodio numa serie
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
		retornaUsuario(nome, telefone).adicionarBluRay(nomeItem, duracao);
	}

	public Usuario retornaUsuario(String nome,String telefone) {
		return this.usuarioRepository.recuperar(nome, telefone);
	}
	public List<Usuario> getUsuarios() {
		return usuarioRepository.getUsuarios();
	}
}
