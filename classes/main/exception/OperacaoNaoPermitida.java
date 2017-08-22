package main.exception;

/**
 * Metodo que representa a exception de OperacaoNaoPermitida
 * 
 * @author Joao
 *
 */
public class OperacaoNaoPermitida extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contrutor da exception OperacaoNaoPermitida
	 * 
	 * @param msg
	 *            mensagem da exception
	 */
	public OperacaoNaoPermitida(String msg) {
		super(msg);
	}
}
