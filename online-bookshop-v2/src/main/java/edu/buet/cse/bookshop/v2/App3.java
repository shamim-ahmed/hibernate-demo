package edu.buet.cse.bookshop.v2;

import edu.buet.cse.bookshop.v2.model.Author;
import edu.buet.cse.bookshop.v2.model.dao.AuthorDao;
import edu.buet.cse.bookshop.v2.util.HibernateUtil;

public class App3 {
  public static void main(String... args) {
	try {
	  AuthorDao dao = new AuthorDao();
	  Author author = dao.getAuthor(1L);
	  System.out.println(author);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
