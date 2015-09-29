package br.com.mktsolutions.dao;
import java.sql.*;

import br.com.mktsolutions.domain.Status;
import br.com.mktsolutions.factory.ConexaoFactory;

public class StatusDAO{
	
	public static void salvar(Status s){
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO ");
		sql.append("status (descricao) " );
		sql.append("VALUES (?)");
		
		
		try {
			Connection conexao = ConexaoFactory.conectar();
			PreparedStatement comando = conexao.prepareStatement(sql.toString());
			comando.setString(1, s.getDescricao());
			comando.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Status s = new Status();		
		s.setDescricao("ativo");
		salvar(s);
	}

}
