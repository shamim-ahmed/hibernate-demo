package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App10 {
  public static void main(String... args) {
	try {
	  Session session = HibernateUtil.getSession();
	  
	  Transaction tx = session.beginTransaction();
	  Criteria criteria = session.createCriteria(Product.class);
	  criteria.add(Restrictions.isNotNull("description"));
	  criteria.add(Restrictions.ilike("name", "m%"));
	  @SuppressWarnings("unchecked")
	  List<Product> products = criteria.list();
	  tx.commit();

	  for (Product p : products) {
		System.out.println(p);
	  }	  
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
