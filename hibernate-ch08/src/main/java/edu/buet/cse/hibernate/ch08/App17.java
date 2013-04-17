package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This class demonstrates the use of a named query
 * @author shamim
 *
 */
public class App17 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Query query = session.getNamedQuery("edu.buet.cse.hibernate.ch08.model.Product.hqlPrice");
      @SuppressWarnings("unchecked")
      List<Product> products = query.list();
      
      for (Product p : products) {
        System.out.println(p);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
