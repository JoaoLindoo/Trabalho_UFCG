package main.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.controller.SistemaController;
import main.exception.DadoInvalido;

/**
 * Essa Classe e responsavel por testar as excecoes da Classe SistemaController.
 * 
 * @author Matheus Thiago
 */
public class SistemaControllerTest {

	SistemaController sistema;

	/**
	 * Metodo que e executado antes de todos os outros
	 * 
	 * @throws Exception
	 */
	@Before
	public void setup() throws Exception {
		this.sistema = new SistemaController();
		sistema.adicionar("Thiago", "8888", "Thiago@gmail.com");
		sistema.cadastrarJogoTabuleiro("Thiago", "8888", "Xadrez", 50);
		sistema.adicionar("Juliana", "9999", "Juliana@gmail.com");
		sistema.cadastrarEletronico("Juliana", "9999", "Jogo", 222, "PS4");
		sistema.registrarEmprestimo("Thiago", "8888", "Juliana", "9999", "Xadrez", "09/08/17", 4);
	}

	/**
	 * Testa o metodo adicionar da classe sistemaController
	 */
	@Test
	public void testAdicionar() {

		// Teste para usuario ja existente.
		try {
			sistema.adicionar("Thiago", "8888", "Thiago@gmail.com");

		} catch (Exception e) {
			assertEquals("main.exception.OperacaoNaoPermitida: Usuario ja cadastrado", e.toString());
		}

		// Teste para usuario com nome vazio.
		try {
			sistema.adicionar("", "8888", "Thiago@gmail.com");

		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Dado invalido", e.toString());
		}

	}

	/**
	 * Testa o metodo getInfoUsuario do sistemaController
	 */
	@Test
	public void testGetInfoUsuario() {

		// Teste para procurar usuario que nao existe.
		try {
			sistema.getInfoUsuario("Maria", "333", "valor");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}

		// * Teste para procurar usuario que nao existe. Numero de telefone nao
		// compativel com o usuario.
		try {
			sistema.getInfoUsuario("Thiago", "333", "valor");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}
	}

	/**
	 * Teste para remover usuario. Usuario nao esta cadastrado.
	 */
	@Test
	public void testRemoverUsuario() {
		try {
			sistema.removerUsuario("Maria", "2222");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}
	}

	/**
	 * Teste para Atualizar Usuario. Usuario nao esta cadastrado.
	 */
	@Test
	public void testAtualizarUsuario() {
		try {
			sistema.atualizarUsuario("Maria", "222", "valor", "22");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}
	}

	/**
	 * Testa o metodo cadastrarEletronico do SistemaController
	 */
	@Test
	public void testCadastrarEletronico() {

		// Teste para cadastrar item com nome vazio.
		try {
			sistema.cadastrarEletronico("Thiago", "8888", "", 22, "PS4");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Nome invalido", e.toString());
		}

		// Teste para cadastrar item com valor menor que zero.
		try {
			sistema.cadastrarEletronico("Thiago", "8888", "Jogo", -2, "PS4");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Preco invalido", e.toString());
		}
	}

	/**
	 * Teste para buscar item que nao esta cadastrado no usuario.
	 */
	@Test
	public void testGetInfoItem() {
		try {
			sistema.getInfoItem("Thiago", "8888", "Dama", "preco");
		} catch (Exception e) {
			assertEquals("main.exception.OperacaoNaoPermitida: Item nao encontrado", e.toString());
		}
	}

	/**
	 * Testa o metodo cadastrarJogoTabuleiro do sistemaController
	 */
	@Test
	public void testCadastrarJogoTabuleiro() {

		// Teste para cadastrar jogo tabuleiro com nome vazio.
		try {
			sistema.cadastrarJogoTabuleiro("Thiago", "8888", "", 23.0);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Nome invalido", e.toString());
		}

		// Teste para cadastrar jogo tabuleiro com valor menor que zero.
		try {
			sistema.cadastrarJogoTabuleiro("Thiago", "8888", "Dama", -1.0);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Preco invalido", e.toString());
		}
	}

