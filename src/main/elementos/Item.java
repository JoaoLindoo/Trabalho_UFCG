package main.elementos;

import main.exception.DadoInvalido;

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
	public Item(String nome, double valor) throws Exception {
		if (valor <= 0) 
			throw new DadoInvalido("Preco invalido");
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
	
	/**
	 * hashcode e equals que compara se doi objetos itens tem nomes iguais.
	 * @author matheus
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	public void addBluray(int duracao){
		
	}
	
}