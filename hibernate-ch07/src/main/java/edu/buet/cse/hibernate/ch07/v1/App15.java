package edu.buet.cse.hibernate.ch07.v1;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App15 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Product.class);
      criteria.add(Restrictions.eq("name", "Mouse"));
      Product product = (Product) criteria.uniqueResult();
      tx.commit();

      System.out.println(product);
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
