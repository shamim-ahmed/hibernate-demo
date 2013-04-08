package edu.buet.cse.billboard;

import org.hibernate.HibernateException;

import edu.buet.cse.billboard.dao.UserDao;
import edu.buet.cse.billboard.model.User;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
	try {	  
	  User user = UserDao.getUser(1L); 
	  System.out.println(user);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
