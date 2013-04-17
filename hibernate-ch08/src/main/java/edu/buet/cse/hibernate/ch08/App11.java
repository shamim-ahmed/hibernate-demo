package edu.buet.cse.hibernate.ch08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.model.Product;
import edu.buet.cse.hibernate.ch08.model.Supplier;
import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This classes demonstrates how to use inner join in HQL to fetch multiple objects
 * @author shamim
 *
 */
public class App11 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String hql = "from Product p inner join p.supplier as s";
      Query query = session.createQuery(hql);
      @SuppressWarnings("unchecked")
      List<Object[]> results = query.list();
      
      for (Object[] row : results) {
        Product p = (Product) row[0];
        Supplier s = (Supplier) row[1];
        
        System.out.println(p);
        System.out.println(s);
        
        System.out.print("\n\n");
      }
      
      tx.commit();
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
