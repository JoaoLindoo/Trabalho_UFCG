package main.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JogoDeTabuleiroTest.class, JogoEletronicoTest.class, TestUsuario.class, TestUsuarioController.class,
		TestUsuarioRepository.class })
public class AllTests {

}
