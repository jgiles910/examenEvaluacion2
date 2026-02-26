package Controller;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.CitasDAO;
import dao.PacienteDAO;
import model.Citas;
import model.Persona;

public class Controller {

	Scanner sc = new Scanner(System.in);
	/*
	 * Una única clase Controller: o login(String nombre, String contraseña) o
	 * Funciones del menú de Paciente:  verCitasPaciente(int pacienteId) o
	 * 
	 * Funciones del menú de Médico:  anyadirPaciente(…)  anyadirCita(…)  
	 * modificarCitaMedico(…)  eliminarAllCitas()
	 * 
	 * 
	 * 
	 *  Penalizaciones posibles: o Elmétodo login no existe o no funciona: −0,5. o
	 * Falta la función del menú de paciente o no funciona: −0,5. o Falta una
	 * función del menú de médico o no funciona: −0,5 cada una
	 */

	CitasDAO daoCita;
	PacienteDAO daoPaciente;

	public Controller() {
		daoPaciente = new PacienteDAO();
		daoCita = new CitasDAO();
	}

	public void menuPaciente() {

		System.out.println("1. Ver citas pacientes");
		System.out.println("2. Salir");

	}

	public void menuMedico() {

		System.out.println("1. Añadir nuevo paciente");
		System.out.println("2. Añadir cita");
		System.out.println("3. Modificar cita");
		System.out.println("4. Eliminar todas las citas");

	}

	public void login() throws SQLException, FileNotFoundException {

		System.out.println("Introduce tu Nombre ");
		String nombre = sc.nextLine();

		System.out.println("Introduce tu Contraseña ");
		String contrasenya = sc.nextLine();

		ArrayList<Persona> listaList = daoPaciente.getAllUsuarios();

		for (int i = 0; i < listaList.size(); i++) {

			if (listaList.get(i).getNombre().equalsIgnoreCase(nombre)
					&& listaList.get(i).getContrasenya().equalsIgnoreCase(contrasenya)) {
				System.out.println("Ese usuario que has introducido existe.");

				ArrayList<Citas> citasCargadas = daoCita.insertAllCitas();
				System.out.println(citasCargadas.toString()); 
				
				for (int j = 0; j < listaList.size(); j++) {

					if (listaList.get(j).isRol() == false) {
						System.out.println("paciente.");
						menuPaciente();
					} else {
						System.out.println("medico.");
						menuMedico();
					}
				}
			}
		}
	}
}
