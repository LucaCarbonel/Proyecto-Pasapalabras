package com.pasapalabraapi.DTO;
import java.sql.*;

import java.util.ArrayList;

public class ManejadorPalabras {
	
	private ArrayList<Palabra> palabra;
	
	public ManejadorPalabras() {
		this.palabra = new ArrayList<Palabra>();
	}
	
	
	public void crearNuevaPalabra( String definicion, char letra, int codigo, int cantidadRespondida,
			int cantidadRespondidaCorrectament, boolean empiezaPor, String categoria, String respuesta ){
		Palabra pal = new Palabra ( definicion,  letra,  codigo,  cantidadRespondida,
				 cantidadRespondidaCorrectament,  empiezaPor,  categoria, respuesta);
			this.palabra.add(pal);
	}
	
	public void eliminarPalabra( int codigo ) {
		
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
				
				Palabra pal = new Palabra(definicion, letra, codigo, veces_usad, veces_acertad, empieza, nombre_categoria, respuesta );
				palabras.add(pal);

			}
		}

	}catch (SQLException e) {
		e.printStackTrace();
	}
		return palabras;
	}
	
	public void obtenerPalabras( String categoria ) {
		
	}


}

