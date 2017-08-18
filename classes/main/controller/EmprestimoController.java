package main.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import main.elementos.Emprestimo;
import main.elementos.Item;
import main.elementos.Usuario;
import main.elementos.ordenacao.ItemOrdenacaoDescricao;
import main.elementos.ordenacao.ItemOrdenacaoPopularidade;
import main.elementos.ordenacao.UsuarioOrdenaPorNome;
import main.exception.DadoInvalido;
import main.repository.EmprestimoRepository;
import main.service.SistemaService;

/**
 * Classe que representa controla o sistema
 * 
 * @author Joao Henrique
 *
 */
public class EmprestimoController {
	private SistemaService sistemaService;
	private EmprestimoRepository emprestimoRepository;
	private static final String USUARIO_INVALIDO = "Usuario invalido";
	private static final String ITEM_JA_EMPRESTADO = "Item emprestado no momento";
	private static final String ITEM_NAO_ENCONTRADO = "Item nao encontrado";
	private static final String EMPRESTIMO_NAO_ENCONTRADO = "Emprestimo nao encontrado";
	private static final String NENHUM_ITEM_EMPRESTADO = "Nenhum item emprestado";
	private static final String NENHUM_ITEM_PEGO_EMPRESTADO = "Nenhum item pego emprestado";
	private static final String NENHUM_EMPRESTIMO_ASSOCIADO_AO_ITEM = "Nenhum emprestimos associados ao item";

