package www.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMysql {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1、载入JDBC驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		//2、定义连接url
		String url="jdbc:mysql://localhost:3306/user";
		//3、创建连接Connection、DriverManager
		Connection conn=DriverManager.getConnection(url, "root", "605296");
		System.out.println(conn);
		//4、创建Statement对象
		Statement st=conn.createStatement();
		//5、执行查询或更新
		String sql="select ID,name,age,birth from t_user";
		ResultSet rs=st.executeQuery(sql);
		//6、处理结果（遍历获取查询出来的所有数据）
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
