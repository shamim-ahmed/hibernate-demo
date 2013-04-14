package edu.buet.cse.hibernate.ch06.v2;

import edu.buet.cse.hibernate.ch06.v2.dao.AdvertDao;
import edu.buet.cse.hibernate.ch06.v2.model.Advert;
import edu.buet.cse.hibernate.ch06.v2.util.HibernateUtil;

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
