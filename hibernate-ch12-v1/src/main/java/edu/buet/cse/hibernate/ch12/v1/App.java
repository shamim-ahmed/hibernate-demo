package edu.buet.cse.hibernate.ch12.v1;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch12.v1.model.User;
import edu.buet.cse.hibernate.ch12.v1.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String hql = "from User";
      Query query = session.createQuery(hql);
      
      System.out.println("Retrieving users before activating filter....");
      @SuppressWarnings("unchecked")
      List<User> uesrs = query.list();
      
      for (User u : uesrs) {
        System.out.println(u);
      }
      
      // activate the filter
      Filter filter = session.enableFilter("activationFilter");
      filter.setParameter("activatedParam", true);
      
      // now retrieve users again
      System.out.println("\n\nRetrieving users after activating filter....");
      Query query2 = session.createQuery(hql);
      @SuppressWarnings("unchecked")
      List<User> filteredUsers = query2.list();
      
      for (User u : filteredUsers) {
        System.out.println(u);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
