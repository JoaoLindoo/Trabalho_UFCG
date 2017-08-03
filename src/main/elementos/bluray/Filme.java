package main.elementos.bluray;

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
	 */
	public Filme(String nome, double valor, int duracao, String genero, String classificacao, String anoDeLancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.anoDeLancamento = anoDeLancamento;
	}

	/**
	 * Metodo que retorna a representacao em string do filme
	 */
	@Override
	public String toString() {
		return super.toString() + ", genero: " + genero + ", ano de lançamento: " + anoDeLancamento;
	}

}
