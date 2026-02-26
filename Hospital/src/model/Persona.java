package model;

public class Persona {

//	usuarios: para almacenar médicos y pacientes.
//	
//	 id (AUTO_INCREMENT, PRIMARY KEY)
//	 nombre
//	 apellido
//	 email
//	 contraseña
	
//	 rol (0 = paciente, 1 = médico)
//	 medico (nombre y apellido del médico
//	concatenados y separados por un espacio, solo
//	estará informado en el caso de los pacientes; en
//	caso contrario null)
	
	protected int id_usuario;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String contrasenya;
	protected boolean rol;
	protected String medico;
	
	
	
	public Persona() {
		super();
	}

	public Persona( String nombre, String apellido,String email, String contrasenya, boolean rol, String medico) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenya = contrasenya;
		this.rol = rol;
		this.medico = medico;
	}
	public Persona(int id_usuario, String nombre, String apellido,String email, String contrasenya, boolean rol,  String medico) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenya = contrasenya;
		this.rol = rol;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public boolean isRol() {
		return rol;
	}

	public void setRol(boolean rol) {
		this.rol = rol;
	}
//	Persona = nombre del atributo: valor del atributo *
//			nombre del atributo: valor del atributo * …
	@Override
	public String toString() {
		return "Persona = id_usuario:" + id_usuario + "*"
				+ "Nombre:" + nombre + "*"
				+ "Apellido:" + apellido + "*"
				+ "Email:" + email + "*"
				+ "Contraseña:" + contrasenya + "*"
				+ "Rol:" + rol;
	}
	
	
}
