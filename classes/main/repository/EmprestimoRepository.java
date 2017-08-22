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
	private List<Emprestimo> emprestimosItens;
	
	/**
	 * Contrutor do EmprestimoRepository
	 */
	public EmprestimoRepository() {
		emprestimos = new ArrayList<>();
		this.emprestimosItens = new ArrayList<>();
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
	
	public void adicionarEmpIntens(Emprestimo emprestimo) {
		this.emprestimosItens.add(emprestimo);
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

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
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
	
	/** 
	 * Metodo que remove um emprestimo da lista emprestimosItens
	 * 
	 * @param nomeDono
	 * @param item
	 */
	public void removerItenList(String nomeDono,String item) {
		for (Emprestimo emprestimo : emprestimosItens) {
			if(emprestimo.getUsuarioDono().getNome().equals(nomeDono) && emprestimo.getItemEmprestado().getNome().equals(item)) {
				this.emprestimosItens.remove(emprestimo);
				return;
			}
			
		}
	}

	/**
	 * Metodo que retorna a lista de emprestimosItens
	 * @return
	 */
	public List<Emprestimo> getEmprestimosItens() {
		return emprestimosItens;
	}
	
	
}
