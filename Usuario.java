package Pacote;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*; 

public class Usuario {
	private String email, nome, senha;

	public Usuario(String email, String nome, String senha) throws Exception {
		this.setEmail(email);
		this.setNome(nome);
		this.setSenha(senha);
	}
	public String getEmail() {
		return email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public String setEmail(String email) throws Exception {
		if (!validaEmail(email))
			throw new Exception("E-mail invalido.");
		return this.email = email;
	}

	public String setNome(String nome) throws Exception {
		if (nome == "" | nome == null)
			throw new Exception("Nome invalido.");
		return this.nome = nome;
	}

	public String setSenha(String senha) throws Exception {
		if (senha.length() < 6) 
			throw new Exception("Senha muito curta");	
		if (senha.length() > 8) 
			throw new Exception("Senha muito longa");
		return this.senha = senha;
	}

	public boolean validaEmail(String email) {
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String dicaDeSenha(String dica) {
		return dica;
	}
	
	@Override
	public String toString() {
		return "Usuario: " + getNome() + "\nSeu e-mail: " + getEmail();
	}
}
