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
	 * @throws Exception
	 */
	public Show(String nome, double valor, int duracao, int numeroFaixas, String artista, String classificacao)
			throws Exception {
		super(nome, valor, duracao, classificacao);
		this.nomeDoArtista = artista;
		this.numeroFaixas = numeroFaixas;
	}

	/**
	 * Metodo que retorna a representacao em String do show
	 */
	@Override
	public String toString() {
		return "SHOW: " + this.getNome() + ", R$ " + this.valor + ", Nao emprestado, " + this.getDuracao() + " min, "
				+ this.getClassificacao() + ", " +this.nomeDoArtista+", "+this.numeroFaixas+ " faixas";
	}

}
