package edu.buet.cse.hibernate.ch08;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch08.util.HibernateUtil;

/**
 * This class demonstrates the use of several aggregate methods in HQL 
 * @author shamim
 * 
 */
public class App14 {
  public static void main(String... args) {
    try {
      Session session = HibernateUtil.getSession();
      Transaction tx = session.beginTransaction();
      String maxHql = "select max(p.price) from Product p";
      Query maxQuery = session.createQuery(maxHql);
      Double max = (Double) maxQuery.uniqueResult();
      System.out.printf("maximum price: %s%n", max.toString());
      
      String minHql = "select min(p.price) from Product p";
      Query minQuery = session.createQuery(minHql);
      Double min = (Double) minQuery.uniqueResult();
      System.out.printf("minimum price: %s%n", min.toString());
      tx.commit();
      
      String avgHql = "select avg(p.price) from Product p";
      Query avgQuery = session.createQuery(avgHql);
      Double avg = (Double) avgQuery.uniqueResult();
      System.out.printf("Average price: %s%n", avg.toString());
      
      String sumHql = "select sum(p.price) from Product p";
      Query sumQuery = session.createQuery(sumHql);
      Double sum = (Double) sumQuery.uniqueResult();
      System.out.printf("Total price: %s%n", sum.toString());
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
