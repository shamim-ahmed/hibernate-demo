package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.model.Supplier;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

// an example of setting an entity to a named parameter in HQL
public class App7 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      Supplier supplier = (Supplier) session.get(Supplier.class, 1L);

      String hql = "from Product p where p.supplier = :supplier";
      Query query = session.createQuery(hql);      
      query.setEntity("supplier", supplier);
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
