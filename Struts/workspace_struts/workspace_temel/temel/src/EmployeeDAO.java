import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
	private Connection con;

	public void create(Employee employee) {
	}

	public void delete(Employee employee) {
	}

	public List<Employee> findAll() {
		Connection connect = getConnection();
		Employee employee = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");

			while (rs.next()) {
				employee = new Employee();
				// System.out.println(rs.getString("lastname"));
				employee.setEmployeenumber(rs.getInt("employeenumber"));
				employee.setLastname(rs.getString("lastname"));
				employee.setFirstname(rs.getString("firstname"));
				employee.setExtension(rs.getString("extension"));
				employee.setEmail(rs.getString("email"));
				employee.setOfficecode(rs.getString("officecode"));
				employee.setReportsto(rs.getInt("reportsto"));
				employee.setJobtitle(rs.getString("jobtitle"));
				employees.add(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}

	public Connection getConnection() {
		if (con == null) {
			try {
				// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				// m con = DriverManager.getConnection("jdbc:odbc:deneme", "",
				// "");
				Class.forName("org.apache.derby.jdbc.ClientDriver");
				con = DriverManager.getConnection(
						"jdbc:derby://localhost:1527/myeclipse", "classiccars",
						"classiccars");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return con;
	}

}
