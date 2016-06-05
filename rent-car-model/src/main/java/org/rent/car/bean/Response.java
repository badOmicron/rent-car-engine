package org.rent.car.bean;

import java.util.Set;

import org.rent.car.help.Externaliza;

public class Response extends Externaliza {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Response() {
		// TODO Auto-generated constructor stub
	}

	private int codigo;
	private String mensaje;
	private Set<?> contenido;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Set<?> getContenido() {
		return contenido;
	}

	public void setContenido(Set<?> contenido) {
		this.contenido = contenido;
	}

}
