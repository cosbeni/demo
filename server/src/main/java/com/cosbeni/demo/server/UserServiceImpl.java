package com.cosbeni.demo.server;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import com.cosbeni.demo.shared.entity.User;
import com.cosbeni.demo.shared.service.UserService;

@RequestScoped
public class UserServiceImpl implements UserService {

  @Inject
  private Logger log;

  @Inject
  private EntityManager em;

  @Inject
  private UserTransaction userTransaction;

  @Override
  public User add(User user) {
    try {
      userTransaction.begin();
      if (user.getRid() == 0) {
        user.setRid(user.getId());
        user.setId(null);
        user.setCommand("");
      }
      em.persist(user);
      userTransaction.commit();
      return user;
    } catch (Exception ex) {
      try {
        userTransaction.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }
  }

  @Override
  public User update(User user) {
    try {
      if (user.getRid() != 0) {
        userTransaction.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> u = criteria.from(User.class);
        criteria.select(u);
        Predicate predicate = cb.equal(u.get("id"), user.getRid());
        criteria.where(predicate);
        User result = em.createQuery(criteria).getSingleResult();
        result.setUserName(user.getUserName());
        result.setPassword(user.getPassword());
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        result.setEmail(user.getEmail());
        userTransaction.commit();
        return result;
      }      
    } catch (Exception ex) {
      try {
        userTransaction.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return null;
  }

  @Override
  public List<User> getUsers() {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<User> criteria = cb.createQuery(User.class);
      Root<User> u = criteria.from(User.class);
      criteria.select(u);
      List<User> result = em.createQuery(criteria).getResultList();
      return result;
    } catch (NoResultException ex) {
      return null;
    } catch (Exception ex) {
      return null;
    }
  }

  @Override
  public User getUser(String id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<User> criteria = cb.createQuery(User.class);
    Root<User> u = criteria.from(User.class);
    criteria.select(u);
    Predicate predicate = cb.equal(u.get("id"), id);
    criteria.where(predicate);
    return em.createQuery(criteria).getSingleResult();
  }

  @Override
  public User delete(String id) {
    try {
      userTransaction.begin();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<User> criteria = cb.createQuery(User.class);
      Root<User> u = criteria.from(User.class);
      criteria.select(u);
      Predicate predicate = cb.equal(u.get("id"), id);
      criteria.where(predicate);
      User result = em.createQuery(criteria).getSingleResult();
      em.remove(result);
      userTransaction.commit();
      return result;
    } catch (Exception ex) {
      try {
        userTransaction.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }
  }
}
