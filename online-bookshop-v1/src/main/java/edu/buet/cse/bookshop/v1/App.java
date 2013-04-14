package edu.buet.cse.bookshop.v1;

import edu.buet.cse.bookshop.v1.model.Book;
import edu.buet.cse.bookshop.v1.model.dao.BookDao;
import edu.buet.cse.bookshop.v1.util.HibernateUtil;

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
