package edu.buet.cse.bookshop.v2.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.bookshop.v2.model.Author;
import edu.buet.cse.bookshop.v2.util.HibernateUtil;

public class AuthorDao {
  public Author getAuthor(Long id) {
	if (id == null) {
	  return null;
	}
	
	Author author = null;
	Transaction tx = null;
	
	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  author = (Author) session.get(Author.class, id);
	  tx.commit();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	  
	  if (tx != null) {
		tx.rollback();
	  }
	}
	
	return author;
  }
}
