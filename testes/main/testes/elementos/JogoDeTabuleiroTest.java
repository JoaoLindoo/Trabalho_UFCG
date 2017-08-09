package main.testes.elementos;

import org.junit.Test;

import main.elementos.JogoDeTabuleiro;
import main.exception.DadoInvalido;

public class JogoDeTabuleiroTest {

	@Test(expected = Exception.class)
	public void testNomeVazio() throws DadoInvalido {
		JogoDeTabuleiro item = new JogoDeTabuleiro("", 49.90);
	}
	
	@Test(expected = Exception.class)
	public void testNomeNull() throws DadoInvalido {
		JogoDeTabuleiro item = new JogoDeTabuleiro(null, 49.90);
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNull() throws DadoInvalido {
		JogoDeTabuleiro item = new JogoDeTabuleiro("Banco Imobiliario", 0);
	}
	
	@Test(expected = Exception.class)
	public void testPrecoNegativo() throws DadoInvalido {
		JogoDeTabuleiro item = new JogoDeTabuleiro("Banco Imobiliario", -5);
	}

}
