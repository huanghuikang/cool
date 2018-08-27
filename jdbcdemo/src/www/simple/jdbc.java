package www.simple;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	public static void delete(String ID) throws SQLException {
		Connection conn=null;
		Statement st=null;
		try {
			conn=DbHelper.getConnection();
			String sql="DELETE FROM `user`.`t_user` WHERE `id`="+ID;
			st=conn.createStatement();
			int result=st.executeUpdate(sql);
			if(result>0) {
				System.out.println("É¾³ý³É¹¦");
			}
			else {
				System.out.println("É¾³ýÊ§°Ü");
			}
		}
		finally {
			DbHelper.close(conn, st, null);
		}
	}
	public static void main(String[] args) throws SQLException {
		delete("17");
	}

}
