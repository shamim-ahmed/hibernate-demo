package edu.buet.cse.hibernate.ch11.v2.listener;

import org.hibernate.HibernateException;
import org.hibernate.event.DeleteEvent;
import org.hibernate.event.def.DefaultDeleteEventListener;

import edu.buet.cse.hibernate.ch11.v2.model.Booking;

public class BookingDeleteListener extends DefaultDeleteEventListener {
  private static final long serialVersionUID = 1L;

  public void onDelete(DeleteEvent event) throws HibernateException {
    super.onDelete(event);
    
    Object entity = event.getObject();
    
    if (entity instanceof Booking) {
      Booking booking = (Booking) entity;
      System.out.printf("Booking with id %d is being deleted%n", booking.getId());
    }
  }
}
