package main.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.elementos.Item;
import main.repository.UsuarioRepository;
import main.usuario.Usuario;

public class TesteUsuarioRepository {

	UsuarioRepository repositorio = new UsuarioRepository();

	@Before
	public void test() throws Exception {
		repositorio.adiciona(new Usuario("jose", "jjjj", "111"));
		repositorio.adiciona(new Usuario("thiago", "jjjj", "222"));
		repositorio.recuperar("jose", "111").adicionarItemFilme("floresta", 22.0, 120, "aventura", "+16", "11/09/14");
		repositorio.recuperar("jose", "111").adicionarItemSerie("jiji", 12.0, "jiji", 60, "ggg", "grg", 10);
		repositorio.recuperar("jose", "111").adicionarItemShow("hhh", 30.0, 23, 12, "jiji", "jiji");
		repositorio.recuperar("jose", "111").adicionarItemJogoTabuleiro("ddd", 24.0);
		repositorio.recuperar("jose", "111").adiconarItemJogoEletronico("fff", 26.0, "jojo");

		repositorio.recuperar("thiago", "222").adicionarItemFilme("lll", 11.0, 26, "kklkl", "koko", "oooo");
		repositorio.recuperar("thiago", "222").adicionarItemSerie("qqq", 45, "llll", 45, "kokoko", "ppp", 9);
		repositorio.recuperar("thiago", "222").adicionarItemShow("oooo", 34, 79, 34, "aaaa", "12");
		repositorio.recuperar("thiago", "222").adicionarItemJogoTabuleiro("zzz", 23);
		repositorio.recuperar("thiago", "222").adiconarItemJogoEletronico("lnnn", 89, "lll");

	}

	@Test
	public void ordenacaoItensNome() {
		assertEquals("JOGO DE TABULEIRO: ddd, R$ 24.0, Nao emprestado, COMPLETO|JOGO ELETRONICO: fff, R$ 26.0, Nao emprestado, jojo|FILME: floresta, R$ 22.0, Nao emprestado, 120 min, +16, aventura, 11/09/14|SHOW: hhh, R$ 30.0, Nao emprestado, 23 min, jiji, jiji, 12 faixas|SERIE: jiji, R$ 12.0, Nao emprestado, 0 min, ggg, grg, Temporada 10|FILME: lll, R$ 11.0, Nao emprestado, 26 min, koko, kklkl, oooo|JOGO ELETRONICO: lnnn, R$ 89.0, Nao emprestado, lll|SHOW: oooo, R$ 34.0, Nao emprestado, 79 min, 12, aaaa, 34 faixas|SERIE: qqq, R$ 45.0, Nao emprestado, 0 min, kokoko, ppp, Temporada 9|JOGO DE TABULEIRO: zzz, R$ 23.0, Nao emprestado, COMPLETO|",
				repositorio.ordenacaoItensNome());
	}

	@Test
	public void ordenacaoItensValor() {
		assertEquals("FILME: lll, R$ 11.0, Nao emprestado, 26 min, koko, kklkl, oooo|SERIE: jiji, R$ 12.0, Nao emprestado, 0 min, ggg, grg, Temporada 10|FILME: floresta, R$ 22.0, Nao emprestado, 120 min, +16, aventura, 11/09/14|JOGO DE TABULEIRO: zzz, R$ 23.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: ddd, R$ 24.0, Nao emprestado, COMPLETO|JOGO ELETRONICO: fff, R$ 26.0, Nao emprestado, jojo|SHOW: hhh, R$ 30.0, Nao emprestado, 23 min, jiji, jiji, 12 faixas|SHOW: oooo, R$ 34.0, Nao emprestado, 79 min, 12, aaaa, 34 faixas|SERIE: qqq, R$ 45.0, Nao emprestado, 0 min, kokoko, ppp, Temporada 9|JOGO ELETRONICO: lnnn, R$ 89.0, Nao emprestado, lll|", repositorio.ordenacaoItensValor());

	}

}