	/**
	 * Testa o metodo cadastrarBluRaySerie do sistemaController
	 */
	@Test
	public void testCadastrarBluRaySerie() {

		// Teste para cadastrar serie com nome vazio.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "", 888, "Qualquer", 120, "+10", "aventura", 2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Nome invalido", e.toString());
		}

		// Teste para cadastrar serie com valor menor que zero.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "Serie", 0, "Qualquer", 120, "+10", "aventura", 2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Valor invalido", e.toString());
		}

		// Teste para cadastrar serie com descricao vazia.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "Serie", 10, "", 120, "+10", "aventura", 2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Descricao invalida", e.toString());
		}

		// Teste para cadastrar serie com duracao menor que zero.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "Serie", 10, "Qalquer", 0, "+10", "aventura", 2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Duracao nao pode ser menor ou igual a zero", e.toString());
		}

		// Teste para cadastrar serie com classificacao vazia.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "Serie", 10, "Qualquer", 120, "", "aventura", 2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Classificacao invalida", e.toString());
		}

		// Teste para cadastrar serie com genero vazio.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "Serie", 10, "Qualquer", 120, "+10", "", 2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Genero invalido", e.toString());
		}

		// Teste para cadastrar serie com temporada menor que zero.
		try {
			sistema.cadastrarBluRaySerie("Thiago", "8888", "Serie", 10, "Qualquer", 120, "+10", "aventura", -2);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Temporada invalida", e.toString());
		}

	}

	/**
	 * Testa o metodo cadastraBluRayFilme do sistemaController
	 */
	@Test
	public void testCadastrarBluRayFilme() {

		// Teste para Filme com nome vazio.
		try {
			sistema.cadastrarBluRayFilme("Thiago", "8888", "", 22, 120, "Aventura", "+10", "10/12/15");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Nome invalido", e.toString());
		}

		// Teste para Filme com valor menor que zero.
		try {
			sistema.cadastrarBluRayFilme("Thiago", "8888", "Leao", 0, 120, "Aventura", "+10", "10/12/15");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Valor invalido", e.toString());
		}

		// Teste para Filme com valor menor que zero.
		try {
			sistema.cadastrarBluRayFilme("Thiago", "8888", "Leao", 10, 0, "Aventura", "+10", "10/12/15");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Duracao nao pode ser menor ou igual a zero", e.toString());
		}

		// Teste para Filme com genero vazio.
		try {
			sistema.cadastrarBluRayFilme("Thiago", "8888", "Leao", 10, 10, "", "+10", "10/12/15");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Genero invalido", e.toString());
		}

		// Teste para Filme com classificacao vazia.
		try {
			sistema.cadastrarBluRayFilme("Thiago", "8888", "Leao", 10, 10, "Aventura", "", "10/12/15");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Classificacao invalida", e.toString());
		}

		// Teste para Filme com data vazia.
		try {
			sistema.cadastrarBluRayFilme("Thiago", "8888", "Leao", 10, 10, "Aventura", "+10", "");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Ano de lancamento invalido", e.toString());
		}
	}

	/**
	 * Testa o metodo cadastrarBluRayShow do sistemaController
	 */
	@Test
	public void testCadastrarBluRayShow() {

		// teste para show nome vazio.
		try {
			sistema.cadastrarBluRayShow("Thiago", "8888", "", 22, 120, 10, "jose", "+10");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Nome invalido", e.toString());
		}

		// teste para show com valor menor que zero.
		try {
			sistema.cadastrarBluRayShow("Thiago", "8888", "Show", 0, 120, 10, "jose", "+10");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Valor invalido", e.toString());
		}

		// teste para show com duracao menor que zero.
		try {
			sistema.cadastrarBluRayShow("Thiago", "8888", "Show", 10, -120, 10, "jose", "+10");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Duracao nao pode ser menor ou igual a zero", e.toString());
		}
		// teste para show com faixa menor que zero.
		try {
			sistema.cadastrarBluRayShow("Thiago", "8888", "Show", 10, 120, 0, "jose", "+10");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Numero de faixas invalido", e.toString());
		}

		// teste para show com nome do artista vazio.
		try {
			sistema.cadastrarBluRayShow("Thiago", "8888", "Show", 10, 120, 10, "", "+10");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Nome do artista invalido", e.toString());
		}

		// teste para show com classificacao vazia.
		try {
			sistema.cadastrarBluRayShow("Thiago", "8888", "Show", 10, 120, 10, "Jose", "");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Classificacao invalida", e.toString());
		}
	}

	/**
	 * Testa o emtodo removerItem do sistemaController
	 */
	@Test
	public void testRemoverItem() {

		// teste para remover item que nao esta cadastrado.
		try {
			sistema.removerItem("Thiago", "8888", "Dama");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Item nao encontrado", e.toString());
		}

		// teste para remover item de usuario que nao esta cadastrado.
		try {
			sistema.removerItem("Maria", "8888", "Xadrez");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}
	}

	/**
	 * Testa o metodo atualizarItem do sistemaController
	 */
	@Test
	public void testAtualizarItem() {

		// teste para atualizar item nao cadastrado.
		try {
			sistema.atualizarItem("Thiago", "8888", "Dama", "valor", "88");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Item nao encontrado", e.toString());
		}

		// teste para atualizar item de usuario nao cadastrado.
		try {
			sistema.atualizarItem("Maria", "8888", "Dama", "valor", "88");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}
	}

	/**
	 * Testa o metodo PesquisarDetalhesItem do sistemaController
	 */
	@Test
	public void testPesquisarDetalhesItem() {

		// teste para procurar item de usuario nao cadastrado.
		try {
			sistema.pesquisarDetalhesItem("Maria", "8888", "Xadrez");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}

		// teste para procurar item de usuario nao cadastrado.
		try {
			sistema.pesquisarDetalhesItem("Thiago", "8888", "Dama");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Item nao encontrado", e.toString());
		}
	}

	/**
	 * Testa o metodo registraEmprestimo do sistemaController
	 */
	@Test
	public void testRegistrarEmprestimo() {

		// teste para emprestimo de item de usuário nao cadastrado.
		try {
			sistema.registrarEmprestimo("Maria", "7777", "Thiago", "8888", "Xadrez", "12/10/17", 5);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}

		// teste para emprestimo de item nao cadastrado.
		try {
			sistema.registrarEmprestimo("Thiago", "8888", "Juliana", "9999", "Dama", "12/10/17", 5);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Item nao encontrado", e.toString());
		}

		// teste para emprestimo de item ja emprestado.
		try {
			sistema.registrarEmprestimo("Thiago", "8888", "Juliana", "9999", "Xadrez", "12/10/17", 5);
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Item emprestado no momento", e.toString());
		}

	}

	/**
	 * Testa o metodo devolverItem do sistemaController
	 */
	@Test
	public void testDevolverItem() {

		// teste para devolver item de usuario nao cadastrado.
		try {
			sistema.devolverItem("Maria", "8888", "Juliana", "9999", "Xadrez", "12/10/17", "15/10/17");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Usuario invalido", e.toString());
		}

		// teste para devolver item nao cadastrado.
		try {
			sistema.devolverItem("Thiago", "8888", "Juliana", "9999", "Dama", "12/10/17", "15/10/17");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Item nao encontrado", e.toString());
		}

		// teste para devolver item de empresto nao feito.
		try {
			sistema.devolverItem("Juliana", "9999", "Thiago", "8888", "Jogo", "12/10/17", "15/10/17");
		} catch (Exception e) {
			assertEquals("main.exception.DadoInvalido: Emprestimo nao encontrado", e.toString());
		}
	}

}
