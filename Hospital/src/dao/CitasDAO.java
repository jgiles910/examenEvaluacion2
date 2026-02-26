package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Citas;
import model.Paciente;
import model.Persona;

public class CitasDAO {

	private static final String ruta = "Citas.txt";
	private static final String URL = "jdbc:mysql://localhost:3306/hospital";
	private static final String USER = "root";
	private static final String PASS = "";

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASS);

		} catch (SQLException e) {
			System.err.println("Error durante la conexión a la base de datos: " + e.getMessage());
		}
		return con;
	}

//	// El método insertAllCitas() leerá las citas desde el fichero de texto
//	adjunto al enunciado de examen y las insertará en la base de datos

	public void updateCita(Citas c) throws SQLException {

		String sql = "Update citas set fecha=?, hora=? where id =?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, c.getFecha());
			ps.setInt(2, c.getHora());
			ps.setInt(3, c.getId());

			ps.executeUpdate();
		}
	}

	// delete Citas
	public void deleteCita() throws SQLException {

		String sql = "Delete from citas";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.executeUpdate();
		}
	}

	// get All citas (de la base de datos.)
	public ArrayList<Citas> getAllCitas() throws SQLException {

		ArrayList<Citas> listaCitas = new ArrayList<Citas>();

		String sql = "Select * from Citas";

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				listaCitas.add(new Citas(rs.getInt("id"), rs.getInt("paciente_id"), rs.getInt("medico_id"),
						rs.getString("fecha"), rs.getInt("hora")

				));
			}
		}
		return listaCitas;

	}

	public ArrayList<Citas> insertAllCitas() throws FileNotFoundException {
		try {
		ArrayList<Citas> listaCitas = new ArrayList<Citas>();

		File file = new File(ruta);

		Scanner scFile = new Scanner(file);

		scFile.nextLine();
		
			while (scFile.hasNext()) {

				String[] campos = scFile.nextLine().split(",");

				listaCitas.add(new Citas(

						Integer.valueOf(campos[0]), Integer.valueOf(campos[1]), campos[2], Integer.valueOf(campos[3])));
			}

			scFile.close();

			return listaCitas;

		} catch (Exception e) {
			System.err.println("Error al cargar fichero de citas");
		}
		return null;

	}

	public void addCita(Citas c) throws SQLException {

		String sql = "Insert into citas (id, paciente_id, medico_id, fecha, hora) VALUES (NULL, ?, ?, ?, ?) ";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, c.getPaciente_id());
			ps.setInt(2, c.getMedico_id());
			ps.setString(3, c.getFecha());
			ps.setInt(4, c.getHora());

			ps.executeUpdate();
		}
	}

	// get citas by id
	public ArrayList<Citas> getCitaById(int id) throws SQLException {

		ArrayList<Citas> listaCitas = new ArrayList<Citas>();

		String sql = "Select * from citas where id = ?";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(0, id);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					listaCitas.add(new Citas(rs.getInt("id"), rs.getInt("nombre"), rs.getInt("Apellido"),
							rs.getString("email"), rs.getInt("contraseña")

					));
				}
			}
			return listaCitas;
		}
	}
}