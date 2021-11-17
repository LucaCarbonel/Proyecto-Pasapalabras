package com.pasapalabraapi.DTO;

public class Usuario {

	private String nombre, apellido, mail;
	private int CI, pin;
	public Usuario(String nombre, String apellido, String mail, int cI, int pin) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		CI = cI;
		this.pin = pin;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getCI() {
		return CI;
	}
	public void setCI(int cI) {
		CI = cI;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
}
