package www.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		//ͨ����ѯ���е��������ݽ���jdbc�Ľ���
		//1.����jdbc����
		
			Class.forName("com.mysql.jdbc.Driver");
		
		//2.��������Url
		String Url = "jdbc:mysql://localhost:3306/user";
		//��ȡ���ݿ�����
		Connection conn = DriverManager.getConnection(Url, "root", "605296");
		System.out.println(conn);
		
	}

}
