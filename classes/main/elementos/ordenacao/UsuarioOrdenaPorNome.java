package main.elementos.ordenacao;
import java.util.Comparator;
import main.elementos.Emprestimo;

public class UsuarioOrdenaPorNome implements Comparator<Emprestimo> {
	@Override
	public int compare(Emprestimo o1, Emprestimo o2) {
		return o1.getUsuarioDono().getNome().trim().toLowerCase().compareTo(o2.getUsuarioDono().getNome().trim().toLowerCase());
	}


}
