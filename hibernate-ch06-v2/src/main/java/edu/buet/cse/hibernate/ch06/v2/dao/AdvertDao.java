package edu.buet.cse.hibernate.ch06.v2.dao;

import org.hibernate.Session;

import edu.buet.cse.hibernate.ch06.v2.model.Advert;
import edu.buet.cse.hibernate.ch06.v2.util.HibernateUtil;

public class AdvertDao {
  public Advert getAdvert(Long id) {
	Session session = HibernateUtil.getSession();
	Advert advert = (Advert) session.get(Advert.class, id);
	return advert;
  }
}
