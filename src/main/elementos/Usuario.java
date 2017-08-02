package main.elementos;

public class Usuario {
	
	private String nome;
	private String email;
	private String numeroDoCelular;
	public Usuario(String nome, String email, String numeroDoCelular) {
		this.nome = nome;
		this.email = email;
		this.numeroDoCelular = numeroDoCelular;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroDoCelular() {
		return numeroDoCelular;
	}
	public void setNumeroDoCelular(String numeroDoCelular) {
		this.numeroDoCelular = numeroDoCelular;
	}
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", numeroDoCelular=" + numeroDoCelular + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDoCelular == null) ? 0 : numeroDoCelular.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroDoCelular == null) {
			if (other.numeroDoCelular != null)
				return false;
		} else if (!numeroDoCelular.equals(other.numeroDoCelular))
			return false;
		return true;
	}
	
	
}
