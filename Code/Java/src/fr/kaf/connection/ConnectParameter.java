package fr.kaf.connection;

import java.sql.DriverManager;
import java.sql.*;

public class ConnectParameter {

	/**
	  * Connection URL
	  */
	  private static String url = "exemple";

	  /**
	  * Username's Database
	  */
	  private static String user = "exemple";

	  /**
	  * Password
	  */
	  private static String passwd = "exemple";

	  /**
	  * COnnection object
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
