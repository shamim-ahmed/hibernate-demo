package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import edu.buet.cse.hibernate.ch07.v1.model.Supplier;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App23 {
  public static void main(String... args) {
	try {
	  Session session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  Criteria criteria = session.createCriteria(Supplier.class);
	  Supplier supplier = new Supplier();
	  supplier.setName("Microsoft");
	  criteria.add(Example.create(supplier));
	  @SuppressWarnings("unchecked")
	  List<Supplier> suppliers = criteria.list();
	  tx.commit();
	  
	  for (Supplier s : suppliers) {
		System.out.println(s);
	  }
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
