package edu.buet.cse.billboard;

import edu.buet.cse.billboard.dao.UserDao;
import edu.buet.cse.billboard.model.User;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
	try {	  
	  UserDao dao = new UserDao();
	  
	  // get user
	  User user1 = dao.getUser(1L); 
	  System.out.println(user1);
	  
	  // update user
	  user1.setName(user1.getName().concat("modified"));
	  boolean updated = dao.saveUser(user1);
	  System.out.printf("User %s%n", updated ? "updated" : "not updated");
	  
	  // create user
	  User user2 = new User();
	  user2.setName("tux");
	  user2.setPassword("secret");
	  boolean created = dao.saveUser(user2);
	  System.out.printf("New user %s%n", created ? "created" : "not created");
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
