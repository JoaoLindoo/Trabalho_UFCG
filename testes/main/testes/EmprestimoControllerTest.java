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
		itemController.cadastrarEletronico("Joao", "89999-9999", "Jogo", 222, "PS4");
		itemController.cadastrarJogoTabuleiro("Redson", "98888-8888", "Xadrez", 50);
		emprestimoController.registrarEmprestimo("Redson", "98888-8888", "Joao", "89999-9999", "Xadrez", "09/08/2017", 4);

	}
	
	@Test
	public void testListarItensEmprestados() throws Exception {
		assertEquals("Dono do item: Redson, Nome do item emprestado: Xadrez|", emprestimoController.listarItensEmprestados());
		assertEquals("Emprestimos pegos: EMPRESTIMO - De: Redson, Para: Joao, Xadrez, 09/08/2017, 4 dias, ENTREGA: Emprestimo em andamento|", emprestimoController.listarEmprestimosUsuarioPegandoEmprestado("Joao", "89999-9999"));
	}
	
	@Test
	public void test() throws Exception {
		assertEquals("Emprestimos pegos: EMPRESTIMO - De: Redson, Para: Joao, Xadrez, 09/08/2017, 4 dias, ENTREGA: Emprestimo em andamento|", emprestimoController.listarEmprestimosUsuarioPegandoEmprestado("Joao", "89999-9999"));
	}
}
