package edu.buet.cse.hibernate.ch06.v4;

import edu.buet.cse.hibernate.ch06.v4.dao.AdvertDao;
import edu.buet.cse.hibernate.ch06.v4.model.PropertyAdvert;
import edu.buet.cse.hibernate.ch06.v4.util.HibernateUtil;

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
