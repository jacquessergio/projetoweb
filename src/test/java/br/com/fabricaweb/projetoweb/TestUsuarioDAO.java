package br.com.fabricaweb.projetoweb;

import br.com.fabricaweb.projetoweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.projetoweb.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO{
	
	public static void main(String[] args){
		
		testExcluir();
				
	}
	public static void testCadastrar(){
		
		Usuario usu = new Usuario();
		usu.setNome("Pricila");
		usu.setLogin("pricilasoares");
		usu.setSenha("123456");
		
		//cadastrando usuario no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado");
	}
	
	public static void testAlterar(){
		
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("Bianca");
		usu.setLogin("biancasoares");
		usu.setSenha("123456");
		
		//cadastrando usuario no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		
		System.out.println("Alterado com sucesso");
	}
	
	public static void testExcluir(){
		
		Usuario usu = new Usuario();
		usu.setId(3);
		
		//cadastrando usuario no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Excluido com sucesso");
	}
	
}
