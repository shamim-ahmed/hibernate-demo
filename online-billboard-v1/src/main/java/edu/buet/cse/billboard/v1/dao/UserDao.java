package edu.buet.cse.billboard.v1.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.v1.model.User;
import edu.buet.cse.billboard.v1.util.HibernateUtil;

public class UserDao {
  public User getUser(Long id) {
    if (id == null) {
      return null;
    }

    Transaction tx = null;
    User user = null;

    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      user = (User) session.get(User.class, id);
      tx.commit();
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);

      if (tx != null) {
        tx.rollback();
      }
    }

    return user;
  }

  public boolean saveUser(User user) {
    if (user == null) {
      return false;
    }

    boolean result = false;
    Transaction tx = null;

    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      session.save(user);
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

  public boolean deleteUser(User user) {
    if (user == null) {
      return false;
    }

    boolean result = false;
    Transaction tx = null;

    try {
      Session session = HibernateUtil.getSession();
      tx = session.beginTransaction();
      session.delete(user);
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
