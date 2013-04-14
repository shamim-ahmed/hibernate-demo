package edu.buet.cse.billboard.v2;

import edu.buet.cse.billboard.v2.dao.CategoryDao;
import edu.buet.cse.billboard.v2.model.Category;
import edu.buet.cse.billboard.v2.util.HibernateUtil;

public class App3 {
  public static void main(String[] args) {
    try {
      // get category
      CategoryDao categoryDao = new CategoryDao();
      Category category1 = categoryDao.getCategory(1L);
      System.out.println(category1);

      // update category
      category1.setTitle(category1.getTitle().concat("modified"));
      boolean updated = categoryDao.saveCategory(category1);
      System.out.printf("category %s%n", updated ? "updated" : "not updated");

      // create new category
      Category category2 = new Category();
      category2.setTitle("Entertainment");
      boolean created = categoryDao.saveCategory(category2);
      System.out.printf("New category %s%n", created ? "created" : "not created");
    } finally {
      HibernateUtil.cleanUp();
    }
  }
}
