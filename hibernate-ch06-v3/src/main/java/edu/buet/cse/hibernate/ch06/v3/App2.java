package edu.buet.cse.hibernate.ch06.v3;

import edu.buet.cse.hibernate.ch06.v3.dao.AdvertDao;
import edu.buet.cse.hibernate.ch06.v3.model.PropertyAdvert;
import edu.buet.cse.hibernate.ch06.v3.util.HibernateUtil;

public class App2 {
  public static void main(String[] args) {
    try {
      PropertyAdvert advert = AdvertDao.getAdvert(PropertyAdvert.class, 1L);
      System.out.println(advert);
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
