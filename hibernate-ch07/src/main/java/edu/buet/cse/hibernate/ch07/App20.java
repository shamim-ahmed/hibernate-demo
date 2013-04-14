package edu.buet.cse.hibernate.ch07;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import edu.buet.cse.hibernate.ch07.model.Product;
import edu.buet.cse.hibernate.ch07.util.HibernateUtil;

public class App20 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Product.class);
      criteria.setProjection(Projections.max("price"));
      Double maxPrice = (Double) criteria.uniqueResult();
      tx.commit();

      System.out.println(maxPrice);
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
