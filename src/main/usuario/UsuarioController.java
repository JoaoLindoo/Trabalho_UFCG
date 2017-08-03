package main.usuario;
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
	/**
	 * Adiciona um {@link Usuario} em um sistema de usuarios
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param email Email do usuario
	 * @throws Exception Verifica se ja existe um usuario no sistema caso verdade , lanca um Exception
	 */
	public void adicionar(String nome, String telefone, String email)throws Exception {
		if (repository.recuperar(nome,telefone) != null) {
			throw new OperacaoNaoPermitida(USUARIO_CASASTRADO);
		}
		usuario = new Usuario(nome, email, telefone);
		repository.adiciona(usuario);
	}
	/**
	 * Metodo que da uma informacao de um {@link Usuario}
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param atributo Atributo a ser seguido
	 * @return
	 * @throws Exception caso o usuario nao exista
	 */
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
	/**
	 * Remove um usuario do sistema
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @throws Exception caso o usuario nao exista
	 */
	public void removerUsuario(String nome,String telefone)throws Exception{
		if (repository.recuperar(nome,telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		repository.remover(nome,telefone);
	}
	/**
	 * Atualiza um {@link Usuario} de acordo com um atributo
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @param atributo Atributo que determina como vai ser a modificacao
	 * @param valor Valor é a variavel que vai atualizar o usuario
	 */
	public void atualizarUsuario(String nome,String telefone , String atributo, String valor) throws Exception{
		if (repository.recuperar(nome,telefone) == null) {
			throw new DadoInvalido(USUARIO_INVALIDO);
		}
		repository.editar(nome, telefone, atributo, valor);
		
	}
	/**
	 * Recupera um {@link Usuario} no sistema
	 * @param nome Nome do usuario
	 * @param telefone Telefone do usuario
	 * @return
	 */
	public Usuario recuperar(String nome,String telefone){
		return recuperar(nome, telefone);
	}
}
