package edu.buet.cse.hibernate.ch07;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.model.Supplier;
import edu.buet.cse.hibernate.ch07.util.HibernateUtil;

public class App18 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria supCriteria = session.createCriteria(Supplier.class);
      supCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
      Criteria prodCriteria = supCriteria.createCriteria("products");
      prodCriteria.add(Restrictions.le("price", 25.00));
      @SuppressWarnings("unchecked")
      List<Supplier> suppliers = supCriteria.list();
      tx.commit();

      for (Supplier s : suppliers) {
        System.out.println(s);
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
