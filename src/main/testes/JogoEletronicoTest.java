package main.testes;

import org.junit.Test;

import main.elementos.JogoEletronico;

public class JogoEletronicoTest {
	
	@Test(expected = Exception.class)
	public void testNomeVazio() throws Exception {
		JogoEletronico item = new JogoEletronico("", 99.99, "PS4");
	}
	
	@Test(expected = Exception.class)
	public void testNomeNull() throws Exception {
		JogoEletronico item = new JogoEletronico(null, 99.99, "PS4");
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNulo() throws Exception {
		JogoEletronico item = new JogoEletronico("PES 18", 0, "PS4");
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNegativo() throws Exception {
		JogoEletronico item = new JogoEletronico("PES 18", -5, "PS4");
	}
	
	@Test(expected = Exception.class)
	public void testPlataformaVazia() throws Exception {
		JogoEletronico item = new JogoEletronico("PES 18", 99.99, "");
	}
	
	@Test(expected = Exception.class)
	public void testPlataformaNull() throws Exception {
		JogoEletronico item = new JogoEletronico("PES 18", 99.99, null);
	}
	
}
