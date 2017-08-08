package main.elementos;

import java.util.HashSet;
import java.util.Set;

import main.elementos.bluray.Filme;
import main.elementos.bluray.Serie;
import main.elementos.bluray.Show;
import main.exception.DadoInvalido;

/**
 * Classe que representa um usuario do sistema
 * 
 * @author Joao
 *
 */
public class Usuario {

	private String nome;
	private String email;
	private String numeroDoCelular;

	/**
	 * uso do hashset pois apenas adicionar elementos com nomes diferentes.
	 * 
	 * @author Matheus
	 */
	private Set<Item> listaItens;
	private Set<Item> listaItensPegos;

	/**
	 * Construtor do usuario
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param email
	 *            email do usuario
	 * @param numeroDoCelular
	 *            numero do celular do usuario
	 */
	public Usuario(String nome, String email, String numeroDoCelular) throws Exception{
		if (nome.trim().equals("") || email.trim().equals("") || numeroDoCelular.trim().equals("")) {
			throw new DadoInvalido("Dado invalido");
		}
		this.nome = nome;
		this.email = email;
		this.numeroDoCelular = numeroDoCelular;
		this.listaItens = new HashSet<>();
		this.listaItensPegos = new HashSet<>();
	}

	/**
	 * Metodo que retorna o nome do usuario
	 * 
	 * @return retorna o nome do usuario
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo que atualiza o nome do usuario
	 * 
	 * @param nome
	 *            novo nome do usuario
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que reotorna o email do usuario
	 * 
	 * @return retorna o email do usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo que atualiza o email do usuario
	 * 
	 * @param email
	 *            novo email do usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que retorna o nomero do celular do usuario
	 * 
	 * @return retorna o numero do celular do usuario
	 */
	public String getNumeroDoCelular() {
		return numeroDoCelular;
	}

	/**
	 * Metodo que atualiza o numero do celular do usuario
	 * 
	 * @param numeroDoCelular
	 *            novo numero de celular do usuario
	 */
	public void setNumeroDoCelular(String numeroDoCelular) {
		this.numeroDoCelular = numeroDoCelular;
	}

