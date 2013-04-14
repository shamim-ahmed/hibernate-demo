package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App12 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Product.class);
      Criterion price = Restrictions.between("price", 25.00, 75.00);
      Criterion name = Restrictions.ilike("name", "m%");
      LogicalExpression orExp = Restrictions.or(price, name);
      criteria.add(orExp);
      criteria.add(Restrictions.isNotNull("description"));
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
