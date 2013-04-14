package edu.buet.cse.hibernate.ch06.v5;

import edu.buet.cse.hibernate.ch06.v5.dao.AdvertDao;
import edu.buet.cse.hibernate.ch06.v5.model.PersonalAdvert;
import edu.buet.cse.hibernate.ch06.v5.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    try {
      PersonalAdvert advert = AdvertDao.getAdvert(PersonalAdvert.class, 1L);
      System.out.println(advert);
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
