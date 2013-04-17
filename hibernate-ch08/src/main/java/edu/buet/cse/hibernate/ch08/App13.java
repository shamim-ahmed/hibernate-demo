package edu.buet.cse.hibernate.ch08;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This class demonstrates the use of aggregate methods in HQL
 * @author shamim
 *
 */
public class App13 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String hql = "select count(s.id) from Supplier s";
      Query query = session.createQuery(hql);
      Long result = (Long) query.uniqueResult();
      System.out.println(result);
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
