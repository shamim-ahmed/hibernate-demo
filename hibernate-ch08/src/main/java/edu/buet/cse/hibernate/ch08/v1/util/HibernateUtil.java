package edu.buet.cse.hibernate.ch08.v1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  private static final Session session;

  static {
    sessionFactory = new Configuration().configure().buildSessionFactory();
    session = sessionFactory.openSession();
  }

  public static Session getSession() {
    return session;
  }

  public static void cleanUp() {
    session.close();
    sessionFactory.close();
  }

  private HibernateUtil() {
  }
}
