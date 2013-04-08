package edu.buet.cse.billboard.v2.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard.v2.model.Category;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

public class CategoryDao {
  public static Category getCategory(Long id) {
	if (id == null) {
	  return null;
	}
	
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	Category category = (Category) session.get(Category.class, id);
	tx.commit();
	
	return category;
  }
  
  private CategoryDao() {
  }
}
