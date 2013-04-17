package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This class demonstrates the use of a named SQL query
 * @author shamim
 *
 */
public class App18 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Query query = session.getNamedQuery("edu.buet.cse.hibernate.ch08.model.Product.sqlPrice");
      @SuppressWarnings("unchecked")
      List<Object[]> results = query.list();
      
      for (Object[] row : results) {
        System.out.printf("name = %s, price = %s%n", row[0], row[1]);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
