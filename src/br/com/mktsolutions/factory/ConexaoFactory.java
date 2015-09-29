package br.com.mktsolutions.factory;
import br.com.mktsolutions.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO="root"; //PARDRONIZACAO, AS COISAS FINAÉ ASSH,
	private static final String PASS="mysql";
	private static final String URL="jdbc:mysql://localhost:3306/mktsms";
	
	public static Connection conectar() throws SQLException{ 
		Connection conexao = DriverManager.getConnection(URL, USUARIO, PASS);
		return conexao; 
	}
	
	public static void main(String[] args) {
		ConvertStringToMd5 cv = new ConvertStringToMd5();
		System.out.println(cv.convertStringToMd5("pedro1110"));
//	
//		try{
//			Connection teste =  ConexaoFactory.conectar();
//			System.out.println("Conectado com sucesso");
//		}catch(SQLException ex){
//			ex.printStackTrace();
//			System.out.println(ex.getMessage());
//			
//		}
	}
}
