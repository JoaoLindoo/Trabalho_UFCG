package main.elementos;
/**
 * @author Redson
 *
 * Classe que representa um Item
 */
public abstract class Item {
	
	protected String nome;
	protected double valor;
	protected boolean status;
	
	/**
	 * Construtor do Item
	 * 
	 */
	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.status = false;
	}
	
	/**
	 * Metodo que retorna uma String de acordo com o valor do status do Item
	 * 
	 */
	public String estado() {
		if (status == true) 
			return "Emprestado";
		else 
			return "Nao emprestado";
	}
	
	/**
	 * Metodo que retorna o nome do Item
	 * 
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo que altera o nome do Item
	 * 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo que retorna o valor do Item
	 * 
	 */
	public double getValor() {
		return valor;
	}
	
	/**
	 * Metodo que altera o valor do Item 
	 *
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	/**
	 * Metodo que retorna status do Item
	 * 
	 */
	public boolean getStatus() {
		return status;
	}
	
	/**
	 * Metodo que altera o status do Item
	 * 
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}