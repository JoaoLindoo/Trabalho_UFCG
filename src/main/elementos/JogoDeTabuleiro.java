package main.elementos;

import java.util.ArrayList;
import java.util.List;

public class JogoDeTabuleiro extends Item {
	
	private List<String> listaDePecasPerdidas;
	
	public JogoDeTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.listaDePecasPerdidas = new ArrayList<>();
	}
	
	public String estadoPecas() {
		if (listaDePecasPerdidas.size() > 0)
			return "COM PECAS PERDIDAS";
		else
			return "SEM PECAS PERDIDAS";
	}
	
	public List<String> getListaDePecasPerdidas() {
		return listaDePecasPerdidas;
	}
	
	public void setListaDePecasPerdidas(List<String> listaDePecasPerdidas) {
		this.listaDePecasPerdidas = listaDePecasPerdidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listaDePecasPerdidas == null) ? 0 : listaDePecasPerdidas.hashCode());
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
		JogoDeTabuleiro other = (JogoDeTabuleiro) obj;
		if (listaDePecasPerdidas == null) {
			if (other.listaDePecasPerdidas != null)
				return false;
		} else if (!listaDePecasPerdidas.equals(other.listaDePecasPerdidas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + nome + ", R$ " + valor+ ", " + this.estado() + ", " + this.estadoPecas();
	}

}
