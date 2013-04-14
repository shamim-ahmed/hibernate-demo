package edu.buet.cse.hibernate.ch07.v1;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import edu.buet.cse.hibernate.ch07.v1.model.Software;
import edu.buet.cse.hibernate.ch07.v1.util.HibernateUtil;

public class App16 {
  public static void main(String... args) {
	try {
	  Session session = HibernateUtil.getSession();
	  Transaction tx = session.beginTransaction();
	  Criteria criteria = session.createCriteria(Software.class);
	  criteria.addOrder(Order.desc("price"));
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
