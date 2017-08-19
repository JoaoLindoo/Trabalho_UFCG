package main.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.controller.EmprestimoController;
import main.controller.ItemController;
import main.controller.UsuarioController;
import main.exception.DadoInvalido;
import main.facade.TTFacade;

public class EmprestimoControllerTest {
	
	private TTFacade facade;
	
	@Before
	public void setUp() throws Exception {
		facade = new TTFacade();
		facade.cadastrarUsuario("Redson", "98888-8888", "redson.filho@ccc.ufcg.edu.br");
		facade.cadastrarUsuario("Joao", "89999-9999", "joao.soares@ccc.ufcg.edu.br");
		facade.cadastrarUsuario("Lucas", "97777-7777", "lucas.anthony@ccc.ufcg.edu.br");
		facade.cadastrarUsuario("Pedro", "96666-6666", "pedro.wanderley@ccc.ufcg.edu.br");
		facade.cadastrarEletronico("Joao", "89999-9999", "Super Mario", 20, "Super Nintendo");
		facade.cadastrarEletronico("Joao", "89999-9999", "FIFA 18", 99.90, "PS4");
		facade.cadastrarEletronico("Redson", "98888-8888", "PES 18", 99.90, "PS4");
		facade.cadastrarJogoTabuleiro("Pedro", "96666-6666", "Xadrez", 20);
		facade.cadastrarBluRayFilme("Lucas", "97777-7777", "Kung-Fu Futebol Clube", 3.50, 113, "Esportes/Acao", "12", "2001");
		facade.cadastrarBluRaySerie("Redson", "89999-9999", "The Flash", 30, "The Flash e uma serie de televisão americana desenvolvida por Greg Berlanti, Andrew Kreisberg e Geoff Johns, e estrelada por Grant Gustin.", 40, "12", "Super-Heroi/Acao/Ficcao Cientifica", 3);
		facade.registrarEmprestimo("Redson", "98888-8888", "Joao", "89999-9999", "The Flash", "09/08/2017", 7);
		facade.registrarEmprestimo("Joao", "89999-9999", "Redson", "98888-8888", "Super Mario", "18/08/2017", 5);
		facade.registrarEmprestimo("Lucas", "97777-7777", "Redson", "89999-9999", "Kung-Fu Futebol Clube", "29/08/2017", 3);
		facade.registrarEmprestimo("Pedro", "96666-6666", "Lucas", "97777-7777", "Xadrez", "10/11/2017", 1);
	}
	
	@Test
	public void testListarItensEmprestados() throws Exception {
		assertEquals("", facade.listarItensEmprestados());
	}
	
}
