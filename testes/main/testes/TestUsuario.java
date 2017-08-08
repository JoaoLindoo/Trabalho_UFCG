package main.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.elementos.Usuario;
import main.exception.DadoInvalido;

public class TestUsuario {
	private Usuario usuario;
	
	@Before
	public void setup() {
		
	}
	@Test
	public void testUsuario() throws Exception{
		try {
			usuario = new Usuario("Henrique", "henrique@gmail.com", "");
		} catch (DadoInvalido e) {
			assertEquals("Dado invalido", e.getMessage());
		}
		try {
			usuario = new Usuario("Henrique", "", "3322");
		} catch (DadoInvalido e) {
			assertEquals("Dado invalido", e.getMessage());
		}
		try {
			usuario = new Usuario("", "henrique@gmail.com", "3322");
		} catch (DadoInvalido e) {
			assertEquals("Dado invalido", e.getMessage());
		}
	}
}
