package main.elementos;
/**
 * @author Redson
 *
 * Classe que representa um Jogo Eletronico
 */
public class JogoEletronico extends Item {
	
	private String plataforma;
	
	/**
	 * Construtor do Jogo Eletronico
	 * @throws Exception 
	 * 
	 */
	public JogoEletronico(String nome, double valor, String plataforma) throws Exception {
		super(nome, valor);
		this.plataforma = plataforma;
	}
	
	/**
	 * Metodo que retorna a Plataforma do Jogo Eletronico
	 * 
	 */
	public String getPlataforma() {
		return plataforma;
	}
	
	/**
	 * Metodo que altera a Plataforma do Jogo Eletronico
	 * 
	 */
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma != other.plataforma)
			return false;
		return true;
	}

	/**
	 * Metodo que retorna uma String para representar o Jogo Eletroniico
	 * 
	 */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + nome + ", R$ " + valor + ", " + this.estado() + ", " + plataforma;
	}
	
}