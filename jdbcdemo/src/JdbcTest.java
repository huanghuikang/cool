import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcTest {
	protected static String dbClassName = "com.mysql.jdbc.Driver";
	protected static String dbUrl = "jdbc:mysql://localhost:3306/user";
	protected static String dbUser = "root";
	protected static String dbPwd = "605296";
	protected static String second = null;
	protected static Connection conn = null;
	private JdbcTest() {
		try {
			if(conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
			else return;
		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JdbcTest jdbc = new JdbcTest();
		System.out.println(jdbc);

	}

}
