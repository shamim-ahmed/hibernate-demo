package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

// an example of a relatively complex query using HQL
public class App4 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      String hql = "from Product p where (p.price <= 25.0 or p.name like 'Mou%') and p.description like '%from%'";
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
