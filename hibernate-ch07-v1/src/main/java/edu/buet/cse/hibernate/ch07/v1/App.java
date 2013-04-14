package edu.buet.cse.hibernate.ch07.v1;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch07.v1.model.Supplier;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App {
  public static void main(String[] args) {	
	try {
	  Session session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  Supplier supplier = (Supplier) session.get(Supplier.class, 1L);
	  System.out.println(supplier);
	  tx.commit();
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}