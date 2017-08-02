package main.elementos.bluray;

/**
 * Classe que representa o bluray de Show
 * 
 * @author Giovana Brito Oliveira - 116110904
 *
 */
public class Show extends BluRay {

	private String nomeDoArtista;
	private int numeroFaixas;

	/**
	 * Contrutor do show
	 * 
	 * @param nome
	 *            nome do show
	 * @param valor
	 *            preco do bluray de show
	 * @param duracao
	 *            duracao do show
	 * @param numeroFaixas
	 *            numero de faixas do show
	 * @param artista
	 *            nome do artista
	 * @param classificacao
	 *            classificacao do show
	 */
	public Show(String nome, double valor, int duracao, int numeroFaixas, String artista, String classificacao) {
		super(nome, valor, duracao, classificacao);
		this.nomeDoArtista = artista;
		this.numeroFaixas = numeroFaixas;
	}
}
