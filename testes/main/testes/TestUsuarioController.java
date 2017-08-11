package main.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.controller.SistemaController;
import main.exception.DadoInvalido;
import main.repository.UsuarioRepository;

/**
 * Testa o controller de usuario
 * 
 * @author Joao Henrique
 *
 */
public class TestUsuarioController {

	private SistemaController controller;
	private UsuarioRepository repositorio;

	/**
	 * Metodo que eh executado antes da execussão de qualquer outro
	 * 
	 * @throws Exception
	 */
	@Before
	public void testAdicionar() throws Exception {

		controller = new SistemaController();
		repositorio = new UsuarioRepository();

		controller.adicionar("Joao", "3322", "henrique@gmail.com");
		controller.cadastrarBluRayFilme("Joao", "3322", "Pneu Assasino", 10, 60, "Terror", "14", "2016");
		controller.cadastrarBluRayFilme("Joao", "3322", "Jogos Mortais", 15, 60, "Terror", "16", "2016");
		controller.cadastrarBluRayFilme("Joao", "3322", "Xuxa", 2, 60, "Infantil", "14", "2016");
		controller.cadastrarBluRayFilme("Joao", "3322", "Xuxa o retorno do pacto", 50, 60, "Terror", "14", "2020");
		controller.cadastrarEletronico("Joao", "3322", "Guitarrinha", 150, "Pancadï¿½o");

		controller.adicionar("Redson", "7813", "redson@ccc.ufcg.br");
		controller.cadastrarBluRaySerie("Redson", "7813", "24 Horas", 100, "Vida loka", 500, "18", "Aï¿½ï¿½o", 1);
		controller.cadastrarBluRaySerie("Redson", "7813", "Supernatural", 100, "Caï¿½ando o capeta", 500, "18",
				"Aï¿½ï¿½o", 1);
	}

	/**
	 * Testa o metodo adicionar
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAdicionarException() throws Exception {
		try {
			controller.adicionar("", "3322-55544", "jf");
		} catch (DadoInvalido e) {
			assertEquals("Dado invalido", e.getMessage());
		}
	}

	/**
	 * Testa o metodo getInfoUsuario()
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInfoUsuario() throws Exception {
		assertEquals("henrique@gmail.com", controller.getInfoUsuario("Joao", "3322", "email"));
	}

	/**
	 * Testa o metodo ordenacaoValor()
	 */
	@Test
	public void testOrdenacaoValor() {
		assertEquals(
				"FILME: Xuxa, R$ 2.0, Nao emprestado, 60 min, 14, Infantil, 2016|"
						+ "FILME: Pneu Assasino, R$ 10.0, Nao emprestado, 60 min, 14, Terror, 2016|"
						+ "FILME: Jogos Mortais, R$ 15.0, Nao emprestado, 60 min, 16, Terror, 2016|"
						+ "FILME: Xuxa o retorno do pacto, R$ 50.0, Nao emprestado, 60 min, 14, Terror, 2020|"
						+ "SERIE: Supernatural, R$ 100.0, Nao emprestado, 0 min, 18, Aï¿½ï¿½o, Temporada 1|"
						+ "SERIE: 24 Horas, R$ 100.0, Nao emprestado, 0 min, 18, Aï¿½ï¿½o, Temporada 1|"
						+ "JOGO ELETRONICO: Guitarrinha, R$ 150.0, Nao emprestado, Pancadï¿½o|",
				controller.ordenacaoItensValor());
	}

	/**
	 * Testa o metodo ordenaNome())
	 */
	@Test
	public void testOrdenacaNome() {
		assertEquals(
				"SERIE: 24 Horas, R$ 100.0, Nao emprestado, 0 min, 18, Aï¿½ï¿½o, Temporada 1|"
						+ "JOGO ELETRONICO: Guitarrinha, R$ 150.0, Nao emprestado, Pancadï¿½o|"
						+ "FILME: Jogos Mortais, R$ 15.0, Nao emprestado, 60 min, 16, Terror, 2016|"
						+ "FILME: Pneu Assasino, R$ 10.0, Nao emprestado, 60 min, 14, Terror, 2016|"
						+ "SERIE: Supernatural, R$ 100.0, Nao emprestado, 0 min, 18, Aï¿½ï¿½o, Temporada 1|"
						+ "FILME: Xuxa, R$ 2.0, Nao emprestado, 60 min, 14, Infantil, 2016|"
						+ "FILME: Xuxa o retorno do pacto, R$ 50.0, Nao emprestado, 60 min, 14, Terror, 2020|",
				controller.listarItensOrdenadosPorNome());
	}

	/**
	 * Testa o metodo getInfoItem()
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInfoItem() throws Exception {
		assertEquals("50.0", controller.getInfoItem("Joao", "3322", "Xuxa o retorno do pacto", "preco"));
		assertEquals("2.0", controller.getInfoItem("Joao", "3322", "Xuxa", "preco"));
	}

	/**
	 * Testa o metodo pesquisarDetalhesItem()
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPesquisarDetalhesItem() throws Exception {
		assertEquals("SERIE: Supernatural, R$ 100.0, Nao emprestado, 0 min, 18, Aï¿½ï¿½o, Temporada 1",
				controller.pesquisarDetalhesItem("Redson", "7813", "Supernatural"));
	}

}
