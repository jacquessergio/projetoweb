package br.com.fabricaweb.projetoweb.persistencia.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.fabricaweb.projetoweb.persistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		
		String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome()); //substitui o sinal de ?
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			
			//executa no banco de dados
			preparador.execute();
			//preparador.close();
		
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void alterar(Usuario usu) {
		
String sql = "update usuario set nome=?, login=?, senha=? where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getNome()); //substitui o sinal de ?
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			
			//executa no banco de dados
			preparador.execute();
			//preparador.close();
		
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void excluir(Usuario usu) {
		
		String sql = "delete from usuario where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, usu.getId());
			
			//executa no banco de dados
			preparador.execute();
			//preparador.close();
		
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void salvar(Usuario usuario){
		
		if(usuario.getId() != null){
			
			this.alterar(usuario);
			
		}else{
			
			this.cadastrar(usuario);
		}
	}
	
	
	/**
	 * Busca de um registro no banco por ID do usuário
	 * @param id é um inteiro que represnta o número do ID do usuário a ser buscado
	 * @return Um objeto usuário quando encontra ou Null quando não encontrado
	 */
	public Usuario buscaPorId(Integer id){
		
		String sql = "SELECT * FROM usuario WHERE id = ?";
		
				
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setInt(1, id);
			
			ResultSet resultado = preparador.executeQuery();
			
			//posiciona o cursor
			if(resultado.next()){
				
				Usuario usuario = new Usuario();
				
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	/**
	 * Busca todos usuários no banco de dados
	 * @return Uma lista de objetos Usuario 0 elementos ou N elementos quando encontrado
	 */
	public List<Usuario> buscaTodos(){
		
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> lista = new ArrayList<Usuario>();
				
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
					
			ResultSet resultado = preparador.executeQuery();
			
			//posiciona o cursor
			while(resultado.next()){
				
				Usuario usuario = new Usuario();
				
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				//adiciona usuário na Lista...
				lista.add(usuario);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;
		
	}
	
	/**
	 * Metodo de autenticação de usuário
	 * @param auth Verifica a existencia de usuário com Login no banco de Dados
	 * @return se for verdadeiro retorna o Objeto Usuario se não retorna Null
	 */
	
	public Usuario autenticar(Usuario auth){
		
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)) {
			
			preparador.setString(1, auth.getLogin());
			preparador.setString(2, auth.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				
			auth.setId(resultado.getInt("id"));
			auth.setNome(resultado.getString("nome"));
			auth.setLogin(resultado.getString("login"));
			auth.setSenha(resultado.getString("senha"));
			
			return auth;
			
			}
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	
}