	/**
	 * Metodo que retorn uma representacao em String do usuario
	 */
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", numeroDoCelular=" + numeroDoCelular + "]";
	}

	/**
	 * Metodo que retorna uma representacao inteira do usuario
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDoCelular == null) ? 0 : numeroDoCelular.hashCode());
		return result;
	}

	/**
	 * Metodoque determina se um usuario eh ou nao igual a outro
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroDoCelular == null) {
			if (other.numeroDoCelular != null)
				return false;
		} else if (!numeroDoCelular.equals(other.numeroDoCelular))
			return false;
		return true;
	}

	/**
	 * Metodo que adiciona um novo jodo de tabuleiro
	 * 
	 * @author Matheus Thiago
	 * @throws Exception
	 */
	public void adicionarItemJogoTabuleiro(String nome, double valor) throws Exception {
		this.listaItens.add(new JogoDeTabuleiro(nome, valor));
	}

	/**
	 * Metodo que adiciona um novo jogo eletronico
	 * 
	 * @param nome
	 *            nome do jogo
	 * @param valor
	 *            preco o jogo
	 * @param plataforma
	 *            plataforma do jogo
	 * @throws Exception
	 */
	public void adiconarItemJogoEletronico(String nome, double valor, String plataforma) throws Exception {
		this.listaItens.add(new JogoEletronico(nome, valor, plataforma));
	}

	/**
	 * Metodo que adiciona um novo filme
	 * 
	 * @param nome
	 *            nome do filme
	 * @param valor
	 *            preco do filme
	 * @param duracao
	 *            duracao do filme
	 * @param genero
	 *            genero do filme
	 * @param classificacao
	 *            classificacao do filme
	 * @param anoDeLancamento
	 *            ano de lancamento do filme
	 * @throws Exception
	 */
	public void adicionarItemFilme(String nome, double valor, int duracao, String genero, String classificacao,
			String anoDeLancamento) throws Exception {
		this.listaItens.add(new Filme(nome, valor, duracao, genero, classificacao, anoDeLancamento));
	}

	/**
	 * Metodo que adiciona uma nova serie
	 * 
	 * @param nome
	 *            nome da serie
	 * @param valor
	 *            preco da serie
	 * @param descricao
	 *            descricao da serie
	 * @param duracao
	 *            duracao da serie
	 * @param classificacao
	 *            classisficacao da serie
	 * @param genero
	 *            genero da serie
	 * @param temporada
	 *            temporada da serie
	 * @throws Exception
	 */
	public void adicionarItemSerie(String nome, double valor, String descricao, int duracao, String classificacao,
			String genero, int temporada) throws Exception {
		this.listaItens.add(new Serie(nome, valor, descricao, duracao, classificacao, genero, temporada));
	}

	/**
	 * Metodo que adiciona um novo show
	 * 
	 * @param nome
	 *            nome dos show
	 * @param valor
	 *            preco do bluray de show
	 * @param duracao
	 *            duracao do show
	 * @param numeroFaixas
	 *            numero de faixas do show
	 * @param artista
	 *            nome do artista do show
	 * @param classificacao
	 *            classificacao do show
	 * @throws Exception
	 */
	public void adicionarItemShow(String nome, double valor, int duracao, int numeroFaixas, String artista,
			String classificacao) throws Exception {
		this.listaItens.add(new Show(nome, valor, duracao, numeroFaixas, artista, classificacao));
	}

	/**
	 * Metodo que remove um item
	 * 
	 * @param nomeItem
	 *            nome do idem
	 * @return
	 */
	public boolean removerItem(String nomeItem) {
		for (Item item : listaItens) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				this.listaItens.remove(item);
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que atualiza o nome do item
	 * 
	 * @param nomeItem
	 *            nome atual do item
	 * @param nomeMudar
	 *            novo nome do item
	 */
	public void atualizarItem(String nomeItem,String atributo, String valor) {
		if (atributo.equalsIgnoreCase("nome")) {
			recuperItem(nomeItem).setNome(valor);
		}else if (atributo.equalsIgnoreCase("preco")) {
			double valorDouble = Double.parseDouble(valor);
			recuperItem(nomeItem).setValor(valorDouble);
		}
	}

	/**
	 * Metodo que pega o valor de um item
	 * 
	 * @param nomeItem
	 *            nome do item desejado
	 * @return retorna o valor do item desejado
	 */
	public double getValorItem(String nomeItem) {
		if (recuperItem(nomeItem) != null) {
			return recuperItem(nomeItem).getValor();
		}
		return 0;
	}

	/**
	 * Metodo que retorna o nome do item desejado
	 * 
	 * @param nomeItem
	 *            nome do item desejado
	 * @return retorna o próprios nome do item
	 */
	public String getNomeItem(String nomeItem) {
		if (recuperItem(nomeItem) != null) {
			return recuperItem(nomeItem).getNome();
		}
		return "";
	}
	
	public Item recuperItem(String nomeItem){
		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem)) {
				return item;
			}
		}
		return null;
	}
	public void adicionarBluRay(String nomeItem, int duracao){
		recuperItem(nomeItem).addBluray(duracao);
	}

	public Set<Item> getListaItens() {
		return listaItens;
	}
	
	public void adicionarPecaperdida(String nomeItem, String nomePeca) {
		JogoDeTabuleiro itenTabuleiro = (JogoDeTabuleiro) this.recuperItem(nomeItem);
		itenTabuleiro.adicionarPecaPerdida(nomePeca);
	}
	public String detalheTotalItem(String nomeItem) {
		return this.recuperItem(nomeItem).toString();
	}
	
	/**
	 * aloca o item na lista de itens pegos
	 */
	public void aloca(Item item) {
		listaItensPegos.add(item);
	}
	
	public boolean removerItemEmprestado(String nomeItem) {
		for (Item item : listaItensPegos) {
			if (item.getNome().equalsIgnoreCase(nomeItem)) {
				listaItensPegos.remove(item);
				return true;
			}
		}
		return false;
	}

	public Set<Item> getListaItensPegos() {
		return listaItensPegos;
	}

	public void setListaItensPegos(Set<Item> listaItensPegos) {
		this.listaItensPegos = listaItensPegos;
	}
	
}
