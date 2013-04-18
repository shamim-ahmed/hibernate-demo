package edu.buet.cse.hibernate.ch11.v2.listener;

import org.hibernate.event.LoadEvent;
import org.hibernate.event.LoadEventListener;
import org.hibernate.event.def.DefaultLoadEventListener;

public class BookingLoadListener extends DefaultLoadEventListener {
  private static final long serialVersionUID = 1L;
  
  public void onLoad(LoadEvent event, LoadEventListener.LoadType loadType) {
    super.onLoad(event, loadType);
    Long id = (Long) event.getEntityId();
    System.out.printf("Entity with id %d is being loaded%n", id);
  }
}
