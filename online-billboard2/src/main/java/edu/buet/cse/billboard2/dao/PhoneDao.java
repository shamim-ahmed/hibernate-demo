package edu.buet.cse.billboard2.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.billboard2.model.Phone;
import edu.buet.cse.billboard2.util.HibernateUtil;

public class PhoneDao {
  public static Phone getPhone(Long id) {
	if (id == null) {
	  return null;
	}
	
	Session session = HibernateUtil.getSession();
	Transaction tx = session.beginTransaction();
	Phone phone = (Phone) session.get(Phone.class, id);
	tx.commit();
	
	return phone;
  }
  
  private PhoneDao() {
  }
}
