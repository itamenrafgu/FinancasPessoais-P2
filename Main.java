package Pacote;

import projetop2.utils.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String args[]) throws Exception{
		List<Usuario> user = new ArrayList<Usuario>();	
		ArquivoDeDados<List<Usuario>> dados = new ArquivoDeDados<List<Usuario>>("Dados.txt"); 
		GerenteDeUsuarios GDU = new GerenteDeUsuarios();		
		
		Usuario a = new Usuario("mendel_sa@hotmail.com", "Mendel", "Senha6");
		user.add(a);
		GDU.adicionaUsuario(a);
		dados.salvaObjeto(user);
		dados.carregaObjetos();
	}
}
