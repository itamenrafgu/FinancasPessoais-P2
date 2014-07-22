package Pacote;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestaUsuario {
	private Usuario user1;
	
	@Test
	public void testaUsuarioValido() {
		try {
			user1 = new Usuario("tony123@gmail.com", "Antonio", "senha1");
			
		} catch (Exception e) {
			Assert.fail("Nao deveria dar Excessao");		
		}
	}
	
	@Test
	public void testaUsuarioInvalido() {
		try {
			user1 = new Usuario("sr_maicao@hotmail.com", "", "senha2");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("mensagem de erro errada", "Nome invalido.", e.getMessage());
		}
		
		try {
			user1 = new Usuario("rayssaQWE@yahoo.com.br", null, "senha3");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("mensagem de erro errada", "Nome invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testaEmail() {
		try {
			user1 = new Usuario("gugubeto__hotmail.com", "Gugu", "senha4");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("mensagem de erro errada", "E-mail invalido.", e.getMessage());
		}
		
		try {
			user1 = new Usuario("gugubeto@", "Mendel", "senha4");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("mensagem de erro errada", "E-mail invalido.", e.getMessage());
		}
	}
	
	@Test
	public void testaSenha() {
		try {
			user1 = new Usuario("mendel_sa@hotmail.com", "Mendel", "senha");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("mensagem de erro errada", "Senha muito curta", e.getMessage());
		}
		
		try {
			user1 = new Usuario("mendel_sa@hotmail.com", "Mendel", "senha123456");
			Assert.fail();
			
		} catch (Exception e) {
			Assert.assertEquals("mensagem de erro errada", "Senha muito longa", e.getMessage());
		}
	}
	
	@Test
	public void testaToString() throws Exception {
		user1 = new Usuario("mendel_sa@hotmail.com", "Mendel", "senha1");
		
		Assert.assertEquals(user1.toString(), "Usuario: Mendel\nSeu e-mail: mendel_sa@hotmail.com");
	}
}

