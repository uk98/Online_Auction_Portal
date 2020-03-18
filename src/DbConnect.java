import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnect {
	public static Connection dbConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/auction","root","welcome");
		return conn;
	}
}