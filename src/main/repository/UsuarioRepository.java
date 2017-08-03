package main.repository;

import java.util.ArrayList;
import java.util.List;

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
	public void adiciona(Usuario usuario){
		usuarios.add(usuario);
	}
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
	public boolean remover(String nome,String telefone){
		return usuarios.remove(recuperar(nome, telefone));
	}
	public void editar(String nome,String telefone,String atributo,String valor){
		if (atributo.equalsIgnoreCase("email")) {
			recuperar(nome, telefone).setEmail(valor);
		}else {
			recuperar(nome, telefone).setNumeroDoCelular(valor);
		}
	}
}