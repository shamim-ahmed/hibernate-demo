package edu.buet.cse.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.buet.cse.hibernate.model.Motd;

public class App {
  public static void main(String[] args) {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();

	try {
	  Motd messageOfDay = (Motd) session.get(Motd.class, 1L);
	  System.out.println(messageOfDay);
	} finally {
	  session.close();
	}
  }
}