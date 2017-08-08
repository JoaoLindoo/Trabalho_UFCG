package main.repository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.elementos.Emprestimo;
public class EmprestimoRepository {
	private List<Emprestimo> emprestimos;

	
	public EmprestimoRepository() {
		emprestimos = new ArrayList<>();
	}
	
	public void adicionar(Emprestimo emprestimo){
		emprestimos.add(emprestimo);
	}
	public Emprestimo recuperar(String itemEmprestado){
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getItem().equalsIgnoreCase(itemEmprestado)) {
				return emprestimo;
			}
		}
		return null ;
	}
	public void remove(String itemEmprestado) {
		emprestimos.remove(recuperar(itemEmprestado));
	}
	public Date converteParaData(String datinha) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse(datinha);
		return data;
		
	}
}
