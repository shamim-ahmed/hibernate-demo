package edu.buet.cse.billboard.v2.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.v2.model.Phone;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

public class PhoneDao {
  public Phone getPhone(Long id) {
	if (id == null) {
	  return null;
	}

	Phone phone = null;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  phone = (Phone) session.get(Phone.class, id);
	  tx.commit();
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	  
	  if (tx != null) {
		tx.rollback();
	  }
	}

	return phone;
  }

  public boolean savePhone(Phone phone) {
	if (phone == null) {
	  return false;
	}

	boolean result = false;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.save(phone);
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

  public boolean deletePhone(Phone phone) {
	if (phone == null) {
	  return false;
	}

	boolean result = false;
	Transaction tx = null;

	try {
	  Session session = HibernateUtil.getSession();
	  tx = session.beginTransaction();
	  session.delete(phone);
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
