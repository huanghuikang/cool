package www.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMysql {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1������JDBC��������
		Class.forName("com.mysql.jdbc.Driver");
		//2����������url
		String url="jdbc:mysql://localhost:3306/user";
		//3����������Connection��DriverManager
		Connection conn=DriverManager.getConnection(url, "root", "605296");
		System.out.println(conn);
		//4������Statement����
		Statement st=conn.createStatement();
		//5��ִ�в�ѯ�����
		String sql="select ID,name,age,birth from t_user";
		ResultSet rs=st.executeQuery(sql);
		//6����������������ȡ��ѯ�������������ݣ�
		while(rs.next()) {
			String ID = rs.getString("ID");
			String name = rs.getString("name");
			String age = rs.getString("age");
			String birth = rs.getString("birth");
			System.out.println(ID+":"+name+":"+age+":"+birth);
		}
		rs.close();
		st.close();
		conn.close();
	}

}
