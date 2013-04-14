package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch07.v1.model.Software;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App4 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();

      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Software.class);
      @SuppressWarnings("unchecked")
      List<Software> softwares = criteria.list();
      tx.commit();

      for (Software s : softwares) {
        System.out.println(s);
      }
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
