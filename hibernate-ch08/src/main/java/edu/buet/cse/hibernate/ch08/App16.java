package edu.buet.cse.hibernate.ch08;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * A class that demonstrates an example of bulk deletion using HQL
 * 
 * @author shamim
 * 
 */
public class App16 {
  public static void main(String... args) {
    Transaction tx = null;

    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      String hql = "delete Product p where p.price <= 5.0";
      Query query = session.createQuery(hql);
      int count = query.executeUpdate();
      System.out.printf("Number of rows deleted: %d%n", count);
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);

      if (tx != null) {
        tx.rollback();
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
