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
	
	
}