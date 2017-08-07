package main.elementos;

import java.util.Calendar;

import main.usuario.Usuario;

public class Emprestimo {
	
	private Usuario usuarioDono;
	private Usuario usuarioRequerente;
	private Item itemEmprestado;
	private Calendar dataEmprestimo = Calendar.getInstance();
	private int tempoEmprestimo;
	private Calendar dataDevolucao = Calendar.getInstance();
	
	public Emprestimo(Usuario usuarioDono, Usuario usuarioRequerente, Item itemEmprestado, Calendar dataEmprestimo, int tempoEmprestimo) {
		this.usuarioDono = usuarioDono;
		this.usuarioRequerente = usuarioRequerente;
		this.itemEmprestado = itemEmprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.tempoEmprestimo = tempoEmprestimo;
		dataDevolucao.add(Calendar.DATE, tempoEmprestimo);
	}

	public Usuario getUsuarioDono() {
		return usuarioDono;
	}

	public void setUsuarioDono(Usuario usuarioDono) {
		this.usuarioDono = usuarioDono;
	}

	public Usuario getUsuarioRequerente() {
		return usuarioRequerente;
	}

	public void setUsuarioRequerente(Usuario usuarioRequerente) {
		this.usuarioRequerente = usuarioRequerente;
	}

	public Item getItemEmprestado() {
		return itemEmprestado;
	}

	public void setItemEmprestado(Item itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}

	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}

	public void setTempoEmprestimo(int tempoEmprestimo) {
		this.tempoEmprestimo = tempoEmprestimo;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		result = prime * result + ((usuarioDono == null) ? 0 : usuarioDono.hashCode());
		result = prime * result + ((usuarioRequerente == null) ? 0 : usuarioRequerente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!itemEmprestado.equals(other.itemEmprestado))
			return false;
		if (usuarioDono == null) {
			if (other.usuarioDono != null)
				return false;
		} else if (!usuarioDono.equals(other.usuarioDono))
			return false;
		if (usuarioRequerente == null) {
			if (other.usuarioRequerente != null)
				return false;
		} else if (!usuarioRequerente.equals(other.usuarioRequerente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Emprestimo [usuarioDono=" + usuarioDono + ", usuarioRequerente=" + usuarioRequerente
				+ ", itemEmprestado=" + itemEmprestado + ", dataEmprestimo=" + dataEmprestimo + ", tempoEmprestimo="
				+ tempoEmprestimo + ", dataRevolucao=" + dataDevolucao + "]";
	}
	
}
