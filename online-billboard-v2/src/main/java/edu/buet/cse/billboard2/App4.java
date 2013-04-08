package edu.buet.cse.billboard2;

import edu.buet.cse.billboard2.dao.AdvertDao;
import edu.buet.cse.billboard2.model.Advert;
import edu.buet.cse.billboard2.util.HibernateUtil;

public class App4 {
  public static void main(String[] args) {	
	try {
	  Advert advert = AdvertDao.getAdvert(1L); 
	  System.out.println(advert);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
