import java.io.FileNotFoundException;
import java.sql.SQLException;

import Controller.Controller;

public class HospitalAPP {

	static Controller controller = new Controller();
	
	public static void main(String[] args) throws SQLException, FileNotFoundException {
		// TODO Auto-generated method stub

		
		controller.login();

	}
}
