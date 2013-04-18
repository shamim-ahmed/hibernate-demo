package edu.buet.cse.hibernate.ch11.v2;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch11.v2.model.Booking;
import edu.buet.cse.hibernate.ch11.v2.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
    Transaction tx = null;
    
    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      String hql = "from Booking where id = :id";
      Query query = session.createQuery(hql);
      query.setParameter("id", 1L);
      Booking booking = (Booking) query.uniqueResult();
      
      if (booking != null) {
        session.delete(booking);
      }
      
      tx.commit();
    } catch(HibernateException ex) {
      ex.printStackTrace(System.err);
      
      if (tx != null) {
        tx.rollback();
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
