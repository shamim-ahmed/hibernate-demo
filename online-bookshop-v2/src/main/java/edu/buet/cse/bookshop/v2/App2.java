package edu.buet.cse.bookshop.v2;

import edu.buet.cse.bookshop.v2.model.Publisher;
import edu.buet.cse.bookshop.v2.model.dao.PublisherDao;
import edu.buet.cse.bookshop.v2.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
	try {
	  PublisherDao dao = new PublisherDao();
	  Publisher publisher = dao.getPublisher(1L);
	  System.out.println(publisher);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
