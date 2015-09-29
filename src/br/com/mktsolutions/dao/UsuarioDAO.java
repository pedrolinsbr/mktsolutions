package br.com.mktsolutions.dao;
import java.sql.*;
import java.util.ArrayList;

import br.com.mktsolutions.domain.Usuario;
import br.com.mktsolutions.factory.ConexaoFactory;
import br.com.mktsolutions.util.ConvertStringToMd5;

public class UsuarioDAO{

	public static void salvar(Usuario u){
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO ");
		sql.append("usuario (login, nome, empresa, tipo, cpf, endereco, bairro, cidade, pais, uf, tel, cel, senha, status_statusid, creditos, mail ) " );
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		ConvertStringToMd5 convert = new ConvertStringToMd5();
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, u.getLogin());
			comando.setString(2, u.getNome());
			comando.setString(3, u.getEmpresa() );
			comando.setString(4, u.getTipo() );
			comando.setString(5, u.getCpf() );
			comando.setString(6, u.getEndereco() );
			comando.setString(7, u.getBairro() );
			comando.setString(8, u.getCidade() );
			comando.setString(9, u.getPais() );
			comando.setString(10, u.getUf() );
			comando.setString(11, u.getTel() );
			comando.setString(12, u.getCel() );
			comando.setString(13, convert.convertStringToMd5(u.getSenha()) );
			comando.setString(14, u.getStatus_statusid() );			
			comando.setString(15, u.getCreditos() );
			comando.setString(16, u.getMail() );		

			comando.executeUpdate();
			System.out.println("Usuario " +u.getLogin() +" inserido com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro. "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void excluir(Usuario u){
		StringBuilder sql = new StringBuilder();

		sql.append("DELETE FROM ");
		sql.append("usuario " );
		sql.append("WHERE id = ? ");

		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setLong(1, u.getId() );

			comando.executeUpdate();
			System.out.println("Usuario " +u.getLogin() +" excluido com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro. "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static void editar(Usuario u){
		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE ");
		sql.append("usuario set login=?, nome=?, empresa=?, tipo=?, cpf=?, endereco=?, bairro=?, cidade=?, pais=?, uf=?, tel=?, cel=?, senha=?, status_statusid=?, creditos=?, mail=?  " );
		sql.append("WHERE id = ? ");

		ConvertStringToMd5 convert = new ConvertStringToMd5();
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, u.getLogin());
			comando.setString(2, u.getNome());
			comando.setString(3, u.getEmpresa() );
			comando.setString(4, u.getTipo() );
			comando.setString(5, u.getCpf() );
			comando.setString(6, u.getEndereco() );
			comando.setString(7, u.getBairro() );
			comando.setString(8, u.getCidade() );
			comando.setString(9, u.getPais() );
			comando.setString(10, u.getUf() );
			comando.setString(11, u.getTel() );
			comando.setString(12, u.getCel() );
			comando.setString(13, convert.convertStringToMd5(u.getSenha()) );
			comando.setString(14, u.getStatus_statusid() );			
			comando.setString(15, u.getCreditos() );			
			comando.setString(16, u.getMail());
			comando.setLong(17, u.getId());

			comando.executeUpdate();
			System.out.println("Usuario " +u.getLogin() +" alterado com sucesso!!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro. "+e.getMessage());
			e.printStackTrace();
		}
	}

	public static Usuario consulta(Usuario u){
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("id, login, nome, mail, empresa, tipo, cpf, endereco, bairro, cidade, pais, uf, tel, cel, senha, status_statusid, creditos  FROM usuario " );
		sql.append("WHERE login = ? ");

		Usuario retorno = null;

		try {
			Connection conexao = ConexaoFactory.conectar();			
			PreparedStatement comando;
			comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, u.getLogin());			
			ResultSet result = comando.executeQuery();	

			if(result.next()){
				retorno = new Usuario();
				retorno.setNome(result.getString("nome"));
				retorno.setLogin(result.getString("login"));
				retorno.setSenha(result.getString("senha"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Retorno|| Login: " +retorno.getLogin() +" Nome: "+retorno.getNome()+ ", senha: "+retorno.getSenha()+".");
		return retorno;
	}



	public static ArrayList<Usuario> listar(){
		StringBuilder sql = new StringBuilder();
		Usuario retorno = null;
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		
		sql.append("SELECT ");
		sql.append("id, login, nome, mail, empresa, tipo, cpf, endereco, bairro, cidade, pais, uf, tel, cel, senha, status_statusid, creditos  FROM usuario order by nome asc" );

		try {
			Connection conexao = ConexaoFactory.conectar();			
			PreparedStatement comando;
			comando = conexao.prepareStatement(sql.toString());


			ResultSet result = comando.executeQuery();

			while(result.next()){
				retorno = new Usuario();
				retorno.setId(result.getLong("id"));
				retorno.setNome(result.getString("nome"));
				retorno.setLogin(result.getString("login"));
				retorno.setMail(result.getString("mail"));
				retorno.setTipo(result.getString("tipo"));
				retorno.setCpf(result.getString("cpf"));
				retorno.setEndereco(result.getString("endereco"));
				retorno.setBairro(result.getString("bairro"));
				retorno.setCidade(result.getString("cidade"));
				retorno.setPais(result.getString("pais"));
				retorno.setUf(result.getString("uf"));
				retorno.setTel(result.getString("tel"));
				retorno.setCel(result.getString("cel"));
				retorno.setSenha(result.getString("senha"));
				retorno.setStatus_statusid(result.getString("status_statusid"));
				retorno.setCreditos(result.getString("creditos"));	
				
				lista.add(retorno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}



	public static void main(String[] args) {
		Usuario usu = new Usuario();		
		usu.setId(3L); //para declarar long usar a palavra L no fim
		usu.setLogin("pedrolinsbr");
		usu.setNome("Pedro Lins");		
		usu.setEmpresa("AsGa");
		usu.setTipo("1");
		usu.setCpf("37829243808");
		usu.setEndereco("Rod Dr Roberto Moreira, km4");
		usu.setBairro("Recanto dos Passaros");
		usu.setCidade("Paulinia");
		usu.setPais("Brasil");
		usu.setUf("SP");
		usu.setTel("222222222");
		usu.setCel("999299292959");
		usu.setSenha("pedro1110");
		usu.setStatus_statusid("1");			
		usu.setCreditos("100");
		usu.setMail("pedro@asga.com.br");

		ArrayList<Usuario> lista = listar();
		
		try {
			for (Usuario usuario: lista) {
				System.out.println(usuario);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
