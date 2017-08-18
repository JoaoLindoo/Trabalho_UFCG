package main.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import main.elementos.Item;
import main.elementos.Usuario;
import main.elementos.ordenacao.ItemOrdenacaoDescricao;
import main.elementos.ordenacao.ItemOrdenacaoValor;
import main.exception.DadoInvalido;
import main.exception.OperacaoNaoPermitida;
import main.service.SistemaService;


public class ItemController {
	private static final String ITEM_NAO_ENCONTRADO = "Item nao encontrado";
	private static final String USUARIO_INVALIDO = "Usuario invalido";
	private SistemaService sistemaService;
	
	public ItemController() {
		
		sistemaService = new SistemaService();
	}
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma)
			throws Exception {
		sistemaService.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) throws Exception {
		if (sistemaService.retornaUsuario(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		sistemaService.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);

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
		sistemaService.adicionarPecaPerdida(nome, telefone, nomeItem, nomePeca);

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
		if (sistemaService.retornaUsuario(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		sistemaService.cadastrarBluRaySerie(nome, telefone, nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		
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
		sistemaService.cadastrarBluRayFilme(nome, telefone, nomeItem, valor, duracao, genero, classificacao, anoDeLancamento);
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
		sistemaService.cadastrarBluRayShow(nome, telefone, nomeItem, valor, duracao, numeroDeFaixas, artista, classificacao);
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
		sistemaService.adicionarBluRay(nome, telefone, nomeItem, duracao);
	}
	public void removerItem(String nome, String telefone, String nomeItem) throws Exception {
		if (sistemaService.retornaUsuario(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		} else if (sistemaService.retornaUsuario(nome, telefone).recuperItem(nomeItem) == null) {
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		}
		sistemaService.retornaUsuario(nome, telefone).removerItem(nomeItem);
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
		if (sistemaService.retornaUsuario(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		} else if (sistemaService.retornaUsuario(nome, telefone).recuperItem(nomeItem) == null) {
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		}
		sistemaService.retornaUsuario(nome, telefone).atualizarItem(nomeItem, atributo, valor);

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
		if (sistemaService.retornaUsuario(nome, telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		} else if (sistemaService.retornaUsuario(nome, telefone).recuperItem(nomeItem) == null) {
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		}
		return sistemaService.retornaUsuario(nome, telefone).recuperItem(nomeItem).toString();
	}

	
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) throws Exception {
		Usuario usuario = sistemaService.retornaUsuario(nome, telefone);
		if (usuario.recuperItem(nomeItem) == null) {
			throw new OperacaoNaoPermitida(ITEM_NAO_ENCONTRADO);
		}
		if (atributo.equalsIgnoreCase("preco")) {
			String getvalor = String.valueOf(usuario.recuperItem(nomeItem).getValor());
			return getvalor;
		} else if (atributo.equalsIgnoreCase("nome")) {
			return usuario.recuperItem(nomeItem).getNome();

		}
		return "";
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
		for (Usuario usuario : sistemaService.getUsuarios() ) {
			Set<Item> listaItenUser = usuario.getListaItens();
			for (Item item : listaItenUser) {
				listaItens.add(item);
			}
		}
		return listaItens;
	}
}
