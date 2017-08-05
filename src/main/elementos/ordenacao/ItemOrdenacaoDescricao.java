/**
 * Classe que gera o objeto que ordena em ordem alfabetica.
 * @author Matheus Thiago
 */
package main.elementos.ordenacao;

import java.util.Comparator;

import main.elementos.Item;

public class ItemOrdenacaoDescricao implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		
		return o1.getNome().trim().toLowerCase().compareTo(o2.getNome().trim().toLowerCase());
	}
	

}
