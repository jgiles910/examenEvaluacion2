package model;

public class Medico extends Persona {

	public Medico() {
		super();
	}
	
	public Medico(int id_usuario, String nombre, String apellido, String email, String contrasenya, boolean rol) {
		super(id_usuario, nombre, apellido, email, contrasenya, rol);
		
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
