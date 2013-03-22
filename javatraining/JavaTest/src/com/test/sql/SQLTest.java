package com.test.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTest {
	static Connection con;
	static Statement s;
	
/*	static{
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/
	public static Connection getConnection() throws SQLException{
		if (con == null)
	//	con = DriverManager.getConnection("jdbc:derby:derbyDB2;create=true");
		//	con = DriverManager.getConnection("jdbc:derby:derbyDB2;create=true", "user1", "user1");
			con = DriverManager.getConnection("jdbc:derby:derbyDB2");
	//	s = con.createStatement();
	
 s = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
		return con;
	}
	
	public static void insertData() throws SQLException{
		
		//s.executeUpdate("create table location (num int, address varchar(50))");
		//s.executeUpdate("insert into location values (2, 'kphb')");
		//s.execute("insert into location values (3, 'banjara hills')");
	}
	
	public static void getAndprintData() throws SQLException{
		ResultSet rs = s.executeQuery("select * from location");
		ResultSetMetaData rsm = rs.getMetaData();
		System.out.println("column count " + rsm.getColumnCount());
		System.out.println("column type 1 " + rsm.getColumnType(1));
		System.out.println("column 1 class name " + rsm.getColumnClassName(1));
		System.out.println("column type 2 " + rsm.getColumnType(2));
		System.out.println("column 2 class name " + rsm.getColumnClassName(2));
		System.out.println("Table: " + rsm.getTableName(1));
		System.out.println("---------------------------");
		for (int i = 1; i<=rsm.getColumnCount(); i++){
		System.out.println("column "+i +": "+ rsm.getColumnTypeName(i)+"("+rsm.getColumnDisplaySize(i)+") "+ rsm.getColumnName(i));
		}
		


		while (rs.next()){
			System.out.println (rs.getInt(1) + " "+ rs.getString(2));
	
/*			System.out.println (rs.getLong(1) + " "+ rs.getString(2));
			System.out.println (rs.getDouble(1) + " "+ rs.getString(2));
			System.out.println (rs.getString(1) + " "+ rs.getString(2));*/
		}
		rs.first();
		System.out.println ("scrollable "+rs.getInt(1) + " "+ rs.getString(2));
		rs.updateString(2, "manikonda");
		System.out.println(rs.rowUpdated());
	//	System.out.println ("scrollable "+rs.getInt(1) + " "+ rs.getString(2));
	//	rs.cancelRowUpdates();
	//	System.out.println ("scrollable "+rs.getInt(1) + " "+ rs.getString(2));
		rs.next();
		System.out.println (rs.getInt(1) + " "+ rs.getString(2));
	}	
	
	
	public static void shutdown() throws SQLException{
		if (con != null){
		con.close();
		//s.close();
		}
		try{
		DriverManager.getConnection("jdbc:derby:;shutdown=true", "user1", "user1");
		}
		catch (Exception e){
			
		}
	}

}
