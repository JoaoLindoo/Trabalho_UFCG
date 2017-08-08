package main.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.controller.SistemaController;
import main.exception.DadoInvalido;
import main.repository.UsuarioRepository;

public class TestUsuarioController {
	private SistemaController controller;
	private UsuarioRepository repositorio;
	
	@Before
	public void testAdicionar() throws Exception {
		controller = new SistemaController();
		repositorio = new UsuarioRepository();
		
		controller.adicionar("Joao", "3322", "henrique@gmail.com");
		controller.cadastrarBluRayFilme("Joao", "3322", "Pneu Assasino", 10, 60, "Terror", "14", "2016");
		controller.cadastrarBluRayFilme("Joao", "3322", "Jogos Mortais", 15, 60, "Terror", "16", "2016");
		controller.cadastrarBluRayFilme("Joao", "3322", "Xuxa", 2, 60, "Infantil", "14", "2016");
		controller.cadastrarBluRayFilme("Joao", "3322", "Xuxa o retorno do pacto", 50, 60, "Terror", "14", "2020");
		controller.cadastrarEletronico("Joao", "3322", "Guitarrinha", 150, "Pancadão");
		
		controller.adicionar("Redson", "7813", "redson@ccc.ufcg.br");
		controller.cadastrarBluRaySerie("Redson", "7813", "24 Horas", 100, "Vida loka", 500, "18", "Ação", 1);
		controller.cadastrarBluRaySerie("Redson", "7813", "Supernatural", 100, "Caçando o capeta", 500, "18", "Ação", 1);
	}
	@Test
	public void testAdicionarException() throws Exception{
		try {
			controller.adicionar("", "3322-55544", "jf");
		} catch (DadoInvalido e) {
			assertEquals("Dado invalido", e.getMessage());
		}
	}
	@Test
	public void testGetInfoUsuario() throws Exception {
		assertEquals("henrique@gmail.com", controller.getInfoUsuario("Joao", "3322", "email"));
	}

	@Test
	public void testOrdenacaoValor() {
		assertEquals("FILME: Xuxa, R$ 2.0, Nao emprestado, 60 min, 14, Infantil, 2016|"
				+ "FILME: Pneu Assasino, R$ 10.0, Nao emprestado, 60 min, 14, Terror, 2016|"
				+ "FILME: Jogos Mortais, R$ 15.0, Nao emprestado, 60 min, 16, Terror, 2016|"
				+ "FILME: Xuxa o retorno do pacto, R$ 50.0, Nao emprestado, 60 min, 14, Terror, 2020|"
				+ "SERIE: Supernatural, R$ 100.0, Nao emprestado, 0 min, 18, Ação, Temporada 1|"
				+ "SERIE: 24 Horas, R$ 100.0, Nao emprestado, 0 min, 18, Ação, Temporada 1|"
				+ "JOGO ELETRONICO: Guitarrinha, R$ 150.0, Nao emprestado, Pancadão|", controller.ordenacaoItensValor());
	}

	@Test
	public void testOrdenacaNome() {
		assertEquals("SERIE: 24 Horas, R$ 100.0, Nao emprestado, 0 min, 18, Ação, Temporada 1|"
				+ "JOGO ELETRONICO: Guitarrinha, R$ 150.0, Nao emprestado, Pancadão|"
				+ "FILME: Jogos Mortais, R$ 15.0, Nao emprestado, 60 min, 16, Terror, 2016|"
				+ "FILME: Pneu Assasino, R$ 10.0, Nao emprestado, 60 min, 14, Terror, 2016|"
				+ "SERIE: Supernatural, R$ 100.0, Nao emprestado, 0 min, 18, Ação, Temporada 1|"
				+ "FILME: Xuxa, R$ 2.0, Nao emprestado, 60 min, 14, Infantil, 2016|"
				+ "FILME: Xuxa o retorno do pacto, R$ 50.0, Nao emprestado, 60 min, 14, Terror, 2020|", controller.listarItensOrdenadosPorNome());
	}
	
	@Test
	public void testGetInfoItem() throws Exception{
		assertEquals("50.0", controller.getInfoItem("Joao", "3322", "Xuxa o retorno do pacto", "preco"));
		assertEquals("2.0", controller.getInfoItem("Joao", "3322", "Xuxa", "preco"));
	}
	@Test
	public void testPesquisarDetalhesItem() throws Exception{
		assertEquals("SERIE: Supernatural, R$ 100.0, Nao emprestado, 0 min, 18, Ação, Temporada 1", controller.pesquisarDetalhesItem("Redson", "7813", "Supernatural"));
	}

}
