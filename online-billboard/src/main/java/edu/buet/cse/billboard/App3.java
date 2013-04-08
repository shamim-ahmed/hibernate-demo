package edu.buet.cse.billboard;

import org.hibernate.HibernateException;

import edu.buet.cse.billboard.dao.CategoryDao;
import edu.buet.cse.billboard.model.Category;
import edu.buet.cse.billboard.util.HibernateUtil;

public class App3 {
  public static void main(String[] args) {	
	try {
	  Category category = CategoryDao.getCategory(1L);
	  System.out.println(category);
	} catch (HibernateException ex) {
	  ex.printStackTrace(System.err);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
