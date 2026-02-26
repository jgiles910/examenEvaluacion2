package model;

public class Medico extends Persona {

	public Medico() {
		super();
	}

	@Override
	public String toString() {
//		Persona = nombre del atributo: valor del atributo *
//				nombre del atributo: valor del atributo * …
		
		return "Medico = id_usuario:" + getId_usuario() + "*"
		+ "Nombre:" + getNombre() + "*"
		+ "Apellido:" + getApellido() + "*"
		+ "Email:" + email + "*"
		+ "Contraseña:" + getContrasenya() + "*"
		+ "Rol:" + isRol();
	}

	
}
