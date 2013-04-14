package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App17 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria prodCriteria = session.createCriteria(Product.class);
      Criteria supCriteria = prodCriteria.createCriteria("supplier");
      supCriteria.add(Restrictions.ilike("name", "microsoft"));
      @SuppressWarnings("unchecked")
      List<Product> products = prodCriteria.list();
      tx.commit();

      for (Product p : products) {
        System.out.println(p);
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
