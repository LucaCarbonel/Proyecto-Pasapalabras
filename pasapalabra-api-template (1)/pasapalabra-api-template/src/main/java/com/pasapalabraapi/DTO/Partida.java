package com.pasapalabraapi.DTO;

public class Partida {

	private int codigo, puntaje;
	private String nickname;
	public Partida(int codigo, int puntaje, String nickname) {
		super();
		this.codigo = codigo;
		this.puntaje = puntaje;
		this.nickname = nickname;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}