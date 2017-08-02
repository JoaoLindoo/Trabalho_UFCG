package main.elementos.bluray;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um bluray de serie
 * 
 * @author Giovana Brito Oliveira - 116110904
 *
 */
public class Serie extends BluRay {

	private List<Integer> episodios;
	private String genero;
	private int numeroTemporada;
	private String descricao;

	/**
	 * Construtor de serie
	 * 
	 * @param nome
	 *            nome da serie
	 * @param valor
	 *            valor da serie
	 * @param descricao
	 *            descricao da serie
	 * @param duracao
	 *            duracao da serie
	 * @param classificacao
	 *            classificacao da serie
	 * @param genero
	 *            genero da serie
	 * @param temporada
	 *            numero da temporada
	 */
	public Serie(String nome, double valor, String descricao, int duracao, String classificacao, String genero,
			int temporada) {
		super(nome, valor, duracao, classificacao);
		this.episodios = new ArrayList<Integer>();
		this.descricao = descricao;
		this.genero = genero;
		this.numeroTemporada = temporada;
	}

	/**
	 * Metodo que adiciona um novo episodio na temporada
	 * 
	 * @param duracao
	 *            duracao do episodio
	 */
	public void adicionarBluRay(int duracao) {
		this.episodios.add(duracao);
	}

}
