package br.com.fabricaweb.projetoweb;

import java.util.List;

import br.com.fabricaweb.projetoweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.projetoweb.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO{
	
	public static void main(String[] args){
		
		//testSalvar();
		//testExcluir();
		//testeBuscaporID();
		//testeBuscarTodos();
		testeAutenticar();
				
	}
	private static void testeAutenticar() {
		
		Usuario usu = new Usuario();
	    usu.setLogin("josenunes");
	    usu.setSenha("12345");
	    
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		//Pegando o retorno Ex. 1
		usuDAO.autenticar(usu);
		
		//Pegando o retorno Ex. 2
		// Usuario usuRetorno = usuDAO.autenticar(usu);
		
		//Imprimindo direto
		System.out.println(usuDAO.autenticar(usu));
		
	}
	private static void testeBuscaporID() {
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		Usuario usu = usuDAO.buscaPorId(2);
	
		System.out.println(usu);

	}
	private static void testeBuscarTodos() {
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		List<Usuario> lista = usuDAO.buscaTodos();
	
		for(Usuario u: lista){
			System.out.println(u);
		}
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
		usu.setId(5);
		
		//cadastrando usuario no banco
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		
		System.out.println("Excluido com sucesso");
	}
	
	public static void testSalvar(){
		
		Usuario usuario = new Usuario();
		usuario.setId(null); // se for null insere no banco se não alterar
		usuario.setNome("Jose");
		usuario.setLogin("josenunes");
		usuario.setSenha("1234");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		System.out.println("Salvo com sucesso!");
		
	}
	
}
