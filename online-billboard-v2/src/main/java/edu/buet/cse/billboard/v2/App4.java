package edu.buet.cse.billboard.v2;

import edu.buet.cse.billboard.v2.dao.AdvertDao;
import edu.buet.cse.billboard.v2.dao.UserDao;
import edu.buet.cse.billboard.v2.model.Advert;
import edu.buet.cse.billboard.v2.model.User;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

public class App4 {
  public static void main(String[] args) {	
	try {
	  // get advert
	  AdvertDao advertDao = new AdvertDao();
	  Advert advert1 = advertDao.getAdvert(1L);  
	  System.out.println(advert1);
	  
	  // update advert
	  advert1.setTitle(advert1.getTitle().concat("modified"));
	  boolean updated = advertDao.saveAdvert(advert1);
	  System.out.printf("Advert %s%n", updated ? "updated" : "not updated");
	  
	  // create new advert
	  Advert advert2 = new Advert();
	  advert2.setTitle("Buy my iPod");
	  advert2.setMessage("I don't need it anymore. It's brand new.");
	  
	  UserDao userDao = new UserDao();
	  User user = userDao.getUser(1L);
	  advert2.setUser(user);
	  
	  boolean created = advertDao.saveAdvert(advert2);  
	  System.out.printf("New advert %s%n", created ? "created" : "not created");
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
