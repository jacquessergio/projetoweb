package br.com.fabricaweb.projetoweb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import br.com.fabricaweb.projetoweb.persistencia.entidade.Usuario;
import br.com.fabricaweb.projetoweb.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller")
public class UsuarioController extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		Usuario usu = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		String action = "";
		
		if(req.getParameter("action") != null){
		 
			action = req.getParameter("action");
		}
		
		if(action.equals("alter")){
			
			usu.setId(Integer.parseInt(req.getParameter("id")));
			usu.setNome(req.getParameter("nome"));
			usu.setLogin(req.getParameter("login"));
			usu.setSenha(req.getParameter("senha"));
			
			usuarioDAO.alterar(usu);
			resp.getWriter().print("<b>Alterado com sucesso!!!</b> <br /> <a href='./'>Voltar</a>");
			
		}else if(action.equals("del")){
			
			usu.setId(Integer.parseInt(req.getParameter("id")));
			usuarioDAO.excluir(usu);
			resp.getWriter().print("<b>Excluido com sucesso!!!</b> <br /> <a href='./'>Voltar</a>");

			
		}else{
			
			//convert o tipo string para inteiro
			//usu.setId(Integer.parseInt(req.getParameter("id")));
			
			usu.setNome(req.getParameter("nome"));
			usu.setLogin(req.getParameter("login"));
			usu.setSenha(req.getParameter("senha"));
			
			usuarioDAO.cadastrar(usu);
			
			//System.out.println("Cadastrado via POST");
			
			//RETORNA UMA RESPOSTA AO USUÁRIO...
			resp.getWriter().print("<b>Cadastrado com sucesso!!!</b> <br /> <a href='./'>Voltar</a>");
			
		}
		

		
	}
	

}
