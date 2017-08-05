package main.elementos.ordenacao;

import java.util.Comparator;

import main.elementos.Item;

public class ItemComparadorDescricao implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		
		return o1.getNome().trim().compareTo(o2.getNome().trim());
	}
	

}
