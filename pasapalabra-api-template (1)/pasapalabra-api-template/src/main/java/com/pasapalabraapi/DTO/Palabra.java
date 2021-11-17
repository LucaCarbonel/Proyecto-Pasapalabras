package com.pasapalabraapi.DTO;

public class Palabra {
	private String definicion;
	private String letra;
	private int codigo, veces_usad, veces_acertad;
	private boolean empieza;
	private String nombre_categoria, respuesta;
	
	public Palabra(String definicion, String letra, int codigo, int veces_usad, int veces_acertad, boolean empieza,
			String nombre_categoria, String respuesta) {
		super();
		this.definicion = definicion;
		this.letra = letra;
		this.codigo = codigo;
		this.veces_usad = veces_usad;
		this.veces_acertad = veces_acertad;
		this.empieza = empieza;
		this.nombre_categoria = nombre_categoria;
		this.respuesta = respuesta;
	}
	public String getDefinicion() {
		return definicion;
	}
	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getVeces_usad() {
		return veces_usad;
	}
	public void setVeces_usad(int veces_usad) {
		this.veces_usad = veces_usad;
	}
	public int getVeces_acertad() {
		return veces_acertad;
	}
	public void setVeces_acertad(int veces_acertad) {
		this.veces_acertad = veces_acertad;
	}
	public boolean isEmpieza() {
		return empieza;
	}
	public void setEmpieza(boolean empieza) {
		this.empieza = empieza;
	}
	public String getNombre_categoria() {
		return nombre_categoria;
	}
	public void setNombre_categoria(String nombre_categoria) {
		this.nombre_categoria = nombre_categoria;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

}