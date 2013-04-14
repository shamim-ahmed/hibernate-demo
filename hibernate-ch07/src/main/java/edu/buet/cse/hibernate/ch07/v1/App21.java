package edu.buet.cse.hibernate.ch07.v1;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import edu.buet.cse.hibernate.ch07.v1.model.Product;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App21 {
  public static void main(String... args) {
    final String[] columns = { "max", "min", "sum", "avg" };
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Product.class);
      ProjectionList projList = Projections.projectionList();
      projList.add(Projections.max("price"));
      projList.add(Projections.min("price"));
      projList.add(Projections.sum("price"));
      projList.add(Projections.avg("price"));
      criteria.setProjection(projList);
      Object[] results = (Object[]) criteria.uniqueResult();
      tx.commit();

      for (int i = 0, n = results.length; i < n; i++) {
        Object res = results[i];
        System.out.printf("%s = %s%n", columns[i], res);
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
