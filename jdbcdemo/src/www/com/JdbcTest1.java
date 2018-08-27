package www.com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class JdbcTest1 {
	public static void update(String ID,String name,String age) throws ClassNotFoundException, SQLException {
		Connection conn=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/user";
			conn=DriverManager.getConnection(url, "root", "605296");
			st=conn.createStatement();
			String sql="UPDATE `user`.`t_user` SET `ID`='4', `name`='�¶�' WHERE `id`='4'";
			int result = st.executeUpdate(sql);
			if(result>0) {
				System.out.println("���³ɹ�");
			}
			else {
				System.out.println("����ʧ��");
			}
		}
		finally {
			if(st != null) {
				try {
					st.close();
				}
				finally {
					if(conn!=null) {
						conn.close();
					}
				}
			}
		}
	}
	public static void delete(String ID) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user";
		Connection conn=DriverManager.getConnection(url, "root", "605296");
		Statement st=conn.createStatement();
		String sql="DELETE FROM `user`.`t_user` WHERE `id`=" +ID;
		int result=st.executeUpdate(sql);
		if(result>0) {
			System.out.println("ɾ���ɹ�");
		}
		else {
			System.out.println("ɾ��ʧ��");
		}
		st.close();
		conn.close();
	}
	public static void adduser(String ID,String name,String age,String birth) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user";
		Connection conn=DriverManager.getConnection(url, "root", "605296");
		Statement st=conn.createStatement();
		//String sql="INSERT INTO `user`.`t_user` (`ID`, `name`, `age`, `birth`) VALUES ('15', 'ww', '44', '1998-04-14')";
		String sql="INSERT INTO `user`.`t_user` (`ID`,`name`, `age`, `birth`) VALUES ('"+ID+"','"+name+"', '"+age+"', '"+birth+"')";
		int result=st.executeUpdate(sql);
		System.out.println("result row:"+result);
		
		st.close();
		conn.close();
	}
	public static void lookmysql() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/user";
		Connection conn=DriverManager.getConnection(url, "root", "605296");
		Statement st=conn.createStatement();
		String sql="select * from t_user";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			String ID =rs.getString("ID");
			String name=rs.getString("name");
			int age=rs.getInt("age");
			Date birth=rs.getDate("birth");
			Time tim=rs.getTime("birth");
			Timestamp ts=rs.getTimestamp("birth");
			//��ʽ��ʱ��
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
			String birth1=sdf.format(ts);
			System.out.println(ID +":"+name+":"+age+":"+birth+":"+tim+":"+ts+":"+birth1);
		}
		rs.close();
		st.close();
		conn.close();
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//update("15", "ww", "44");
		//delete("9");
		//adduser("2","hhk", "222", "1999-05-22");
		lookmysql();
	}

}
