package edu.buet.cse.bookshop;

import edu.buet.cse.bookshop.model.Book;
import edu.buet.cse.bookshop.model.dao.BookDao;
import edu.buet.cse.bookshop.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
	try {
	  BookDao dao = new BookDao();
	  Book book = dao.getBook(1L);
	  System.out.println(book);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
