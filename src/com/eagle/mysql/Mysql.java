package com.eagle.mysql;
 
import java.sql.*; 
import org.apache.log4j.Logger;

public class Mysql {
	private Logger log= Logger.getLogger(this.getClass().getName());
	//默认数据库连接信息
	private String host="172.18.3.96";
	private String port="3306";
	private String user="dbimporter";
	private String password="!@#$QWER";
	private String database="mysql";
	
	public Mysql()
	{
		
	}
	public Mysql(String host,String user,String password)
	{
		this.host=host;
		this.user=user;
		this.password=password;
		
	}
	public Mysql(String host,String port,String user,String password)
	{
		this.host=host;
		this.port=port;
		this.user=user;
		this.password=password;
		
	}
	public void getData(String strsql)
	{
		String url ="jdbc:mysql://"+host+":"+port+"/"+ database  ;    //jdbc:mysql://host_name:port/dbname 注意首尾空格
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			Connection conn = DriverManager.getConnection(url,user,password);
			//创建声明
			Statement stmt = conn.createStatement();
			//执行SQL语句，获得结果集
			ResultSet rs = stmt.executeQuery(strsql);
			//获取元数据
			ResultSetMetaData rsmd=rs.getMetaData();
			StringBuffer sb= new StringBuffer();
			//输出列名
			for(int i=1;i<=rsmd.getColumnCount();i++)
			{
				sb.append(rsmd.getColumnName(i)+"\t"); 
			} 
			log.info(sb);
			//逐行输出数据
			while (rs.next())
			{   
				sb.delete(0,sb.length()-1);
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					sb.append(rs.getString(i)+"\t");
				}
				log.info(sb);
			} 
			//关闭
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
//			e.printStackTrace();
			log.error("ERROR:Connect DataBase Failed!");
		}
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}

}
