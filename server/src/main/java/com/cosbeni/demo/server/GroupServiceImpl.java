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

import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.service.GroupService;

@RequestScoped
public class GroupServiceImpl implements GroupService {

  @Inject
  private Logger log;

  @Inject
  private EntityManager em;

  @Inject
  private UserTransaction userTransaction;

  @Override
  public String add(Group group) {
    try {
      userTransaction.begin();
      em.persist(group);
      userTransaction.commit();
      return "OK";
    } catch (Exception ex) {
      try {
        userTransaction.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return "ERROR";
    }
  }

  @Override
  public String update(Group group) {
    try {
        userTransaction.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Group> criteria = cb.createQuery(Group.class);
        Root<Group> g = criteria.from(Group.class);
        criteria.select(g);
        Predicate predicate = cb.equal(g.get("id"), group.getId());
        criteria.where(predicate);
        Group result = em.createQuery(criteria).getSingleResult();
        result.setGroupName(group.getGroupName());
        result.setDescription(group.getDescription());
        userTransaction.commit();
      return "OK";
    } catch (Exception ex) {
      try {
        userTransaction.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return "ERROR";
    }
  }

  @Override
  public List<Group> getGroups() {
    try {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Group> criteria = cb.createQuery(Group.class);
      Root<Group> g = criteria.from(Group.class);
      criteria.select(g);
      List<Group> result = em.createQuery(criteria).getResultList();
      return result;
    } catch (NoResultException ex) {
      return null;
    } catch (Exception ex) {
      return null;
    }
  }

  @Override
  public Group getGroup(String id) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Group> criteria = cb.createQuery(Group.class);
    Root<Group> g = criteria.from(Group.class);
    criteria.select(g);
    Predicate predicate = cb.equal(g.get("id"), id);
    criteria.where(predicate);
    return em.createQuery(criteria).getSingleResult();
  }

  @Override
  public String delete(String id) {
    try {
      userTransaction.begin();
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<Group> criteria = cb.createQuery(Group.class);
      Root<Group> g = criteria.from(Group.class);
      criteria.select(g);
      Predicate predicate = cb.equal(g.get("id"), id);
      criteria.where(predicate);
      Group result = em.createQuery(criteria).getSingleResult();
      em.remove(result);
      userTransaction.commit();
      return "OK";
    } catch (Exception ex) {
      try {
        userTransaction.rollback();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return "ERROR";
    }
  }
}
