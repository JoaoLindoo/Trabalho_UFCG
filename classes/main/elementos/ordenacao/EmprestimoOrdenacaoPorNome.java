package main.elementos.ordenacao;

import java.util.Comparator;

import main.elementos.Emprestimo;

public class EmprestimoOrdenacaoPorNome implements Comparator<Emprestimo> {

	@Override
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getItemEmprestado().getNome().compareTo(o2.getItemEmprestado().getNome());
	}

}

