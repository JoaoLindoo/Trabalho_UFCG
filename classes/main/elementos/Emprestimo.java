package main.elementos;
import java.util.Date;

public class Emprestimo {
	
	private Usuario usuarioDono;
	private Usuario usuarioRequerente;
	private Item itemEmprestado;
	private Date dataEmprestimo;
	private int tempoEmprestimo;
	private Date dataDevolucao;
	public Emprestimo(Usuario usuarioDono, Usuario usuarioRequerente, Item itemEmprestado, Date dataEmprestimo,
			int tempoEmprestimo) {
		this.usuarioDono = usuarioDono;
		this.usuarioRequerente = usuarioRequerente;
		this.itemEmprestado = itemEmprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.tempoEmprestimo = tempoEmprestimo;
		this.dataDevolucao = dataDevolucao;
	}
	public Usuario getUsuarioDono() {
		return usuarioDono;
	}
	public void setUsuarioDono(Usuario usuarioDono) {
		this.usuarioDono = usuarioDono;
	}
	public Usuario getUsuarioRequerente() {
		return usuarioRequerente;
	}
	public void setUsuarioRequerente(Usuario usuarioRequerente) {
		this.usuarioRequerente = usuarioRequerente;
	}
	public Item getItemEmprestado() {
		return itemEmprestado;
	}
	public void setItemEmprestado(Item itemEmprestado) {
		this.itemEmprestado = itemEmprestado;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public int getTempoEmprestimo() {
		return tempoEmprestimo;
	}
	public void setTempoEmprestimo(int tempoEmprestimo) {
		this.tempoEmprestimo = tempoEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getItem() {
		return itemEmprestado.getNome() ;
	}
}
