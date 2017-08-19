package main.reputacao;
/**
 * Iterface para o implementacao de diferentes reputacao.
 * @author Matheus Thiago
 *
 */
public interface Reputacao {
	
	public boolean pegarEmprestado();
	
	public int periodoEmprestimo();
	
	public String toStringReputacao();

}
