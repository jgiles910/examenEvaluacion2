package model;

public final class Paciente extends Persona {


	
	
	public Paciente() {
		super();
	}
	public Paciente( String nombre, String apellido, String email, String contrasenya, boolean rol, String medico) {
		super(nombre, apellido, email, contrasenya, rol, medico);
		super.rol = false;
		this.medico = medico;
	}
	
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
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
