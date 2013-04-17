package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

public class App10 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      String hql = "select p.name, p.price, s.name from Product p inner join p.supplier as s";
      Query query = session.createQuery(hql);
      @SuppressWarnings("unchecked")
      List<Object[]> results = query.list();
      
      for (Object[] row : results) {
        System.out.printf("name = %s, price = %s, supplier = %s%n", row[0], row[1], row[2]);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
