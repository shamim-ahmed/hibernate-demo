package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.model.Supplier;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

public class App12 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      // note the 'fetch' keyword, which ensures that everything is loaded at once
      String hql = "from Product p inner join fetch p.supplier as s where p.price <= 50.0";
      Query query = session.createQuery(hql);
      @SuppressWarnings("unchecked")
      List<Product> results = query.list();
      
      for (Product p : results) {
        System.out.println(p);
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
