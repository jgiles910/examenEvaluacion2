import java.io.FileNotFoundException;
import java.sql.SQLException;

import Controller.Controller;

public class HospitalAPP {

	static Controller controller = new Controller();
	
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub

		
		controller.login();
		
		
//		Una única clase: HospitalAPP
//		o Recoge los datos de login (nombre + contraseña).
//		o Envía los datos al Controller.
//		o Una vez el log in es correcto se leerán las citas desde el fichero
//		de texto adjunto al enunciado de examen y se insertarán en la
//		base de datos.
//		o Según el rol recibido, muestra el menú correspondiente (Menú
//		Paciente o Menú Médico):
//		 Menú Pacientes:
//		o Ver citas
//		o Salir ***
//		 Menú Médicos:
//		o Añadir nuevo paciente
//		o Añadir cita
//		o Modificar cita
//		o Salir ***
		
		
	}
}
