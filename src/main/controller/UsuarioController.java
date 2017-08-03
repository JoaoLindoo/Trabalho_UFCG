package main.controller;
import main.elementos.Usuario;
import main.exception.DadoInvalido;
import main.exception.OperacaoNaoPermitida;
import main.repository.UsuarioRepository;

public class UsuarioController {
	private UsuarioRepository repository;
	private Usuario usuario;
	private static final String ATRIBUTO_EMAIL = "email";
	private static final String ATRIBUTO_TELEFONE = "telefone";
	private static final String USUARIO_INVALIDO = "Usuario invalido";
	private static final String  USUARIO_CASASTRADO = "Usuario ja cadastrado";

	public UsuarioController() {
		repository = new UsuarioRepository();
	}

	public void adicionar(String nome, String telefone, String email)throws Exception {
		if (repository.recuperar(nome,telefone) != null) {
			throw new OperacaoNaoPermitida(USUARIO_CASASTRADO);
		}
		usuario = new Usuario(nome, email, telefone);
		repository.adicionar(usuario);
	}

	public String getInfoUsuario(String nome, String telefone,String atributo) throws Exception {
		usuario = repository.recuperar(nome,telefone);
		if(usuario == null){
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		if (ATRIBUTO_EMAIL.equalsIgnoreCase(atributo)) {
			return usuario.getEmail();
		}
		return null;
	}
	
	public void removerUsuario(String nome,String telefone)throws Exception{
		if (repository.recuperar(nome,telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		repository.remover(nome,telefone);
	}
	
	public void atualizarUsuario(String nome,String telefone , String atributo, String valor) throws Exception{
		if (repository.recuperar(nome,telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		if (ATRIBUTO_EMAIL.equalsIgnoreCase(atributo)) {
			usuario = new Usuario(nome, valor, telefone);
			repository.editar(usuario);
		}
		else if (ATRIBUTO_TELEFONE.equalsIgnoreCase(atributo)) {
			String emailExistente = repository.recuperar(nome, telefone).getEmail();
			repository.remover(nome, telefone);
			usuario = new Usuario(nome, emailExistente, valor);
			repository.adicionar(usuario);
		}
	}
}
