package main.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import main.elementos.Emprestimo;
import main.elementos.Item;
import main.elementos.Usuario;
import main.elementos.ordenacao.ItemOrdenacaoDescricao;
import main.elementos.ordenacao.ItemOrdenacaoValor;
import main.exception.DadoInvalido;
import main.exception.OperacaoNaoPermitida;
import main.repository.EmprestimoRepository;
import main.repository.UsuarioRepository;

/**
 * Classe que representa controla o sistema
 * 
 * @author Joao Henrique
 *
 */
public class SistemaController {

	private UsuarioRepository repository;
	private EmprestimoRepository emprestimoRepository;
	private Usuario usuario;
	private static final String ATRIBUTO_EMAIL = "email";
	private static final String USUARIO_INVALIDO = "Usuario invalido";
	private static final String USUARIO_CASASTRADO = "Usuario ja cadastrado";
	private static final String ITEM_JA_EMPRESTADO = "Item emprestado no momento";
	private static final String ITEM_NAO_ENCONTRADO = "Item nao encontrado";
	private static final String EMPRESTIMO_NAO_ENCONTRADO = "Emprestimo nao encontrado";
	private static final String NENHUM_ITEM_EMPRESTADO = "Nenhum item emprestado";
	

	/**
	 * Construtor de sistemaController
	 */
	public SistemaController() {
		repository = new UsuarioRepository();
		emprestimoRepository = new EmprestimoRepository();
	}

	/**
	 * Adiciona um {@link Usuario} em um sistema de usuarios
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param email
	 *            Email do usuario
	 * @throws Exception
	 *             Verifica se ja existe um usuario no sistema caso verdade ,
	 *             lanca um Exception
	 */
	public void adicionar(String nome, String telefone, String email) throws Exception {
		if (repository.recuperar(nome, telefone) != null) {
			throw new OperacaoNaoPermitida(USUARIO_CASASTRADO);
		}
		usuario = new Usuario(nome, email, telefone);
		repository.adiciona(usuario);
	}

	/**
	 * Metodo que da uma informacao de um {@link Usuario}
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @param atributo
	 *            Atributo a ser seguido
	 * @return
	 * @throws Exception
	 *             caso o usuario nao exista
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) throws Exception {
		usuario = repository.recuperar(nome, telefone);
		if (usuario == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		if (ATRIBUTO_EMAIL.equalsIgnoreCase(atributo)) {
			return usuario.getEmail();
		}
		return null;
	}

	/**
	 * Remove um usuario do sistema
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @throws Exception
	 *             caso o usuario nao exista
	 */
	public void removerUsuario(String nome, String telefone) throws Exception {
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		repository.remover(nome, telefone);
	}

	/**
	 * Memtodo que atualiza um usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param atributo
	 *            atributo a ser atualizado
	 * @param valor
	 *            novo valor do atributo
	 * @throws Exception
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) throws Exception {
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}

		repository.editar(nome, telefone, atributo, valor);
	}

	/**
	 * Recupera um {@link Usuario} no sistema
	 * 
	 * @param nome
	 *            Nome do usuario
	 * @param telefone
	 *            Telefone do usuario
	 * @return
	 */
	public Usuario recuperar(String nome, String telefone) {
		return recuperar(nome, telefone);
	}

