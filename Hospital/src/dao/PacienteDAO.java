package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Citas;
import model.Paciente;
import model.Persona;

public class PacienteDAO {
   
	private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error durante la conexión a la base de datos: " + e.getMessage());
        }
        return con;
    }
    
    
    public  ArrayList<Persona> getAllUsuarios () throws SQLException{
    	
    	ArrayList<Persona> listaUsuarios = new ArrayList<Persona>();
    	
    	String sql = "Select * from usuarios";
    	
    	try(Connection con = getConnection();
    		PreparedStatement ps = con.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery() ) {
	    		while(rs.next()) {
	    			
	    			listaUsuarios.add(new Persona(
	    					
	    					rs.getInt("id"),
	    					rs.getString("nombre"),
	    					rs.getString("Apellido"),
	    					rs.getString("email"),
	    					rs.getString("contrasena"),
	    					rs.getBoolean("rol"),
	    					rs.getString("Medico")
	    					
	    					));
    		}
    	}
		return listaUsuarios;
    	
    }
    
    public void addPaciente(Paciente p) throws SQLException {

		ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();

		String sql = "INSERT INTO `usuarios`(`id`, `nombre`, `apellido`, `email`, `contrasena`, `rol`, `medico`) VALUES (?,?,?,?,?,?,?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(0, p.getId_usuario());
			ps.setString(1, p.getNombre());
			ps.setString(2, p.getApellido());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getContrasenya());
			ps.setBoolean(5, p.isRol());
			ps.setString(6, p.getMedico());

			ps.executeUpdate();
		}
	}
}

