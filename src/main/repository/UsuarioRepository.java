package main.repository;

import java.util.ArrayList;
import java.util.List;

import main.elementos.Usuario;

public class UsuarioRepository {
	private List<Usuario> usuarios;
	
	public UsuarioRepository() {
		usuarios = new ArrayList<>();
	}
	
	public void adicionar(Usuario usuario){
		usuarios.add(usuario);
	}
	public boolean editar(Usuario usuario){
		if (!(remover(usuario))) {
            return false;
        }
        adicionar(usuario);
        return true;
	}
	public boolean remover(Usuario usuario){
		return usuarios.remove(usuario);
	}
	public Usuario recuperar(String nome){
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equalsIgnoreCase(nome)) {
				return usuario;
			}
		}
		return null;
	}
}
