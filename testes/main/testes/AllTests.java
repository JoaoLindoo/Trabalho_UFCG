package main.testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JogoDeTabuleiroTest.class, JogoEletronicoTest.class, TestUsuarioController.class,
		TestUsuarioRepository.class })
public class AllTests {

}
