package edu.buet.cse.hibernate.ch11;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch11.model.Booking;
import edu.buet.cse.hibernate.ch11.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Booking booking = (Booking) session.get(Booking.class, 1L);
      System.out.println(booking);
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
