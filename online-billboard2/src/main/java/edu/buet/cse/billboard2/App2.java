package edu.buet.cse.billboard2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard2.model.Phone;
import edu.buet.cse.billboard2.util.HibernateUtil;

public class App2 {
  public static void main(String[] args) {
	Session session = null;
	
	try {
	  session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  Phone phone = (Phone) session.get(Phone.class, 1L);
	  tx.commit();
	  
	  System.out.println(phone);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
