package Pacote;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*; 

/**
 * Classe que representa um Usuario.
 *  @author Mendelssohn Dantas de Sa - 113210581
 * 	    	Italo Raphael Almeida Costa - 113210419
 *          Italo Simoes Limeira - 113210114
 *	    	Gustavo Adolfo Di Pace Tejo Filho - 113210105
 *  @version 0.1 / 22 de julho de 2014
 */

public class Usuario implements Serializable {
	private String email, nome, senha, dicaSenha;
	private List<Transacao> transacoes;

	/**
	 * Contrutor da classe Usuario
	 * 
	 * @param email 
	 * 			o email do usuario.
	 * @param nome
	 * 			o nome do usuario.
	 * @param senha
	 * 			a senha do usuario.
	 * @throws Exception
	 * 			lanca excecao caso o email for invalido, caso o nome for nulo ou vazio
	 * 			ou a senha for muito longa ou muito curta.
	 */
	public Usuario(String email, String nome, String senha) throws Exception {
		setEmail(email);
		setNome(nome);
		setSenha(senha);
		transacoes = new ArrayList<Transacao>();
	}
	
	/**
	 * Recupera o email do usuario.
	 * 
	 * @return
	 * 		o email do usuario.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Recupera o nome do usuario.
	 * 
	 * @return
	 * 		o nome do usuario.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Recupera a senha do usuario.
	 * 	
	 * @return
	 * 		a senha do usuario.
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Recupera a dica de senha.
	 * 
	 * @return	
	 * 		a dica de senha.
	 */
	public String getDicaDeSenha() {
		return dicaSenha;
	}

	/**
	 * Ajusta o email do usuario.
	 * 
	 * @param email
	 * 		email do usuario.
	 * @return
	 * 		o email do usuario.
	 * @throws Exception
	 * 		lanca excecao caso o email for invalido.
	 */
	public String setEmail(String email) throws Exception {
		checaEmail(email);
		return this.email = email;
	}

	/**
	 * Ajusta o nome do usuario.
	 * 
	 * @param nome
	 * 		nome do usuario.
	 * @return
	 * 		o nome do usuario.
	 * @throws Exception
	 * 		lanca excecao caso o nome for vazio ou nulo.
	 */
	public String setNome(String nome) throws Exception {
		checaNome(nome);
		return this.nome = nome;
	}
	
	/**
	 * Ajusta a senha do usuario.
	 * 
	 * @param senha
	 * 		senha do usuario.
	 * @return
	 * 		a senha do usuario.
	 * @throws Exception
	 * 		lanca excecao caso a senha for muito curta ou muito longa.
	 */
	public String setSenha(String senha) throws Exception {
		checaSenha(senha);
		return this.senha = senha;
	}

	/**
	 * Metodo para validar o email.
	 * 
	 * @param email
	 * 		o email que sera validado.
	 * @return
	 * 		true caso o email for valido ou false se for invalido.
	 */
	private boolean validaEmail(String email) {
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Checa o email do usuario.
	 * 
	 * @param email
	 * 		email do usuario.

	 * @throws Exception
	 * 		lanca excecao caso o email for invalido.
	 */
	private void checaEmail(String email) throws Exception {
		if (!validaEmail(email))
			throw new Exception("E-mail invalido.");
	}
	
	/**
	 * Checa o nome do usuario.
	 * 
	 * @param nome
	 * 		nome do usuario.
	 * @throws Exception
	 * 		lanca excecao caso o nome for vazio ou nulo.
	 */
	private void checaNome(String nome) throws Exception {
		if (nome == null || nome.equals(""))
			throw new Exception("Nome invalido.");
	}
	
	/**
	 * Checa a senha do usuario.
	 * 
	 * @param senha
	 * 		senha do usuario.
	 * @throws Exception
	 * 		lanca excecao caso a senha for muito curta ou muito longa.
	 */
	private void checaSenha(String senha) throws Exception {
		if (senha.length() < 6) 
			throw new Exception("Senha muito curta");	
		if (senha.length() > 8) 
			throw new Exception("Senha muito longa");
	}
	
	/**
	 * Ajusta a dica de senha.
	 * 
	 * @param dica
	 * 		dica de senha desejada pelo usuario.
	 */
	public void setDicaDeSenha(String dica) {
		dicaSenha = dica;
	}
	
	/**
	 * Metodo de representacao textual do usuario.
	 * 
	 * @return 
	 * 		a representacao.
	 */
	@Override
	public String toString() {
		return "Usuario: " + getNome() + "\nSeu e-mail: " + getEmail();
	}
	
	/**
	 * @param obj
	 *            O objeto a comparar com este Usuario.
	 * @return true se o objeto for igual a este Usuario ou false caso contrario.
	 */
	@Override
	public boolean equals(Object obj){
        if (!(obj instanceof Usuario)){
              return false;
       }
       Usuario outroUsuario = (Usuario) obj;
       return getEmail().equals(outroUsuario.getEmail());
	}       
}
