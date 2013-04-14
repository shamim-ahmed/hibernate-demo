package edu.buet.cse.hibernate.intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.buet.cse.hibernate.intro.model.Motd;

public class App {
  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = null;

    try {
      session = sessionFactory.openSession();
      Motd messageOfDay = (Motd) session.get(Motd.class, 1L);
      System.out.println(messageOfDay);
    } finally {
      if (session != null) {
        session.close();
      }

      sessionFactory.close();
    }
  }
}