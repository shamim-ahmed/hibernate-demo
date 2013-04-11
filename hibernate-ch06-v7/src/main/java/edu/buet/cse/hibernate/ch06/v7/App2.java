package edu.buet.cse.hibernate.ch06.v7;

import edu.buet.cse.hibernate.ch06.v7.dao.AdvertDao;
import edu.buet.cse.hibernate.ch06.v7.model.PropertyAdvert;
import edu.buet.cse.hibernate.ch06.v7.util.HibernateUtil;

public class App2 {
  public static void main(String[] args) {
	try {
	  PropertyAdvert advert = AdvertDao.getAdvert(PropertyAdvert.class, 2L);
	  System.out.println(advert);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
