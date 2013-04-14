package edu.buet.cse.hibernate.ch07;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.model.Product;
import edu.buet.cse.hibernate.ch07.util.HibernateUtil;

public class App11 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Product.class);
      Criterion price = Restrictions.between("price", 25.00, 75.00);
      Criterion name = Restrictions.ilike("name", "m%");
      criteria.add(Restrictions.or(price, name));
      @SuppressWarnings("unchecked")
      List<Product> products = criteria.list();
      tx.commit();

      for (Product p : products) {
        System.out.println(p);
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
