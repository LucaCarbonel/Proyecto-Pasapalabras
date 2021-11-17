package com.pasapalabraapi.DTO;
import java.sql.*;

import java.util.ArrayList;

public class ManejadorPartidas {
	
	private ArrayList<Jugador> jugador;
	private ArrayList<Palabra> palabra;
	private ArrayList<Partida> partida;
	
	public ManejadorPartidas() {
		this.jugador = new ArrayList<Jugador>();
	}
	
	public static ArrayList nuevaPartida( String nickname, String pin ) {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		ArrayList confirmacion = new ArrayList();
		try {
			Statement stmt = con.createStatement();
			String query = "select Jugador.nickname, Usuario.pin from Jugador join Usuario on Jugador.CI = Usuario.CI where nickname = \"" + nickname + "\" and pin = \"" + pin + "\"; ";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int pass = rs.getInt(1);
				String nick = rs.getString(2);
				confirmacion.add(pass, nick);
				//Solo se devuelve cuando hay alguna coincidencia y el front tira un error si en el response no encuentra coincidencias con lo ingresado
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return confirmacion;
	}

	public void finalizarPartida( int puntuacion, String nickname ) {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		try {
			Statement stmt = con.createStatement();
			String query = "INSERT into Partida(ID, puntaje, nickname) values(null, \"" + puntuacion + "\", \"" + nickname + "\");";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Partida> obtenerTop10PartidasGanadas() {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		try {
		Statement stmt = con.createStatement();
		String query = "select * from Palabra order by veces_usad - veces_acertad desc limit 10;";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			int codigo = rs.getInt(1);
			int puntaje = rs.getInt(2);
			String nickname = rs.getString(3);
			
			Partida par = new Partida(codigo, puntaje, nickname);
			partidas.add(par);
		}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return partidas;
	}
	
	public static ArrayList<Partida> obtenerTop10PartidasPerdidas() {

		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		try {
		Statement stmt = con.createStatement();
		String query = "select * from Palabra order by veces_usad - veces_acertad asc limit 10;";
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			int codigo = rs.getInt(1);
			int puntaje = rs.getInt(2);
			String nickname = rs.getString(3);
			
			Partida par = new Partida(codigo, puntaje, nickname);
			partidas.add(par);
		}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return partidas;
}
	
	public static ArrayList<Palabra> obtenerTop10PalabrasMasDificiles() {
		DBConf dbconf = new DBConf();
		Connection con = dbconf.conectarMySQL();
		
		ArrayList<Palabra> palabras = new ArrayList<Palabra>();
		try {
		Statement stmt = con.createStatement();
		String query = "select * from Palabra order by veces_usad - veces_acertad desc limit 10;";
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

}catch (SQLException e) {
	e.printStackTrace();
}
		return palabras;
	}
}
