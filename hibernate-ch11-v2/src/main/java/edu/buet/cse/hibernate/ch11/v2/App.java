package edu.buet.cse.hibernate.ch11.v2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch11.v2.model.Booking;
import edu.buet.cse.hibernate.ch11.v2.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    Transaction tx = null;

    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      Booking booking = (Booking) session.get(Booking.class, 1L);
      System.out.println(booking);
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);

      if (tx != null) {
        tx.rollback();
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
