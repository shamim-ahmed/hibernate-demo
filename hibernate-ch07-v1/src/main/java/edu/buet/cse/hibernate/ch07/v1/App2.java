package edu.buet.cse.hibernate.ch07.v1;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Product product = (Product) session.get(Product.class, 1L);
      tx.commit();

      System.out.println(product);
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
