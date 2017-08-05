package main.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import main.elementos.JogoDeTabuleiro;

public class JogoDeTabuleiroTest {

	@Test(expected = Exception.class)
	public void testNomeVazio() throws Exception {
		JogoDeTabuleiro item = new JogoDeTabuleiro("", 49.90);
	}
	
	@Test(expected = Exception.class)
	public void testNomeNull() throws Exception {
		JogoDeTabuleiro item = new JogoDeTabuleiro(null, 49.90);
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNull() throws Exception {
		JogoDeTabuleiro item = new JogoDeTabuleiro("Banco Imobiliario", 0);
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNegativo() throws Exception {
		JogoDeTabuleiro item = new JogoDeTabuleiro("Banco Imobiliario", -5);
	}

}
