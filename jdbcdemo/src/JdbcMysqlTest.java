import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcMysqlTest {
	//1.����jdbc����
			protected static String dbClassName = "com.mysql.jdbc.Driver";
			//2.��������Url
			protected static String dbUrl = "jdbc:mysql://localhost:3306/user";
			protected static String dbUser = "root";
			protected static String dbPwd = "605296";
			protected static String second = null;
			protected static Connection conn = null;
			private JdbcMysqlTest() {
				try {
					if(conn == null) {
						Class.forName(dbClassName).newInstance();
						conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
					}
					else
						return;
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			public static void main(String[] args) {
				JdbcMysqlTest JMTest = new JdbcMysqlTest();
				System.out.println(JMTest);
			}
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//ͨ����ѯ���е��������ݽ���jdbc�Ľ���
		//1.����jdbc����
		Class.forName("com.mysql.jdbc.Driver");
		//2.��������Url
		String Url = "jdbc:mysql://localhost:3306/user";
		//��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection(Url, "root", "605296");
		System.out.println(conn);

	}*/

}
