package edu.buet.cse.billboard;

import org.hibernate.HibernateException;

import edu.buet.cse.billboard.dao.UserDao;
import edu.buet.cse.billboard.model.User;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
	try {	  
	  // get user
	  User user = UserDao.getUser(1L); 
	  System.out.println(user);
	  
	  // update user
	  user.setName(user.getName().concat("modified"));
	  UserDao.saveUser(user);
	  System.out.println("User updated successfully");
	  
	  // create user
	  User user2 = new User();
	  user2.setName("tux");
	  user2.setPassword("secret");
	  UserDao.saveUser(user2);
	  System.out.println("New user created successfully");
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
