package cn.itcast.b_pool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * 自定义连接池，管理连接
 * 代码实现
 * 1、MyPool.java连接池类
 * 2、指定全局参数，初始化数目、最大连接数、当前连接、连接池集合
 * 3、构造函数：循环创建3个连接
 * 4、写一个创建连接的方法
 * 5、获取连接
 *     判断：池中有无连接，有直接拿
 *     		没有，判断：是否达到最大连接数;
 *     			达到：抛出异常；
 *     			没有达到：创建新的连接
 *6、释放连接：连接施加集合中（、、、）
 *
 * */
public class MyPool {
	/**
	 * 初始化连接数目
	 * 最大连接数
	 * 记录使用连接数
	 * 连接池（存放所有的初始化连接）
	 */
	private int init_count=3;
	private int max_count=6;
	private int current_count=0;
	private LinkedList<Connection> pool=new LinkedList<Connection>();
	
	//1、构造函数中，初始化连接放入连接池
	/**初始化连接
	 * 记录当前连接数目
	 * 创建原始的连接对象
	 * 把连接加入连接池
	 * @param args
	 */
	public MyPool() {
		for(int i=0;i<init_count;i++) {
			current_count++;
			Connection conn=createConnection();
			pool.addLast(conn);
		}
	}

	//2、创建一个新的连接的方法
	/**
	 * 原始的目标对象
	 * 
	 * */
	
	private Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//原始的目标对象
			final Connection conn=DriverManager.getConnection("jdbc:mysql://jdbc_demo","root","605296");
			/*************对conn对象代理*************/
			//对conn创建其代理对象
			Connection proxy=(Connection) Proxy.newProxyInstance(
					conn.getClass().getClassLoader(),//类加载器
					//conn.getClass().getInterfaces(),//当目标对象是一个具体的类的时候
					new Class[]{Connection.class},//目标对象实现的接口
					new InvocationHandler() {	//当调用conn对象方法的时候，自动触发事务处理器
						
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							//方法返回值
							Object result=null;
							//当前执行的方法的方法名
							String methodName=method.getName();
							//判断当执行了close方法的时候，把连接放入连接池
							if("close".equals(methodName)) {
								System.out.println("begin:当前执行close方法开始");
								//连接放入连接池（判断..）
								pool.addLast(conn);
								System.out.println("end:当前连接已经放入连接池！");
							}
							else {
								//调用目标对象方法
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
	//3、获取连接
	/**
	 * 3.1判断连接池中是否有连接，如果有连接，就直接从连接池取出
	 * 3.2连接池中没有连接，判断，如果没有达到最大连接数，创建：创建记录当前使用的连接数，创建连接
	 * 3.3如果当前已经达到最大连接数，抛出异常
	 * */
	public Connection getConnection() {
		if(pool.size() > 0) {
			return pool.removeFirst();
		}
		if(current_count<max_count) {
			current_count++;
			return createConnection();
		}
		throw new RuntimeException("当前连接已经达到最大连接数目！");
	}
	//4.释放连接
	/**
	 * 判断：连接池的数目如果小于初始化连接，就放入池中
	 * 关闭
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
		System.out.println("当前连接："+pool.current_count);
		//使用连接
		pool.getConnection();
		pool.getConnection();
		Connection con4=pool.getConnection();
		Connection con3=pool.getConnection();
		Connection con2=pool.getConnection();
		Connection con1=pool.getConnection();
		
		//连接，连接施加连接池
		//pool.realeaseConnection(con1);
		/**
		 * 当关闭连接的时候，要把连接放入连接池
		 * 把连接放入连接池
		 * 1、实现Connection接口，重写close方法
		 * 2、动态代理
		 * */
		con1.close();
		//再获取
		System.out.println("连接池："+pool.pool.size());	//0
		System.out.println("当前力拼："+pool.current_count);//3
	}

}
