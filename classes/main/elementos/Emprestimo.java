package main.elementos;

import java.util.Calendar;

import main.usuario.Usuario;

public class Emprestimo {
	
	private Usuario usuarioDono;
	private Usuario usuarioRequerente;
	private Item itemEmprestado;
	private Calendar dataEmprestimo = Calendar.getInstance();
	private int tempoEmprestimo;
	private Calendar dataRevolucao = Calendar.getInstance();
	
	public Emprestimo(Usuario usuarioDono, Usuario usuarioRequerente, Item itemEmprestado, Calendar dataEmprestimo, int tempoEmprestimo) {
		this.usuarioDono = usuarioDono;
		this.usuarioRequerente = usuarioRequerente;
		this.itemEmprestado = itemEmprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.tempoEmprestimo = tempoEmprestimo;
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

	public Calendar getDataRevolucao() {
		return dataRevolucao;
	}

	public void setDataRevolucao(Calendar dataRevolucao) {
		this.dataRevolucao = dataRevolucao;
	}
	
}
