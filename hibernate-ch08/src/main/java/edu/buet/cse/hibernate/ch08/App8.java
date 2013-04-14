package edu.buet.cse.hibernate.ch08;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

// pagination with HQL
public class App8 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      String hql = "from Product p";
      Query query = session.createQuery(hql);
      query.setFirstResult(0);
      query.setMaxResults(1);
      Product product = (Product) query.uniqueResult();
      System.out.println(product);
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
