package edu.buet.cse.billboard2;

import edu.buet.cse.billboard2.dao.CategoryDao;
import edu.buet.cse.billboard2.model.Category;
import edu.buet.cse.billboard2.util.HibernateUtil;

public class App3 {
  public static void main(String[] args) {	
	try {
	  Category category = CategoryDao.getCategory(1L);	  
	  System.out.println(category);
	} finally {
	  HibernateUtil.cleanUp();
	}
  }
}
