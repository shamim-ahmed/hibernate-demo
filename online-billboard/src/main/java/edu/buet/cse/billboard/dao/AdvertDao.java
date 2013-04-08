package edu.buet.cse.billboard.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.model.Advert;
import edu.buet.cse.billboard.util.HibernateUtil;

public class AdvertDao {
  public static Advert getAdvert(Long id) {
	if (id == null) {
	  return null;
	}
	
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	Advert advert = (Advert) session.get(Advert.class, id);
	tx.commit();
	
	return advert;
  }
  
  private AdvertDao() {
  }
}
