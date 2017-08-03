package main.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.usuario.Usuario;

/**
 * Classe responsavel pelo CRUD de {@link Usuario}
 *
 */
public class UsuarioRepository {
	private HashMap<String, Usuario> usuarios;

	/**
	 * Construtor de {@link UsuarioRepository} inicia um HashMap
	 */
	public UsuarioRepository() {
		usuarios = new HashMap<>();
	}
	/**
	 * Adiciona um {@link Usuario} a esse repositorio
	 * @param usuario
	 */
	public void adicionar(Usuario usuario) {
		usuarios.put(usuario.getNome()+usuario.getNumeroDoCelular(), usuario);
	}
	 /**
     * O {@link Usuario} editado e passado como argumento. Se ela existir, e deletada e adicionada
     * novamente, atualizando suas informacoes.
     * E usada o retorno do metodo remover para
     * saber se a {@link Usuario} ja faz parte da lista ou nao.
     *
     * @param usuario {@link Usuario} editado
     * @return true , caso a {@link Usuario} tenha sido editada.

     */
	public boolean editar(Usuario usuario) {
		String codigo = usuario.getNome()+usuario.getNumeroDoCelular();
		if (usuarios.containsKey(codigo)) {
			usuarios.remove(codigo);
			return usuarios.put(codigo, usuario) != null;
		}
		return false;
	}
	
	/**
	 * Remove {@link Usuario}
	 * @param usuario
	 * @return
	 */
	public boolean remover(String nome,String telefone) {
		if (recuperar(nome,telefone) != null) {
			return usuarios.remove(nome+telefone) != null;
		}
		return false;
	}
	/**
	 * Verifica se existe algum {@link Usuario}
	 * @param nome
	 * @return
	 */
	public Usuario recuperar(String nome,String telefone) {
		return usuarios.get(nome+telefone);
	}
}
