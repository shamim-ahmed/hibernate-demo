package edu.buet.cse.hibernate.ch06.v5.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.ch06.v5.util.HibernateUtil;

public class AdvertDao {
  public static <T> T getAdvert(Class<T> c, Long id) {
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	@SuppressWarnings("unchecked")
	T advert = (T) session.get(c, id);
	tx.commit();
	return advert;
  }
  
  private AdvertDao() {
  }
}
