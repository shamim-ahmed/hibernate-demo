package edu.buet.cse.hsqldb.intro.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
  public static void close(Connection conn) {
	if (conn == null) {
	  return;
	}
	
	try {
	  conn.close();
	} catch (SQLException ex) {
	  // ignore it
	}
  }
  
  private DbUtil() {
  }
}
