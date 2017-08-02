package main.repository;

import java.util.ArrayList;
import java.util.List;

import main.elementos.Usuario;

/**
 * Classe responsavel pelo CRUD de {@link Usuario}
 *
 */
public class UsuarioRepository {
	private List<Usuario> usuarios;

	/**
	 * Construtor de {@link UsuarioRepository} inicia um ArrayList do tipo
	 * {@link Usuario}
	 */
	public UsuarioRepository() {
		usuarios = new ArrayList<>();
	}
	/**
	 * Adiciona um {@link Usuario} a esse repositorio
	 * @param usuario
	 */
	public void adicionar(Usuario usuario) {
		usuarios.add(usuario);
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
		if (!(remover(usuario.getNome()))) {
			return false;
		}
		adicionar(usuario);
		return true;
	}
	/**
	 * Remove {@link Usuario}
	 * @param usuario
	 * @return
	 */
	public boolean remover(String nome) {
		if (recuperar(nome) != null) {
			return usuarios.remove(recuperar(nome));
		}
		return false;
	}
	/**
	 * Verifica se existe algum {@link Usuario}
	 * @param nome
	 * @return
	 */
	public Usuario recuperar(String nome) {
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nome)) {
				return usuario;
			}
		}
		return null;
	}
}
