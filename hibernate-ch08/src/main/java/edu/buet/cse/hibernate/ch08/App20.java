package edu.buet.cse.hibernate.ch08;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This example demonstrates the formation and use of a parameterized SQL query
 * 
 * @author shamim
 * 
 */
public class App20 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String sql = "SELECT s.id, s.name FROM Supplier s where s.id = :id";
      SQLQuery query = session.createSQLQuery(sql);
      query.addScalar("id", StandardBasicTypes.LONG);
      query.addScalar("name", StandardBasicTypes.STRING);
      query.setParameter("id", 1);
      Object[] row = (Object[]) query.uniqueResult();
      System.out.printf("id = %d, name = %s%n", row[0], row[1]);
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
