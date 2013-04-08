package edu.buet.cse.billboard.v2;

import edu.buet.cse.billboard.v2.dao.CategoryDao;
import edu.buet.cse.billboard.v2.model.Category;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

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
