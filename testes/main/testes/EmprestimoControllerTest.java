package main.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.controller.EmprestimoController;
import main.controller.ItemController;
import main.controller.UsuarioController;
import main.exception.DadoInvalido;

public class EmprestimoControllerTest {

	private UsuarioController usuarioController;
	private EmprestimoController emprestimoController;
	private ItemController itemController;
	
	@Before
	public void setUp() throws Exception {
		emprestimoController = new EmprestimoController();
		usuarioController = new UsuarioController();
		itemController = new ItemController();
		usuarioController.adicionar("Redson", "98888-8888", "redson.filho@ccc.ufcg.edu.br");
		usuarioController.adicionar("Joao", "89999-9999", "joao.soares@ccc.ufcg.edu.br");
		usuarioController.adicionar("Lucas", "97777-7777", "lucas.anthony@ccc.ufcg.edu.br");
		usuarioController.adicionar("Pedro", "96666-6666", "pedro.wanderley@ccc.ufcg.edu.br");
		itemController.cadastrarEletronico("Joao", "89999-9999", "Super Mario", 20, "Super Nintendo");
		itemController.cadastrarEletronico("Joao", "89999-9999", "FIFA 18", 99.90, "PS4");
		itemController.cadastrarEletronico("Redson", "98888-8888", "PES 18", 99.90, "PS4");
		itemController.cadastrarJogoTabuleiro("Pedro", "96666-6666", "Xadrez", 20);
		itemController.cadastrarBluRayFilme("Lucas", "97777-7777", "Kung-Fu Futebol Clube", 3.50, 113, "Esportes/Acao", "12", "2001");
		itemController.cadastrarBluRaySerie("Redson", "89999-9999", "The Flash", 30, "The Flash e uma serie de televisão americana desenvolvida por Greg Berlanti, Andrew Kreisberg e Geoff Johns, e estrelada por Grant Gustin.", 40, "12", "Super-Heroi/Acao/Ficcao Cientifica", 3);
		emprestimoController.registrarEmprestimo("Redson", "98888-8888", "Joao", "89999-9999", "The Flash", "09/08/2017", 7);
		emprestimoController.registrarEmprestimo("Joao", "89999-9999", "Redson", "98888-8888", "Super Mario", "18/08/2017", 5);
		emprestimoController.registrarEmprestimo("Lucas", "97777-7777", "Redson", "89999-9999", "Kung-Fu Futebol Clube", "29/08/2017", 3);
		emprestimoController.registrarEmprestimo("Pedro", "96666-6666", "Lucas", "97777-7777", "Xadrez", "10/11/2017", 1);
	}
	
	@Test
	public void testListarItensEmprestados() throws Exception {
		assertEquals("", emprestimoController.listarItensEmprestados());
	}
	
}
