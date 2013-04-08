package edu.buet.cse.billboard;

import org.hibernate.HibernateException;

import edu.buet.cse.billboard.dao.PhoneDao;
import edu.buet.cse.billboard.model.Phone;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App2 {
  public static void main(String[] args) {	
	try {
	  Phone phone = PhoneDao.getPhone(1L);	  
	  System.out.println(phone);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
