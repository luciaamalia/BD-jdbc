package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
	
		Connection conn = null; 		// conectar 
		java.sql.Statement st = null;		  //consultar
		ResultSet rs = null; 		//guardar o resultado em tabela da consulta
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + " , " + rs.getString("Name"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
