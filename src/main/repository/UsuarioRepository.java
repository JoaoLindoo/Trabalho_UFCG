package main.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
	public UsuarioRepository() {
		usuarios = new ArrayList<>();
		
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
	 * Método queretorna a lista dos itens de todos os usuários.
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
	 * Método que retorna a lista em String dos itens ordenado por ordem alfabetica.
	 * @return a string da descrição de todos os itens dos usuários
	 */
	public String ordenacaoItensNome() {
		List<Item> listaItens = this.listaTotalItens();
		Collections.sort(listaItens, new ItemOrdenacaoDescricao());
		String listaDescricaoItens = "";
		for (Item item : listaItens) {
			listaDescricaoItens += item.toString() + "|";
		}
		 return listaDescricaoItens;
	}
	
	/**
	 * Método que retorna a lista em String dos itens ordenado por ordem de valor.
	 * @return a string da descrição de todos os itens dos usuários
	 */
	public String ordenacaoItensValor() {
		List<Item> listaItens = this.listaTotalItens();
		Collections.sort(listaItens, new ItemOrdenacaoValor());
		String listaDescricaoItens = "";
		for (Item item : listaItens) {
			listaDescricaoItens += item.toString() + "|";
		}
		return listaDescricaoItens;
	}
}