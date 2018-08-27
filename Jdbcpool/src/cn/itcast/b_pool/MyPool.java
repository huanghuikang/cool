package cn.itcast.b_pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * �Զ������ӳأ���������
 * ����ʵ��
 * 1��MyPool.java���ӳ���
 * 2��ָ��ȫ�ֲ�������ʼ����Ŀ���������������ǰ���ӡ����ӳؼ���
 * 3�����캯����ѭ������3������
 * 4��дһ���������ӵķ���
 * 5����ȡ����
 *     �жϣ������������ӣ���ֱ����
 *     		û�У��жϣ��Ƿ�ﵽ���������;
 *     			�ﵽ���׳��쳣��
 *     			û�дﵽ�������µ�����
 *6���ͷ����ӣ�����ʩ�Ӽ����У���������
 *
 * */
public class MyPool {
	/**
	 * ��ʼ��������Ŀ
	 * ���������
	 * ��¼ʹ��������
	 * ���ӳأ�������еĳ�ʼ�����ӣ�
	 */
	private int init_count=3;
	private int max_count=6;
	private int current_count=0;
	private LinkedList<Connection> pool=new LinkedList<Connection>();
	
	//1�����캯���У���ʼ�����ӷ������ӳ�
	/**��ʼ������
	 * ��¼��ǰ������Ŀ
	 * ����ԭʼ�����Ӷ���
	 * �����Ӽ������ӳ�
	 * @param args
	 */
	public MyPool() {
		for(int i=0;i<init_count;i++) {
			current_count++;
			Connection conn=createConnection();
			pool.addLast(conn);
		}
	}

	//2������һ���µ����ӵķ���
	/**
	 * ԭʼ��Ŀ�����
	 * 
	 * */
	
	private Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//ԭʼ��Ŀ�����
			final Connection conn=DriverManager.getConnection("jdbc:mysql://jdbc_demo","root","605296");
			/*************��conn�������*************/
			//��conn������������
			Connection proxy=(Connection) Proxy.newProxyInstance(
					conn.getClass().getClassLoader(),//�������
					//conn.getClass().getInterfaces(),//��Ŀ�������һ����������ʱ��
					new Class[]{Connection.class},//Ŀ�����ʵ�ֵĽӿ�
					new InvocationHandler() {	//������conn���󷽷���ʱ���Զ�������������
						
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							//��������ֵ
							Object result=null;
							//��ǰִ�еķ����ķ�����
							String methodName=method.getName();
							//�жϵ�ִ����close������ʱ�򣬰����ӷ������ӳ�
							if("close".equals(methodName)) {
								System.out.println("begin:��ǰִ��close������ʼ");
								//���ӷ������ӳأ��ж�..��
								pool.addLast(conn);
								System.out.println("end:��ǰ�����Ѿ��������ӳأ�");
							}
							else {
								//����Ŀ����󷽷�
								result=method.invoke(conn, args);
							}
							return result;
						}
					}
				);
				return proxy;
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
	}
	//3����ȡ����
	/**
	 * 3.1�ж����ӳ����Ƿ������ӣ���������ӣ���ֱ�Ӵ����ӳ�ȡ��
	 * 3.2���ӳ���û�����ӣ��жϣ����û�дﵽ�����������������������¼��ǰʹ�õ�����������������
	 * 3.3�����ǰ�Ѿ��ﵽ������������׳��쳣
	 * */
	public Connection getConnection() {
		if(pool.size() > 0) {
			return pool.removeFirst();
		}
		if(current_count<max_count) {
			current_count++;
			return createConnection();
		}
		throw new RuntimeException("��ǰ�����Ѿ��ﵽ���������Ŀ��");
	}
	//4.�ͷ�����
	/**
	 * �жϣ����ӳص���Ŀ���С�ڳ�ʼ�����ӣ��ͷ������
	 * �ر�
	 * */
	public void realeaseConnection(Connection conn) {
		if(pool.size()<init_count) {
			pool.addLast(conn);
		}
		else {
			try {
				current_count--;
				conn.close();
			}
			catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		MyPool pool=new MyPool();
		System.out.println("��ǰ���ӣ�"+pool.current_count);
		//ʹ������
		pool.getConnection();
		pool.getConnection();
		Connection con4=pool.getConnection();
		Connection con3=pool.getConnection();
		Connection con2=pool.getConnection();
		Connection con1=pool.getConnection();
		
		//���ӣ�����ʩ�����ӳ�
		//pool.realeaseConnection(con1);
		/**
		 * ���ر����ӵ�ʱ��Ҫ�����ӷ������ӳ�
		 * �����ӷ������ӳ�
		 * 1��ʵ��Connection�ӿڣ���дclose����
		 * 2����̬����
		 * */
		con1.close();
		//�ٻ�ȡ
		System.out.println("���ӳأ�"+pool.pool.size());	//0
		System.out.println("��ǰ��ƴ��"+pool.current_count);//3
	}

}
