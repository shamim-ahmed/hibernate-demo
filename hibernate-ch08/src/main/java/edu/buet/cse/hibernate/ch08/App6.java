package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

// nested property access in HQL
public class App6 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      String hql = "from Product p where p.supplier.name = :supName";
      Query query = session.createQuery(hql);
      query.setString("supName", "Woolworths");
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
