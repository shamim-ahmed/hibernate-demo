package edu.buet.cse.billboard;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.Advert;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App4 {
  public static void main(String[] args) {
	Session session = null;
	
	try {
	  session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  Advert advert = (Advert) session.get(Advert.class, 1L);
	  tx.commit();
	  
	  System.out.println(advert);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