	/**
	 * Cadastra um jogo eletronico
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            preco do item
	 * @param plataforma
	 *            plataforma do jogo
	 * @throws Exception
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws Exception {
		repository.recuperar(nome, telefone).adiconarItemJogoEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Informacao do item desejado
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefonee do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo que deseja que seja informado
	 * @return
	 * @throws Exception
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) throws Exception {
		if (repository.recuperar(nome, telefone).recuperItem(nomeItem) == null) {
			throw new OperacaoNaoPermitida(ITEM_NAO_ENCONTRADO);
		}
		if (atributo.equalsIgnoreCase("preco")) {
			String getvalor = String.valueOf(repository.recuperar(nome, telefone).recuperItem(nomeItem).getValor());
			return getvalor;
		} else if (atributo.equalsIgnoreCase("nome")) {
			return repository.recuperar(nome, telefone).recuperItem(nomeItem).getNome();

		}
		return "";
	}

	/**
	 * Cadastrar Jogo de taboleiro
	 * 
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
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		repository.recuperar(nome, telefone).adicionarItemJogoTabuleiro(nomeItem, preco);

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
		repository.recuperar(nome, telefone).adicionarPecaperdida(nomeItem, nomePeca);

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
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		repository.recuperar(nome, telefone).adicionarItemSerie(nomeItem, preco, descricao, duracao, classificacao,
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
		repository.recuperar(nome, telefone).adicionarItemFilme(nomeItem, valor, duracao, genero, classificacao,
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
		repository.recuperar(nome, telefone).adicionarItemShow(nomeItem, valor, duracao, numeroDeFaixas, artista,
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
		repository.recuperar(nome, telefone).adicionarBluRay(nomeItem, duracao);
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
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		} else if (repository.recuperar(nome, telefone).recuperItem(nomeItem) == null) {
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		}
		repository.recuperar(nome, telefone).removerItem(nomeItem);
	}

	/**
	 * Metodo que atualiza um item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo a ser atualizado
	 * @param valor
	 *            novo valor do atributo
	 * @throws Exception
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor)
			throws Exception {
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		} else if (repository.recuperar(nome, telefone).recuperItem(nomeItem) == null) {
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		}
		repository.recuperar(nome, telefone).atualizarItem(nomeItem, atributo, valor);

	}

	/**
	 * Metodo que pesquisa detalhes do item
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @return retorna a toString do item
	 * @throws Exception
	 */
	public String pesquisarDetalhesItem(String nome, String telefone, String nomeItem) throws Exception {
		if (repository.recuperar(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		} else if (repository.recuperar(nome, telefone).recuperItem(nomeItem) == null) {
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		}
		return repository.recuperar(nome, telefone).recuperItem(nomeItem).toString();
	}

	/**
	 * Metodo que registra um emprestimo
	 * 
	 * @param nomeDono
	 *            nome do dono
	 * @param telefoneDono
	 *            telefone do dono
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            telefone do requerente
	 * @param nomeItem
	 *            nome do item
	 * @param dataEmprestimo
	 *            data do emprestimo
	 * @param periodo
	 *            periodo
	 * @throws Exception
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws Exception {
		if (repository.recuperar(nomeDono, telefoneDono) == null
				|| repository.recuperar(nomeRequerente, telefoneRequerente) == null)
			throw new DadoInvalido(USUARIO_INVALIDO);
		if (repository.recuperar(nomeDono, telefoneDono).recuperItem(nomeItem) == null)
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		if (repository.recuperar(nomeDono, telefoneDono).recuperItem(nomeItem).getStatus() == true)
			throw new DadoInvalido(ITEM_JA_EMPRESTADO);
		Usuario dono = repository.recuperar(nomeDono, telefoneDono);
		Usuario requerente = repository.recuperar(nomeRequerente, telefoneRequerente);
		Item item = repository.recuperar(nomeDono, telefoneDono).recuperItem(nomeItem);
		Date data = emprestimoRepository.converteParaData(dataEmprestimo);
		Emprestimo emprestimo = new Emprestimo(dono, requerente, item, data, periodo);
		alocaItemEmprestado(nomeRequerente, telefoneRequerente, item);
		item.setStatus(true);
		emprestimoRepository.adicionar(emprestimo);

	}

	/**
	 * Metodo que aloca um item emprestado
	 * 
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            telefone do requerente
	 * @param item
	 *            nome do item
	 */
	public void alocaItemEmprestado(String nomeRequerente, String telefoneRequerente, Item item) {
		repository.recuperar(nomeRequerente, telefoneRequerente).aloca(item);
	}

	/**
	 * Metodo que devolve um item para o seu dono
	 * 
	 * @param nomeDono
	 *            nome do dono
	 * @param telefoneDono
	 *            telefone do dono
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            telefone do requerente
	 * @param nomeItem
	 *            nome do item
	 * @param dataEmprestimo
	 *            data do emprestimo
	 * @param dataDevolucao
	 *            data da devolucao
	 * @throws Exception
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws Exception {
		if (repository.recuperar(nomeDono, telefoneDono) == null
				|| repository.recuperar(nomeRequerente, telefoneRequerente) == null)
			throw new DadoInvalido(USUARIO_INVALIDO);
		if (repository.recuperar(nomeDono, telefoneDono).recuperItem(nomeItem) == null)
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		if (!repository.recuperar(nomeRequerente, telefoneRequerente).recuperaAlocados(nomeItem))
			throw new DadoInvalido(EMPRESTIMO_NAO_ENCONTRADO);
		Usuario dono = repository.recuperar(nomeDono, telefoneDono);
		Usuario requerente = repository.recuperar(nomeRequerente, telefoneRequerente);
		Item item = repository.recuperar(nomeDono, telefoneDono).recuperItem(nomeItem);
		Date data = emprestimoRepository.converteParaData(dataDevolucao);
		repository.recuperar(nomeRequerente, telefoneRequerente).removerItemEmprestado(nomeItem);
		emprestimoRepository.recuperar(nomeItem).setDataDevolucao(data);
		
		item.setStatus(false);
	}

	/**
	 * Metodo para ordenacao de itens por nome
	 * 
	 * @return
	 */
	public String listarItensOrdenadosPorNome() {
		List<Item> listaItens = listaTotalItens();
		Collections.sort(listaItens, new ItemOrdenacaoDescricao());
		String listaDescricaoItens = "";
		for (Item item : listaItens) {
			listaDescricaoItens += item.toString() + "|";
		}
		return listaDescricaoItens;
	}

	/**
	 * Metodo para ordenacao de itens por valor
	 * 
	 * @return
	 */
	public String ordenacaoItensValor() {
		List<Item> listaItens = listaTotalItens();
		Collections.sort(listaItens, new ItemOrdenacaoValor());
		String listaDescricaoItens = "";
		for (Item item : listaItens) {
			listaDescricaoItens += item.toString() + "|";
		}
		return listaDescricaoItens;
	}

	/**
	 * Metodo que lista o total de itens
	 * 
	 * @return lista com total de itens
	 */
	public List<Item> listaTotalItens() {
		List<Item> listaItens = new ArrayList<Item>();
		for (Usuario usuario : repository.getUsuarios()) {
			Set<Item> listaItenUser = usuario.getListaItens();
			for (Item item : listaItenUser) {
				listaItens.add(item);
			}
		}
		return listaItens;
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		if (emprestimoRepository.listarEmprestimosUsuarioEmprestando(nome, telefone).equals(""))
			return NENHUM_ITEM_EMPRESTADO;
		return emprestimoRepository.listarEmprestimosUsuarioEmprestando(nome, telefone);
	}
}