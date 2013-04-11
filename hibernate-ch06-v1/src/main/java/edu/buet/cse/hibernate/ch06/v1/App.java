package edu.buet.cse.hibernate.ch06.v1;

import edu.buet.cse.hibernate.ch06.v1.dao.AdvertDao;
import edu.buet.cse.hibernate.ch06.v1.model.Advert;
import edu.buet.cse.hibernate.ch06.v1.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
	try {
	  AdvertDao dao = new AdvertDao();
	  Advert advert = dao.getAdvert(1L);
	  System.out.println(advert);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
