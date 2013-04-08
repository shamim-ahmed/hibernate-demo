package edu.buet.cse.billboard;

import org.hibernate.HibernateException;

import edu.buet.cse.billboard.dao.AdvertDao;
import edu.buet.cse.billboard.model.Advert;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App4 {
  public static void main(String[] args) {	
	try {
	  Advert advert = AdvertDao.getAdvert(1L);  
	  System.out.println(advert);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
