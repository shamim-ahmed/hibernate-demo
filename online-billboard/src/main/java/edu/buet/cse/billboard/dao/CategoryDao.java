package edu.buet.cse.billboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.Category;
import edu.buet.cse.billboard.util.HibernateUtil;

public class CategoryDao {
  public Category getCategory(Long id) {
	if (id == null) {
	  return null;
	}

	Category category = null;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  category = (Category) session.get(Category.class, id);
	  tx.commit();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);

	  if (tx != null) {
		tx.rollback();
	  }
	}

	return category;
  }

  public boolean saveCategory(Category category) {
	if (category == null) {
	  return false;
	}

	boolean result = false;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.save(category);
	  tx.commit();
	  result = true;
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);

	  if (tx != null) {
		tx.rollback();
	  }
	}

	return result;
  }

  public boolean deleteCategory(Category category) {
	if (category == null) {
	  return false;
	}

	boolean result = false;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.delete(category);
	  tx.commit();
	  result = true;
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);

	  if (tx != null) {
		tx.rollback();
	  }
	}

	return result;
  }
}
