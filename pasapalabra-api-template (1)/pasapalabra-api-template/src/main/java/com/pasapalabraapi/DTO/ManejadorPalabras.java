package com.pasapalabraapi.DTO;
import java.sql.*;

import java.util.ArrayList;

public class ManejadorPalabras {

private ArrayList<Palabra> palabra;
	
	public ManejadorPalabras() {
		this.palabra = new ArrayList<Palabra>();
	}
	
	
	public static ArrayList<Palabra> crearNuevaPalabra( String definicion, String letra, boolean empieza, String categoria, String respuesta ){
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
				
		PreparedStatement consulta;
		try {
			consulta = con.prepareStatement("INSERT INTO Palabra(defininicion, letra, codigo, veces_usad, veces_acertad, empieza, nombre_categoria, palabra) values(?,?,null,0,0,?,?,?)");
	        consulta.setString(1, definicion);
	        consulta.setString(2, letra);
	        consulta.setBoolean(3, empieza);
	        consulta.setString(4, categoria);
	        consulta.setString(5, respuesta);

	        consulta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void eliminarPalabra( int codigo ) {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		PreparedStatement consulta;
		try {
			consulta = con.prepareStatement("DELETE FROM Palabra WHERE codigo=?");
	        consulta.setInt(1, codigo);
	        consulta.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Palabra> obtenerPalabras() {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();

		try {
			 char[] letras = new char[]{ 'a','b','c','d','e','f','g','h','i','j','l','m','n','ñ','o','p','q','r','s','t','u','v','x','y','z' }; 

		for(int i = 0; i<letras.length; i++) {
			Statement stmt = con.createStatement();
			String query = "select * from Palabra where letra = \""+ letras[i] + "\" order by veces_usad asc limit 1;";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				String definicion = rs.getString(1);
				String letra = rs.getString(2);
				int codigo = rs.getInt(3);
				int veces_usad = rs.getInt(4);
				int veces_acertad = rs.getInt(5);
				boolean empieza = rs.getBoolean(6);
				String nombre_categoria = rs.getString(7);
				String respuesta = rs.getString(8);
				PreparedStatement consulta = con.prepareStatement("UPDATE Palabra SET veces_usad= ? WHERE codigo = ?");
                consulta.setInt(1, veces_usad + 1);
                consulta.setInt(2, codigo);
                consulta.executeUpdate();
				
				Palabra pal = new Palabra(definicion, letra, codigo, veces_usad, veces_acertad, empieza, nombre_categoria, respuesta );
				palabras.add(pal);

			}
		}

	}catch (SQLException e) {
		e.printStackTrace();
	}
		return palabras;
	}
	
	public static ArrayList<Palabra> obtenerPalabras( String categoria ) {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();

		try {
			 char[] letras = new char[]{ 'a','b','c','d','e','f','g','h','i','j','l','m','n','ñ','o','p','q','r','s','t','u','v','x','y','z' }; 

			for(int i = 0; i<letras.length; i++) {
				Statement stmt = con.createStatement();
				String query = "select * from Palabra where letra = \""+ letras[i] + "\" and nombre_categoria = \""+ categoria +"\" order by veces_usad asc limit 1;";
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next()) {
					String definicion = rs.getString(1);
					String letra = rs.getString(2);
					int codigo = rs.getInt(3);
					int veces_usad = rs.getInt(4);
					int veces_acertad = rs.getInt(5);
					boolean empieza = rs.getBoolean(6);
					String nombre_categoria = rs.getString(7);
					String respuesta = rs.getString(8);
					PreparedStatement consulta = con.prepareStatement("UPDATE Palabra SET veces_usad= ? WHERE codigo = ?");
	                consulta.setInt(1, veces_usad + 1);
	                consulta.setInt(2, codigo);
	                consulta.executeUpdate();
					Palabra pal = new Palabra(definicion, letra, codigo, veces_usad, veces_acertad, empieza, nombre_categoria, respuesta );
					palabras.add(pal);
				}
			}

	}catch (SQLException e) {
		e.printStackTrace();
	}
		return palabras;
	}

}
