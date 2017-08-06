package main.elementos;

import main.usuario.Usuario;

public class Emprestimo {
	
	private Usuario usuarioDono;
	private Usuario usuarioRequerente;
	private Item itemEmprestado;
	private int tempoEmprestimo;
	
	public Emprestimo(Usuario usuarioDono, Usuario usuarioRequerente, Item itemEmprestado, int tempoEmprestimo) {
		this.usuarioDono = usuarioDono;
		this.usuarioRequerente = usuarioRequerente;
		this.itemEmprestado = itemEmprestado;
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
	
}
