package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App22 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Product.class);
      ProjectionList projList = Projections.projectionList();
      projList.add(Projections.property("name"));
      projList.add(Projections.property("price"));
      criteria.setProjection(projList);
      @SuppressWarnings("unchecked")
      List<Object[]> results = criteria.list();
      tx.commit();

      for (Object[] props : results) {
        System.out.printf("name = %s, price = %s%n", props[0], props[1]);
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
