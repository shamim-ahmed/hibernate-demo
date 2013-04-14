package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

// Example of projection using HQL
public class App3 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Query query = session.createQuery("select p.name, p.price from Product p where p.price <= 25.00");
      @SuppressWarnings("unchecked")
      List<Object[]> results = query.list();
      
      for (Object[] props : results) {
        System.out.printf("name = %s, price = %s%n", props[0], props[1]);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
