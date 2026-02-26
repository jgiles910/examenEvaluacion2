package Controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.CitasDAO;
import dao.PacienteDAO;
import model.Citas;
import model.Paciente;
import model.Persona;

public class Controller {
	static int input = 0;
	static ArrayList<Citas> citasBaseDeDatos;
	static ArrayList<Citas> citasCargadas;
	Scanner sc = new Scanner(System.in);

	CitasDAO daoCita;
	PacienteDAO daoPaciente;

	public Controller() {
		daoPaciente = new PacienteDAO();
		daoCita = new CitasDAO();
	}

	public void menuPaciente(ArrayList<Persona> listaList, int j) throws SQLException {
		System.out.println("Bienvenido/a: " + listaList.get(j).getNombre() + " " + listaList.get(j).getApellido());

		do {
			System.out.println("1. Ver citas pacientes");
			System.out.println("2. Salir");
			input = Integer.parseInt(sc.nextLine());

			switch (input) {
			case 1:
				verCitas(listaList, j);
				break;
			default:
				if (input > 2 || input <= 0) {
					System.out.println("Error");
				} else {
					System.out.println("Has salido del programa");
					daoCita.deleteCita();
				}
				break;
			}
		} while (input != 2);
	}

	private void verCitas(ArrayList<Persona> listaList, int j) throws SQLException {
		citasBaseDeDatos = daoCita.getAllCitas();
		for (int i = 0; i < citasBaseDeDatos.size(); i++) {
			
			if ( citasBaseDeDatos.get(i).getPaciente_id() == listaList.get(j).getId_usuario()  ) {
				
					System.out.println(citasBaseDeDatos.get(i).toString());
			}
		}
	}

	public void menuMedico(ArrayList<Persona> listaList, int i) throws SQLException {

		System.out.println("Bienvenido/a: " + listaList.get(i).getNombre() + " " + listaList.get(i).getApellido());

		do {
			System.out.println("1. Añadir nuevo paciente");
			System.out.println("2. Añadir cita");
			System.out.println("3. Modificar cita");
			System.out.println("4. Salir");
			input = Integer.parseInt(sc.nextLine());

			switch (input) {
			case 1:
				anyadirPaciente(listaList, i);
				break;
			case 2:
				anyadirCita(listaList, i);
				break;
			case 3:
				modificarCitas(i);
				break;
			default:
				if (input > 4 || input <= 0) {
					System.out.println("Error");
				} else {
					System.out.println("Has salido del programa");
					daoCita.deleteCita();
				}
				break;
			}
		} while (input != 4);

	}

	private void modificarCitas(int idMedico) throws SQLException {
		citasBaseDeDatos = daoCita.getAllCitas();
		System.out.println(citasBaseDeDatos.toString());
		System.out.println("Id de la cita a buscar");
		int idBuscado = Integer.parseInt(sc.nextLine());
		boolean encontrado = false;
		for (int j = 0; j < citasBaseDeDatos.size(); j++) {

			if (citasBaseDeDatos.get(j).getId() == idBuscado) {
				encontrado = true;
				System.out.println("ID localizada \n");

				System.out.println("Nueva fecha");
				String nuevaFecha = sc.nextLine();
				System.out.println("Nueva hora");
				int nuevaHora = Integer.parseInt(sc.nextLine());

				Citas citaNueva = new Citas(idBuscado, citasBaseDeDatos.get(j).getPaciente_id(), idMedico, nuevaFecha,
						nuevaHora);

				daoCita.updateCita(citaNueva);
			}
		}
		if (!encontrado) {
			System.out.println("Asegurate de que la Id que buscas existe.");
		}
		
		
	}

	private void anyadirCita(ArrayList<Persona> listaList, int i) throws SQLException {

		System.out.println("Id de paciente");
		int idPaciente = Integer.parseInt(sc.nextLine());
		System.out.println("Fecha de la cita: ");
		String fecha = sc.nextLine();
		System.out.println("Hora de la cita: ");
		int hora = Integer.parseInt(sc.nextLine());
		Citas c = new Citas(idPaciente, listaList.get(i).getId_usuario(), fecha, hora);

		daoCita.addCita(c);

	}

	private void anyadirPaciente(ArrayList<Persona> listaList, int i) throws SQLException {
		System.out.println("Nombre de paciente");
		String paciente = sc.nextLine();
		System.out.println("Apellido de paciente");
		String apellido = sc.nextLine();
		System.out.println("Email de paciente");
		String email = sc.nextLine();
		System.out.println("Contraseña de paciente");
		String contrasenya = sc.nextLine();

		Paciente p = new Paciente(paciente, apellido, email, contrasenya, false,
				listaList.get(i).getNombre() + " " + listaList.get(i).getApellido());

		daoPaciente.addPaciente(p);
		
	}

	public void login() throws SQLException, FileNotFoundException {

		System.out.println("Introduce tu Nombre ");
		String nombre = sc.nextLine();

		System.out.println("Introduce tu Contraseña ");
		String contrasenya = sc.nextLine();

		ArrayList<Persona> listaList = daoPaciente.getAllUsuarios();

		boolean loginCorrecto = false;

		
		for (int i = 0; i < listaList.size(); i++) {

			if (listaList.get(i).getNombre().equalsIgnoreCase(nombre)
					&& listaList.get(i).getContrasenya().equalsIgnoreCase(contrasenya)) {
				loginCorrecto = true;
				System.out.println("Login correcto.");

					if (listaList.get(i).isRol()) {

						System.out.println("\nEres medico.");
						carga(loginCorrecto);
						System.out.println("Fichero de citas cargado OK.");
						menuMedico(listaList, i);
						break;
						
					} else if (!listaList.get(i).isRol() ){

						System.out.println("\nEres paciente.");
						carga(loginCorrecto);
						System.out.println("Fichero de citas cargado OK.");
						menuPaciente(listaList, i);
						break;
					} 
				} 
					
				
			}	if(!loginCorrecto) {
				System.out.println("Login incorrecto. Paciente o médico no encontrado.");
			}
			
		} 

	public void carga(boolean loginCorrecto) throws SQLException, FileNotFoundException {
		
		if (loginCorrecto == true) {
			citasCargadas = daoCita.insertAllCitas();
			citasCargadas.toString();

			for (int i = 0; i < citasCargadas.size(); i++) {

				daoCita.addCita(citasCargadas.get(i));

			}
		} 
	}
}
