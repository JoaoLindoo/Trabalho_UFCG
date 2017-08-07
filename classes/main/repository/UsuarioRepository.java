package main.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import main.elementos.Emprestimo;
import main.elementos.Item;
import main.elementos.ordenacao.ItemOrdenacaoDescricao;
import main.elementos.ordenacao.ItemOrdenacaoValor;
import main.usuario.Usuario;

/**
 * Classe responsavel pelo CRUD de {@link Usuario}
 *
 */
public class UsuarioRepository {
	List<Usuario> usuarios;
	List<Emprestimo> emprestimos;
	public UsuarioRepository() {
		usuarios = new ArrayList<>();
		emprestimos = new ArrayList<>();
	}
	/**
	 * Adiciona um {@link Usuario} ao sistema
	 * @param usuario
	 */
	public void adiciona(Usuario usuario){
		usuarios.add(usuario);
	}
	/**
	 * Verifica se existe um {@link Usuario} caso existe ir� retorna 
	 * @param nome Nome do ususario
	 * @param telefone Telefone do usuario
	 * @return
	 */
	public Usuario recuperar(String nome,String telefone){
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nome)) {
				if (usuario.getNumeroDoCelular().equalsIgnoreCase(telefone)) {
					return usuario;
				}
			}
		}
		return null ;
	}
	/**
	 * Remove um {@link Usuario}
	 * @param nome Nome do usuario
	 * @param telefone Telefone de um usuario
	 * @return
	 */
	public boolean remover(String nome,String telefone){
		return usuarios.remove(recuperar(nome, telefone));
	}
	/**
	 * Edita um {@link Usuario} de acordo com um atributo
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param atributo Atributo que determina como vai ser a modificacao
	 * @param valor Valor � a variavel que vai atualizar o usuario
	 */
	public void editar(String nome,String telefone,String atributo,String valor){
		if (atributo.equalsIgnoreCase("email")) {
			recuperar(nome, telefone).setEmail(valor);
		}else {
			recuperar(nome, telefone).setNumeroDoCelular(valor);
		}
		
	}
	/**
	 * Metodo queretorna a lista dos itens de todos os usuários.
	 * @return uma List de objetos itens
	 */
	public List<Item> listaTotalItens(){
		List<Item> listaItens = new ArrayList<Item>();
		for (Usuario usuario : usuarios) {
			Set<Item> listaItenUser = usuario.getListaItens();
			for (Item item : listaItenUser) {
				listaItens.add(item);
			}
		}
		return listaItens;
	}
	
	/**
	 * Metodo que registra o emprestimo 
	 * @author Redson
	 * @throws ParseException 
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws ParseException {
		Usuario dono = recuperar(nomeDono, telefoneDono);
		Usuario requerente = recuperar(nomeRequerente, telefoneRequerente);
		Item item = dono.recuperItem(nomeItem);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar data = Calendar.getInstance();     
	    data.setTime(sdf.parse(dataEmprestimo));
		Emprestimo emprestimo = new Emprestimo(dono, requerente, item, data, periodo);
		emprestimos.add(emprestimo);
		alocaItemEmprestado(nomeRequerente, telefoneRequerente, item);
		item.setStatus(true);	
	}
	
	/**
	 * Metodo que aloca o item emprestado no usuario requerente
	 * @author Redson
	 */
	public void alocaItemEmprestado(String nomeRequerente, String telefoneRequerente, Item item) {
		recuperar(nomeRequerente, telefoneRequerente).aloca(item);
	}
	
	public boolean devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente, String nomeItem, String dataEmprestimo, String dataDevolucao) throws ParseException {
		Usuario dono = recuperar(nomeDono, telefoneDono);
		Usuario requerente = recuperar(nomeRequerente, telefoneRequerente);
		Item item = dono.recuperItem(nomeItem);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar data = Calendar.getInstance();     
	    Calendar dataFinal = Calendar.getInstance();     
	    data.setTime(sdf.parse(dataEmprestimo));
	    dataFinal.setTime(sdf.parse(dataDevolucao));
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getUsuarioDono() == dono && emprestimo.getUsuarioRequerente() == requerente && emprestimo.getItemEmprestado() == item && emprestimo.getDataEmprestimo() == data && emprestimo.getDataDevolucao() == dataFinal) {
				recuperar(nomeRequerente, telefoneRequerente).removerItemEmprestado(nomeItem);
				item.setStatus(false);
				return true;
			}	
		}
		return false;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
}