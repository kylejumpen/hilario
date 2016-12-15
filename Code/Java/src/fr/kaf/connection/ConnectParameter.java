package fr.kaf.connection;

import java.sql.DriverManager;
import java.sql.*;

public class ConnectParameter {

	/**
	  * Connection URL
	  */
	  private static String url = "jdbc:mysql://localhost:3306/hilario";

	  /**
	  * Username's Database
	  */
	  private static String user = "user";

	  /**
	  * Password
	  */
	  private static String passwd = "passwd";

	  /**
	  * Connection object
	  */
	  private static Connection connect;

	  
	  public static Connection getInstance(){
	    if(connect == null){
	      try {
	    	Class.forName("com.mysql.jdbc.Driver");
	        return connect = (Connection) DriverManager.getConnection(url, user, passwd);
	      } catch (Exception e) {
	        e.printStackTrace();
	        System.exit(1);
	      }
	    }		
	    return connect;	
	  }
	
}
