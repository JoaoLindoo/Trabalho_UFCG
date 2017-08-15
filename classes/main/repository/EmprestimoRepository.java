package main.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.elementos.Emprestimo;

/**
 * Classe que representa o repositorio de emprestimo
 * 
 *
 */
public class EmprestimoRepository {
	
	private List<Emprestimo> emprestimos;

	/**
	 * Contrutor do EmprestimoRepository
	 */
	public EmprestimoRepository() {
		emprestimos = new ArrayList<>();
	}

	/**
	 * Metodo que representa um emprestimo
	 * 
	 * @param emprestimo
	 *            emprestimo
	 */
	public void adicionar(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}

	/**
	 * Metodo que recupera um emprestimo
	 * 
	 * @param itemEmprestado
	 *            item emprestado
	 * @return retorna o emprestimo solicitado
	 */
	public Emprestimo recuperar(String itemEmprestado) {
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getItem().equalsIgnoreCase(itemEmprestado)) {
				return emprestimo;
			}
		}
		return null;
	}

	/**
	 * Metodo que remove um item emprestado
	 * 
	 * @param itemEmprestado
	 *            item emprestado
	 */
	public void remove(String itemEmprestado) {
		emprestimos.remove(recuperar(itemEmprestado));
	}

	/**
	 * Metodo que coverte para o formato de data
	 * 
	 * @param datinha
	 *            data
	 * @return retornaa data no formato certo
	 * @throws Exception
	 */
	public Date converteParaData(String datinha) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse(datinha);
		return data;
	}
	
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		String lista = "";
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getUsuarioDono().getNome().equals(nome) && emprestimo.getUsuarioDono().getNumeroDoCelular().equals(telefone)) {
				lista += emprestimo.toString();
			}
		}
		return lista;
	}
	
}
