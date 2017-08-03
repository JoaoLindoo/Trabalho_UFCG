package main.elementos;

/**
 * @author Redson
 *
 */

public abstract class Item {
	
	protected String nome;
	protected double valor;
	protected boolean status;
	
	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.status = false;
	}
	
	public String estado() {
		if (status == true) 
			return "Emprestado";
		else 
			return "Nao emprestado";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}