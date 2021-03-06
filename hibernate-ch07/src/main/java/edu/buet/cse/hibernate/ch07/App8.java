package edu.buet.cse.hibernate.ch07;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.ch07.model.Software;
import edu.buet.cse.hibernate.ch07.util.HibernateUtil;

public class App8 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      Criteria criteria = session.createCriteria(Software.class);
      criteria.add(Restrictions.ilike("description", "software", MatchMode.ANYWHERE));
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
