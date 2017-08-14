package main.elementos;

import java.util.Date;

/**
 * Classe que representa o emprestimo.
 * @author Redson
 *
 */
public class Emprestimo {

	/**
	 * Parametros de Emprestimo.
	 */
	private Usuario usuarioDono;
	private Usuario usuarioRequerente;
	private Item itemEmprestado;
	private Date dataEmprestimo;
	private int tempoEmprestimo;
	private Date dataDevolucao;

	
	/**
	 * Construtor de Emprestimo. 
	 *
	 */
	public Emprestimo(Usuario usuarioDono, Usuario usuarioRequerente, Item itemEmprestado, Date dataEmprestimo, int tempoEmprestimo) {
		this.usuarioDono = usuarioDono;
		this.usuarioRequerente = usuarioRequerente;
		this.itemEmprestado = itemEmprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.tempoEmprestimo = tempoEmprestimo;
		this.dataDevolucao = dataDevolucao;

	}
	
	/**
	 * Metodo que retorna o objeto Usuario dono do Emprestimo.
	 * 
	 */
	public Usuario getUsuarioDono() {
		return usuarioDono;
	}
	
	/**
	 * Metodo que altera objeto Usuario dono do Emprestimo.
	 * 
	 */
	public void setUsuarioDono(Usuario usuarioDono) {
		this.usuarioDono = usuarioDono;
	}

	/**
	 * Metodo que retorna o objeto Usuario requerente do Emprestimo.
	 * 
	 */
	public Usuario getUsuarioRequerente() {
		return usuarioRequerente;
	}
	
	/**
	 * Metodo que altera o objeto Usuario requerente do Emprestimo.
	 * 
	 */
	public void setUsuarioRequerente(Usuario usuarioRequerente) {
		this.usuarioRequerente = usuarioRequerente;
	}

	/**
	 * Metodo que retorna o objeto Item do Emprestimo.
	 * 
	 */
	public Item getItemEmprestado() {
		return itemEmprestado;
	}

	/**
	 * Metodo que altera o objeto Item do Emprestimo.
	 * 
	 */
	public void setItemEmprestado(Item itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}

	/**
	 * Metodo que retorna o objeto Date data do Emprestimo.
	 * 
	 */
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	/**
	 * Metodo que altera o objeto Date data do Emprestimo.
	 * 
	 */
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	
	/**
	 * Metodo que retorna o tempo em inteiro do Emprestimo.
	 * 
	 */
	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}

	/**
	 * Metodo que altera o tempo do Emprestimo.
	 * 
	 */
	public void setTempoEmprestimo(int tempoEmprestimo) {
		this.tempoEmprestimo = tempoEmprestimo;
	}

	/**
	 * Metodo que retorna o objeto Date data de revolucao do Emprestimo.
	 * 
	 */
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	/**
	 * Metodo que altera o objeto Date data de revolucao do Emprestimo.
	 * 
	 */
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * Metodo que retorna o nome do item em string do Emprestimo.
	 * 
	 */
	public String getItem() {
		return itemEmprestado.getNome();
	}
	
	/**
	 * Metodo que retorna uma representacao inteira do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDevolucao == null) ? 0 : dataDevolucao.hashCode());
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		return result;
	}

	/**
	 * Metodo que indica se um Emprestimo � ou nao igual ao outro.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataDevolucao == null) {
			if (other.dataDevolucao != null)
				return false;
		} else if (!dataDevolucao.equals(other.dataDevolucao))
			return false;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!getItem().equals(other.getItem()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo - De: " + usuarioDono.getNome() + ", Para: " + usuarioRequerente.getNome() + ", " + itemEmprestado.getNome() + ", " + dataEmprestimo + ", " + tempoEmprestimo + " dias, ENTREGA: " + dataDevolucao;
	}

}
