package edu.buet.cse.hibernate.ch11.v1;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch11.v1.model.Booking;
import edu.buet.cse.hibernate.ch11.v1.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    Transaction tx = null;
    
    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      
      // load all entities
      String hql = "from Booking";
      Query query = session.createQuery(hql);
      @SuppressWarnings("unchecked")
      List<Booking> bookings = query.list();
      
      System.out.printf("Number of bookings : %d%n", bookings.size());
      
      // create a new booking
      Booking booking = new Booking();
      booking.setName("Farhana Mahmud");
      booking.setSeat("3M");
      session.save(booking);
      
      tx.commit();
    } catch (HibernateException ex)  {
      ex.printStackTrace(System.err);
      
      if (tx != null) {
        tx.rollback();
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
