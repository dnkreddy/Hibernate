package com.lavi.hibernate.model;

import javax.persistence.EntityManager;



/**
 * @author naveen
 */
public class MainApp {
  public static void main(String[] args) {
    EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
    entityManager.getTransaction().begin();

    UserDetails user = new UserDetails();
    user.setUserId(600);
    user.setUserName("Naveen Persistemce");

    entityManager.persist(user);
    entityManager.getTransaction().commit();
    entityManager.close();

    JPAUtil.shutdown();
  }
}
