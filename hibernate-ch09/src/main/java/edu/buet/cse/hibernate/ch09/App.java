package edu.buet.cse.hibernate.ch09;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import edu.buet.cse.hibernate.ch09.model.Department;
import edu.buet.cse.hibernate.ch09.util.HibernateUtil;

/**
 * A simple example to check if L2 cache is working
 * 
 * @author shamim
 * 
 */
public class App {
  public static void main(String[] args) {
    try {
      Session session = HibernateUtil.getSession();

      for (int i = 0; i < 10; i++) {
        foo(session);
      }
    } finally {
      HibernateUtil.cleanUp();

      // print log summary
      Statistics statistics = HibernateUtil.getSessionFactory().getStatistics();
      statistics.logSummary();      
    }
  }

  private static void foo(Session session) {
    Transaction tx = session.beginTransaction();
    
    String hql = "from Department";
    Query query = session.createQuery(hql).setCacheable(true);
    @SuppressWarnings("unchecked")
    List<Department> departments = query.list();

    for (Department d : departments) {
      System.out.println(d.getName());
    }

    tx.commit();
  }
}
