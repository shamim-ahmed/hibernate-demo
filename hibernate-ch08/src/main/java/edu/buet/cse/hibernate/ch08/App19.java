package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This example demonstrates the formation and use of a native SQL query
 * 
 * @author shamim
 * 
 */
public class App19 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String sql = "SELECT p.name, p.price from Product p";
      SQLQuery query = session.createSQLQuery(sql);
      query.addScalar("name", StandardBasicTypes.STRING);
      query.addScalar("price", StandardBasicTypes.DOUBLE);
      @SuppressWarnings("unchecked")
      List<Object[]> results = query.list();

      for (Object[] row : results) {
        System.out.printf("name = %s, price = %.2f%n", row[0], row[1]);
      }

      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
