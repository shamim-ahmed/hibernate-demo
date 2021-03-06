package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

// example of using a fully qualified class name in HQL, along with regular expressions
public class App2 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      String hql = "from edu.buet.cse.hibernate.ch08.model.Product as p where p.name like 'M%'";
      Query query = session.createQuery(hql);
      @SuppressWarnings("unchecked")
      List<Product> products = query.list();
      
      for (Product p : products) {
        System.out.println(p);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
