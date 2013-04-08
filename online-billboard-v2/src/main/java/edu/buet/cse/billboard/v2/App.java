package edu.buet.cse.billboard.v2;

import edu.buet.cse.billboard.v2.dao.UserDao;
import edu.buet.cse.billboard.v2.model.User;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

public class App {
  public static void main(String[] args) {	
	try {
	  User user = UserDao.getUser(1L);
	  System.out.println(user);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
