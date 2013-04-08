package edu.buet.cse.billboard.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.Advert;
import edu.buet.cse.billboard.util.HibernateUtil;

public class AdvertDao {
  public Advert getAdvert(Long id) {
	if (id == null) {
	  return null;
	}

	Advert advert = null;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  advert = (Advert) session.get(Advert.class, id);
	  tx.commit();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);

	  if (tx != null) {
		tx.rollback();
	  }
	}

	return advert;
  }

  public boolean saveAdvert(Advert advert) {
	if (advert == null) {
	  return false;
	}

	boolean result = false;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.save(advert);
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

  public boolean deleteAdvert(Advert advert) {
	if (advert == null) {
	  return false;
	}

	boolean result = false;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.delete(advert);
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