	/**
	 * Construtor de sistemaController
	 */
	public EmprestimoController() {
		this.sistemaService = new SistemaService();
		emprestimoRepository = new EmprestimoRepository();
	}
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) throws Exception {

		if (sistemaService.retornaUsuario(nomeDono, telefoneDono) == null
				|| sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente) == null)
			throw new DadoInvalido(USUARIO_INVALIDO);
		if (sistemaService.retornaUsuario(nomeDono, telefoneDono).recuperItem(nomeItem) == null)
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		if (sistemaService.retornaUsuario(nomeDono, telefoneDono).recuperItem(nomeItem).getStatus() == true)
			throw new DadoInvalido(ITEM_JA_EMPRESTADO);

		Usuario dono = sistemaService.retornaUsuario(nomeDono, telefoneDono);
		Usuario requerente = sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente);
		Item item = sistemaService.retornaUsuario(nomeDono, telefoneDono).recuperItem(nomeItem);
		Date data = emprestimoRepository.converteParaData(dataEmprestimo);
		Emprestimo emprestimo = new Emprestimo(dono, requerente, item, data, periodo);
		alocaItemEmprestado(nomeRequerente, telefoneRequerente, item);
		item.setStatus(true);
		emprestimoRepository.adicionar(emprestimo);
		emprestimoRepository.adicionarEmpIntens(emprestimo);
		item.setPopularidade();
		dono.atualizarReputacao(item.getValor() * 0.1);
	}

	/**
	 * Metodo que aloca um item emprestado
	 * 
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            telefone do requerente
	 * @param item
	 *            nome do item
	 */
	public void alocaItemEmprestado(String nomeRequerente, String telefoneRequerente, Item item) {
		sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente).aloca(item);
	}

	/**
	 * Metodo que devolve um item para o seu dono
	 * 
	 * @param nomeDono
	 *            nome do dono
	 * @param telefoneDono
	 *            telefone do dono
	 * @param nomeRequerente
	 *            nome do requerente
	 * @param telefoneRequerente
	 *            telefone do requerente
	 * @param nomeItem
	 *            nome do item
	 * @param dataEmprestimo
	 *            data do emprestimo
	 * @param dataDevolucao
	 *            data da devolucao
	 * @throws Exception
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) throws Exception {
		if (sistemaService.retornaUsuario(nomeDono, telefoneDono) == null
				|| sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente) == null)
			throw new DadoInvalido(USUARIO_INVALIDO);
		if (sistemaService.retornaUsuario(nomeDono, telefoneDono).recuperItem(nomeItem) == null)
			throw new DadoInvalido(ITEM_NAO_ENCONTRADO);
		if (!sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente).recuperaAlocados(nomeItem))
			throw new DadoInvalido(EMPRESTIMO_NAO_ENCONTRADO);
		Item item = sistemaService.retornaUsuario(nomeDono, telefoneDono).recuperItem(nomeItem);
		Date data = emprestimoRepository.converteParaData(dataDevolucao);
		Date dataDoEmprestimo = emprestimoRepository.converteParaData(dataEmprestimo);
		sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente).removerItemEmprestado(nomeItem);
		emprestimoRepository.recuperar(nomeItem).setDataDevolucao(data);
		emprestimoRepository.removerItenList(nomeDono, nomeItem);
		item.setStatus(false);
		sistemaService.retornaUsuario(nomeRequerente, telefoneRequerente)
				.atualizarReputacao(this.atualizacaoReputacao(dataEmprestimo, dataDevolucao, item));
	}

	public String listarItensEmprestados() {
		String listar = "";
		List<Emprestimo> listaUsuario = emprestimoRepository.getEmprestimosItens();
		Collections.sort(listaUsuario, new UsuarioOrdenaPorNome());
		for (Emprestimo emprestimo : listaUsuario) {
			listar += emprestimo.toString2();
		}
		return listar;
	}

	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) throws Exception {
		if (sistemaService.retornaUsuario(nome, telefone) == null)
			throw new DadoInvalido(USUARIO_INVALIDO);
		String lista = "Emprestimos: ";
		for (Emprestimo emprestimo : emprestimoRepository.getEmprestimos()) {
			if (emprestimo.getUsuarioDono().getNome().equals(nome)
					&& emprestimo.getUsuarioDono().getNumeroDoCelular().equals(telefone)) {
				lista += emprestimo.toString();
			}
		}
		if (lista.equals("Emprestimos: "))
			return NENHUM_ITEM_EMPRESTADO;
		return lista;
	}

	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) throws DadoInvalido {
		if (sistemaService.retornaUsuario(nome, telefone) == null)
			throw new DadoInvalido(USUARIO_INVALIDO);
		String lista = "Emprestimos pegos: ";
		for (Emprestimo emprestimo : emprestimoRepository.getEmprestimos()) {
			if (emprestimo.getUsuarioRequerente().getNome().equals(nome)
					&& emprestimo.getUsuarioRequerente().getNumeroDoCelular().equals(telefone)) {
				lista += emprestimo.toString();
			}
		}
		if (lista.equals("Emprestimos pegos: "))
			return NENHUM_ITEM_PEGO_EMPRESTADO;
		return lista;
	}

	public String listarEmprestimosItem(String nomeItem) {
		String lista = "Emprestimos associados ao item: ";
		for (Emprestimo emprestimo : emprestimoRepository.getEmprestimos()) {
			if (emprestimo.getItemEmprestado().getNome().equals(nomeItem)) {
				lista += emprestimo.toString();
			}
		}
		if (lista.equals("Emprestimos associados ao item: "))
			return NENHUM_EMPRESTIMO_ASSOCIADO_AO_ITEM;
		return lista;

	}

	public String listarItensNaoEmprestados() {
		List<Item> lista = new ArrayList<>();
		String saida = "";
		for (Usuario usuario : this.sistemaService.getUsuarios()) {
			for (Item Item : usuario.getListaItens()) {
				if (Item.getStatus() == false) {
					lista.add(Item);
				}
			}
		}
		Collections.sort(lista, new ItemOrdenacaoDescricao());
		for (Item item : lista) {
			saida += item.toString() + "|";
		}
		return saida;
	}

	public String listarTop10Itens() {
		List<Item> itensPopulares = new ArrayList<>();
		for (Usuario usuario : this.sistemaService.getUsuarios()) {
			for (Item Item : usuario.getListaItens()) {
				if (Item.getPopularidade() > 0)
					itensPopulares.add(Item);
			}
		}
		Collections.sort(itensPopulares, new ItemOrdenacaoPopularidade());
		String top10 = "";
		for (int i = 0; i < itensPopulares.size(); i++) {
			if (i == 10) {
				break;
			}
			top10 += i + 1 + ") " + itensPopulares.get(i).getPopularidade() + " emprestimos - "
					+ itensPopulares.get(i).toString() + "|";
		}
		return top10;
	}

	/**
	 * Metodo que retorna a quantidade a ser atualizada na reputacao do usuario
	 * 
	 * @param dataEmprestimo
	 *            data em que foi feito o emprestimo
	 * @param dataDevolucao
	 *            data que foi feita a devolucao do item
	 * @param item
	 *            item devolvido
	 * @return retorna a quantidade a ser atualizada na reputacao do usuario
	 * @throws Exception 
	 */
	public double atualizacaoReputacao(String dataEmprestimo, String dataDevolucao, Item item) throws Exception {
		int dias = this.contaDias(dataEmprestimo, dataDevolucao);
		Emprestimo emprestimoTest = emprestimoRepository.recuperar(item.getNome());
		if (dias > emprestimoTest.getTempoEmprestimo()) {
			int atraso = dias - emprestimoTest.getTempoEmprestimo();
			return -(item.getValor() * (atraso * 0.01));
		}
		return item.getValor() * 0.05;
	}

	public int contaDias(String dataInicial, String dataFinal) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		Date dataInicio = df.parse(dataInicial);
		Date dataFim = df.parse(dataFinal);
		long dt = (dataFim.getTime() - dataInicio.getTime()) + 3600000;
		Long diasCorridosAnoLong = (dt / 86400000L);
		Integer diasDecorridosInt = Integer.valueOf(diasCorridosAnoLong.toString());
		return diasDecorridosInt ;

	}
}