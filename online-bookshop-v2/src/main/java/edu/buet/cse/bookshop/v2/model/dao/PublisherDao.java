package edu.buet.cse.bookshop.v2.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.bookshop.v2.model.Publisher;
import edu.buet.cse.bookshop.v2.util.HibernateUtil;

public class PublisherDao {
  public Publisher getPublisher(Long id) {
	if (id == null) {
	  return null;
	}
	
	Publisher publisher = null;
	Transaction tx = null;
	
	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  publisher = (Publisher) session.get(Publisher.class, id);
	  tx.commit();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	  
	  if (tx != null) {
		tx.rollback();
	  }
	}
	
	return publisher;
  }
}
