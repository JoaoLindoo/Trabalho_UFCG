package main.exception;

/**
 * Classe que representa a exception de DadoInvalido
 * 
 * @author Joao
 *
 */
public class DadoInvalido extends Exception {

	private static final long serialVersionUID = -5742543064498035320L;

	/**
	 * Construtor do dadoInvalido
	 * 
	 * @param msg
	 *            mensagem da exception
	 */
	public DadoInvalido(String msg) {
		super(msg);
	}
}
