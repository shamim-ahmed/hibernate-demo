package edu.buet.cse.billboard;

import edu.buet.cse.billboard.dao.PhoneDao;
import edu.buet.cse.billboard.dao.UserDao;
import edu.buet.cse.billboard.model.Phone;
import edu.buet.cse.billboard.model.User;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App2 {
  public static void main(String[] args) {	
	try {
	  PhoneDao phoneDao = new PhoneDao();
	  UserDao userDao = new UserDao();
	  
	  // get phone
	  Phone phone1 = phoneDao.getPhone(1L);	  
	  System.out.println(phone1);
	  
	  // update phone
	  phone1.setNumber("11111111");
	  boolean updated = phoneDao.savePhone(phone1);
	  System.out.printf("Phone %s%n", updated ? "updated" : "not updated");
	  
	  // create new phone
	  Phone phone2 = new Phone();
	  phone2.setNumber("12345678");
	  phone2.setComment("Superman's home number");
	  User user = userDao.getUser(1L);
	  phone2.setUser(user);
	  boolean created = phoneDao.savePhone(phone2);
	  System.out.printf("New Phone %s%n", created ? "created" : "not created");
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
