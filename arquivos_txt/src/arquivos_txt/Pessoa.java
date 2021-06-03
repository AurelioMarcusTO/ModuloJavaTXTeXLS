package arquivos_txt;

public class Pessoa {
	
	private String nome;
	private String email;
	private String idade;
	
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
	
	
	
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", idade=" + idade + "]";
	}
	
	
	

}
