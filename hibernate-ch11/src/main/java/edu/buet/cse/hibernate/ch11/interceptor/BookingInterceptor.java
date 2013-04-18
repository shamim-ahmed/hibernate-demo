package edu.buet.cse.hibernate.ch11.interceptor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

public class BookingInterceptor extends EmptyInterceptor {
  private static final long serialVersionUID = 1L;
  private Set<Object> createdEntities;
  private Set<Object> loadedEntities;

  @Override
  public void afterTransactionBegin(Transaction tx) {
    createdEntities = new HashSet<>();
    loadedEntities = new HashSet<>();
  }

  @Override
  public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
      throws CallbackException {
    if (createdEntities != null) {
      createdEntities.add(entity);
    }

    return true;
  }

  @Override
  public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
      throws CallbackException {
    if (loadedEntities != null) {
      loadedEntities.add(entity);
    }

    return true;
  }

  @Override
  public void afterTransactionCompletion(Transaction tx) {
    if (tx.wasCommitted()) {
      if (createdEntities != null) {
        System.out.println("Objects created in transaction : ");

        for (Object entity : createdEntities) {
          System.out.println(entity);
        }
      }
      
      System.out.println("\n\n");
      
      if (loadedEntities != null) {
        System.out.println("Objects loaded in transaction : ");
        
        for (Object entity : loadedEntities) {
          System.out.println(entity);
        }
      }
    }

    createdEntities = null;
    loadedEntities = null;
  }
}
