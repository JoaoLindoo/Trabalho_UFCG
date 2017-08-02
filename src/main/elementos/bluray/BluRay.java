package main.elementos.bluray;

import main.elementos.Item;

/**
 * Classe que representa um bluray
 * 
 * @author Giovana Brito Oliveira - 116110904
 *
 */
public abstract class BluRay extends Item {

	private int duracao;
	private String classificacao;

	/**
	 * Construtor do BluRay
	 */
	public BluRay(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		this.duracao = duracao;
		this.classificacao = classificacao;
	}

	/**
	 * Metodo que retorna a duracao do BluRay
	 * 
	 * @return retorna a duracao do BluRay
	 */
	public int getDuracao() {
		return duracao;
	}

	/**
	 * Metodo que atualiza a duracao do BluRay
	 * 
	 * @param duracao
	 *            duracao do bluray
	 */
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	/**
	 * Metodo que retorna a classificacao do BluRay
	 * 
	 * @return retorna a clasificacao do BluRay
	 */
	public String getClassificacao() {
		return classificacao;
	}

	/**
	 * Metodo que atualiza a classificacao do bluray
	 * 
	 * @param classificacao
	 *            classificacao do bluray
	 */
	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}
}
