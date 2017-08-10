package main.testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.elementos.Emprestimo;
import main.elementos.JogoEletronico;
import main.elementos.Usuario;
import main.repository.EmprestimoRepository;

/**
 * Classe que testa a Classe EmprestimoRepository
 * @author redson
 *
 */
public class EmprestimoRepositoryTest {

	private EmprestimoRepository repository;
	private Emprestimo emprestimo;
	private Usuario usuario1;
	private Usuario usuario2;
	private Date data;
	private JogoEletronico item;
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		repository = new EmprestimoRepository();
		usuario1 = new Usuario("Redson", "redson.filho@ccc.ufcg.edu.br", "991904203");
		usuario2 = new Usuario("Joao", "joao.soares@ccc.ufcg.edu.br", "991240666");
		data = new Date("23/08/2017");
		item = new JogoEletronico("PES 18", 99.90, "PS4");
		emprestimo = new Emprestimo(usuario1, usuario2, item, data, 7);
		repository.adicionar(emprestimo);
		
	}
	
	/**
	 * Teste para recuperar o Emprestimo a partir do nome do item.
	 */
	@Test
	public void testRecuperar() {
		assertNotNull(repository.recuperar("PES 18"));
	}

	/**
	 * Teste para remover o Emprestimo a partir do nome do item.
	 */
	@Test
	public void testRemove() {
		repository.remove("PES 18");
		assertNull(repository.recuperar("PES 18"));
	}

}
