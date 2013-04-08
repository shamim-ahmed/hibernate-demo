package edu.buet.cse.billboard;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.Category;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App3 {
  public static void main(String[] args) {
	Session session = null;
	
	try {
	  session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  Category category = (Category) session.get(Category.class, 1L);
	  tx.commit();
	  
	  System.out.println(category);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	}
  }
}
