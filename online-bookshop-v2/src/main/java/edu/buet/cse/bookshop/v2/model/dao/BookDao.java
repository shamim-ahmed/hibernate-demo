package edu.buet.cse.bookshop.v2.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.bookshop.v2.model.Book;
import edu.buet.cse.bookshop.v2.util.HibernateUtil;

public class BookDao {
  public Book getBook(Long id) {
	if (id == null) {
	  return null;
	}
	
	Book book = null;
	Transaction tx = null;
	
	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  book = (Book) session.get(Book.class, id);
	  tx.commit();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	  
	  if (tx != null) {
		tx.rollback();
	  }
	} 
	
	return book;
  }
}
