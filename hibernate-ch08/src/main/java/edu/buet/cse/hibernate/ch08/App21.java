package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Supplier;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * 
 * @author shamim
 *
 */
public class App21 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String sql = "SELECT {s.*} FROM Supplier s";
      SQLQuery query = session.createSQLQuery(sql);
      query.addEntity("s", Supplier.class);
      @SuppressWarnings("unchecked")
      List<Supplier> suppliers = query.list();
      
      for (Supplier s : suppliers) {
        System.out.println(s);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
