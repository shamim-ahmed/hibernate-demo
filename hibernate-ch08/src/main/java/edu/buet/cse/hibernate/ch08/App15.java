package edu.buet.cse.hibernate.ch08;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This class demonstrates how to update entities using HQL
 * @author shamim
 *
 */
public class App15 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String hql = "update Product p set p.price = 1.5 * p.price where p.price <= 25.0";
      Query query = session.createQuery(hql);
      int count = query.executeUpdate();
      System.out.printf("Number of rows updated: %d%n", count);
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
