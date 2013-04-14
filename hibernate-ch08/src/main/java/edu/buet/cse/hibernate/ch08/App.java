package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Supplier;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

public class App {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Query query = session.createQuery("from Supplier");
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
