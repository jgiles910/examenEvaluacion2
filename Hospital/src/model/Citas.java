package model;

public class Citas {

//	Campos:
//		 id (AUTO_INCREMENT, PRIMARY KEY)
//		 paciente_id (FK)
//		 medico_id (FK)
//		 fecha (String)
//		 hora (int)
	
	private int id;
	private int paciente_id;
	private int medico_id;
	private String fecha;
	private int hora;
	
	
	

	public Citas() {
		super();
	}

	
	public Citas( int paciente_id, int medico_id, String fecha, int hora) {
		super();
	
		this.paciente_id = paciente_id;
		this.medico_id = medico_id;
		this.fecha = fecha;
		this.hora = hora;
	}

	
	public Citas(int id, int paciente_id, int medico_id, String fecha, int hora) {
		super();
		this.id = id;
		this.paciente_id = paciente_id;
		this.medico_id = medico_id;
		this.fecha = fecha;
		this.hora = hora;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPaciente_id() {
		return paciente_id;
	}
	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}
	public int getMedico_id() {
		return medico_id;
	}
	public void setMedico_id(int medico_id) {
		this.medico_id = medico_id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Citas = idCita:" + id + "*"
				+ "IdPaciente:" + paciente_id + "*"
				+ "IdMedico:" + medico_id + "*"
				+ "Fecha:" + fecha + "*"
				+ "Hora:" + hora;
	}
	
	
	
}
