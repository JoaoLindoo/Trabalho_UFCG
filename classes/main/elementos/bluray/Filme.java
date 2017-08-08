package main.elementos.bluray;

import main.exception.DadoInvalido;

/**
 * Classe que representa o filme
 * 
 * @author Giovana Brito Oliveira - 116110904
 *
 */
public class Filme extends BluRay {

	private String genero;
	private String anoDeLancamento;

	/**
	 * Contrutor do filme
	 * 
	 * @param nome
	 *            nome do filme
	 * @param valor
	 *            preco do filme
	 * @param duracao
	 *            duracao do filme
	 * @param genero
	 *            gerero do filme
	 * @param classificacao
	 *            classificacao do filme
	 * @param anoDeLancamento
	 *            ano de lancamento do filme
	 * @throws Exception
	 */
	public Filme(String nome, double valor, int duracao, String genero, String classificacao, String anoDeLancamento)
			throws DadoInvalido {
		super(nome, valor, duracao, classificacao);

		if (genero == null) {
			throw new NullPointerException("Genero nao pode ser nulo");
		}
		if (genero.equals("")) {
			throw new IllegalArgumentException("Genero invalido");
		}
		if (anoDeLancamento == null) {
			throw new NullPointerException("Ano de lancamento nao pode ser nulo");
		}
		if (anoDeLancamento.equals("")) {
			throw new IllegalArgumentException("Ano de lancamento invalido");
		}

		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}

	/**
	 * Metodo que retorna a representacao em string do filme
	 */
	@Override
	public String toString() {
		return "FILME: " + this.getNome() + "," + " R$ " + this.getValor() + ", Nao emprestado, " + this.getDuracao()
				+ " min, " + this.getClassificacao() + ", " + this.genero + ", " + this.anoDeLancamento;
	}

}
