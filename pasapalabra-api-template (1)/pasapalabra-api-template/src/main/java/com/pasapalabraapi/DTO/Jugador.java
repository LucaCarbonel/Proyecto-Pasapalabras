package com.pasapalabraapi.DTO;

public class Jugador extends Usuario {

	private String nickname;

	public Jugador(String nombre, String apellido, String mail, int cI, int pin, String nickname) {
		super(nombre, apellido, mail, cI, pin);
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
