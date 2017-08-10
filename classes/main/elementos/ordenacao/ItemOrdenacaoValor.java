package main.elementos.ordenacao;

import java.util.Comparator;

import main.elementos.Item;

/**
 * Classe que gera o objeto que ordena em ordem de valor.
 * 
 * @author Matheus Thiago
 */
public class ItemOrdenacaoValor implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.getValor() < o2.getValor())
			return -1;
		if (o1.getValor() > o2.getValor())
			return 1;

		return 0;
	}

}
