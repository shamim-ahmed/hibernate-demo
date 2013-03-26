package edu.buet.cse.hsqldb.intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.buet.cse.hsqldb.intro.util.DbUtil;

public class App {
  public static void main(String[] args) {
	Connection conn = null;
	
	try {
	  conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/sampledb");
	  System.out.println(conn);
	} catch (SQLException ex) {
	  ex.printStackTrace(System.err);
	} finally {
	  DbUtil.close(conn);
	}
  }
}
