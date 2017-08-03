package main.elementos;

import java.util.HashSet;
import java.util.Set;

import main.elementos.bluray.Filme;
import main.elementos.bluray.Serie;
import main.elementos.bluray.Show;

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

	public Usuario(String nome, String email, String numeroDoCelular) {
		this.nome = nome;
		this.email = email;
		this.numeroDoCelular = numeroDoCelular;
		this.listaItens = new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroDoCelular() {
		return numeroDoCelular;
	}

	public void setNumeroDoCelular(String numeroDoCelular) {
		this.numeroDoCelular = numeroDoCelular;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", numeroDoCelular=" + numeroDoCelular + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDoCelular == null) ? 0 : numeroDoCelular.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
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
	 * Métodos para criar e adicionar itens no usuario
	 * 
	 * @author Matheus Thiago
	 */
	public void adicionarItemJogoTabuleiro(String nome, double valor) {
		this.listaItens.add(new JogoDeTabuleiro(nome, valor));
	}

	public void adiconarItemJogoEletronico(String nome, double valor, String plataforma) {
		this.listaItens.add(new JogoEletronico(nome, valor, plataforma));
	}

	public void adicionarItemFilme(String nome, double valor, int duracao, String genero, String classificacao,
			String anoDeLancamento) {
		this.listaItens.add(new Filme(nome, valor, duracao, genero, classificacao, anoDeLancamento));
	}

	public void adicionarItemSerie(String nome, double valor, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		this.listaItens.add(new Serie(nome, valor, descricao, duracao, classificacao, genero, temporada));
	}

	public void adicionarItemShow(String nome, double valor, int duracao, int numeroFaixas, String artista,
			String classificacao) {
		this.listaItens.add(new Show(nome, valor, duracao, numeroFaixas, artista, classificacao));
	}

	public boolean removerItem(String nomeItem) {

		for (Item item : listaItens) {
			if (item.getNome().equals(nomeItem)) {
				this.listaItens.remove(item);
				return true;
			}

		}
		return false;
	}
	public void atualizarItemNome(String nomeItem,String nomeMudar) {
		for (Item item : listaItens) {
			if(item.getNome().equals(nomeItem)) {
				item.setNome(nomeMudar);
				break;
			}
		}
	}
	public double valorProcuradoItem(String nomeItem) {
		for (Item item : listaItens) {
			if(item.getNome().equals(nomeItem)) {
				return item.getValor();
			}
		}
		return 0;
	}
	public String nomeItemProcurado(String nomeItem) {
		for (Item item : listaItens) {
			if(item.getNome().equals(nomeItem)) {
				return item.getNome();
			}
		}
		return "";
	}
}
