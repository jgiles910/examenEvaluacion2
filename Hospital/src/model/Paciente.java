package model;

public final class Paciente extends Persona {

	private String medico;
	
	
	public Paciente() {
		super();
	}
	public Paciente(int id_usuario, String nombre, String apellido, String email, String contrasenya, boolean rol, String medico) {
		super(id_usuario, nombre, apellido, email, contrasenya, rol);
		super.rol = false;
		this.medico = null;
	}
	
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public Paciente(int id_usuario, String nombre, String apellido, String email, String contrasenya, boolean rol) {
		super(id_usuario, nombre, apellido, email, contrasenya, rol);
		
	}

	@Override
	public String toString() {
//		Persona = nombre del atributo: valor del atributo *
//				nombre del atributo: valor del atributo * …
		
		return "Paciente = id_usuario:" + getId_usuario() + "*"
		+ "Nombre:" + getNombre() + "*"
		+ "Apellido:" + getApellido() + "*"
		+ "Email:" + email + "*"
		+ "Contrasenya:" + getContrasenya() + "*"
		+ "Rol:" + isRol()
		+ "Medico:" + getMedico() ;
	}
	

	
}
