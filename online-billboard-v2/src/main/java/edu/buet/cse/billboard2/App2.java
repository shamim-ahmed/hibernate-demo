package edu.buet.cse.billboard2;

import edu.buet.cse.billboard2.dao.PhoneDao;
import edu.buet.cse.billboard2.model.Phone;
import edu.buet.cse.billboard2.util.HibernateUtil;

public class App2 {
  public static void main(String[] args) {	
	try {
	  Phone phone =  PhoneDao.getPhone(1L);	  
	  System.out.println(phone);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
