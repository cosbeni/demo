package com.cosbeni.demo.mobile.component;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.cosbeni.demo.mobile.i18n.Messages;
import com.cosbeni.demo.mobile.page.Pages;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.cosbeni.demo.shared.service.GroupService;
import com.cosbeni.demo.shared.service.UserService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.Transition;
import com.sksamuel.jqm4gwt.list.JQMList;
import com.sksamuel.jqm4gwt.list.JQMListItem;


@Templated("Template.html#RemoteUserList")
public class RemoteUserList extends Composite {
  
  final String serverPath = "/demo-server/rest";
  
  @Inject
  EntityManager em;

  @Inject
  private Caller<UserService> userService;
  
  @Inject
  private Caller<GroupService> groupService;
  
  @DataField
  private HTMLPanel content = new HTMLPanel("");
    
  @Inject
  private JQMList formattedList;
  
  @DataField
  private AnchorElement upload = Document.get().createAnchorElement();

  @DataField
  private AnchorElement localWin = Document.get().createAnchorElement();

  @DataField
  private AnchorElement serverWin = Document.get().createAnchorElement();

  @DataField
  private AnchorElement group = Document.get().createAnchorElement();
  
  @Inject
  private Pages pages;
  
  private DemoConstants demoConstants;
  
  private Messages messages;

  @PostConstruct
  public void init() {
    demoConstants = GWT.create(DemoConstants.class);
    messages = GWT.create(Messages.class);
    upload.setInnerText(demoConstants.upload());    
    localWin.setInnerText(demoConstants.localWin());
    serverWin.setInnerText(demoConstants.serverWin());
    group.setInnerText(demoConstants.group());
    content.add(formattedList);    
  }

  public void fetchUsers() {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    userService.call(userUsers).getUsers();
  }
  
  final private RemoteCallback<List<User>> userUsers = new RemoteCallback<List<User>>() {
    @Override
    public void callback(List<User> result) {
      formattedList.clear();
      for (User user : result) {
        final JQMListItem item = new JQMListItem(user.getUserName());
        formattedList.addItem(formattedList.getItems().size(), item);
        item.addText(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
      }
      formattedList.refresh();
    }
  };
  
  @EventHandler("upload")
  public void upload(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);                    
    TypedQuery<User> query = em.createNamedQuery("adds", User.class);
    List<User> users = query.getResultList();
    for (User u : users) {
      userService.call(userAdd).add(u);
    }
    query = em.createNamedQuery("updates", User.class);
    users = query.getResultList();
    for (User u : users) {
      if (u.getRid() == 0)
        userService.call(userAdd).add(u);
      else
        userService.call(userUpdate).update(u);
    }
    query = em.createNamedQuery("deletes", User.class);
    users = query.getResultList();
    for (User u : users) {
      if (u.getRid() == 0)
        em.remove(u);
      else {
        userService.call(userDelete).delete(u);
      }
    }
    Common.setAttribute("Message", messages.uploadFinished());
    JQMContext.changePage(pages.getConfirmDialog(), Transition.FLIP);        
  }

  final private RemoteCallback<User> userAdd = new RemoteCallback<User>() {
    @Override
    public void callback(User result) {
      if (result != null) {
        User u = em.find(User.class, result.getRid());
        u.setRid(result.getId());
        em.flush();
        fetchUsers();
      }
    }
  };

  final private RemoteCallback<User> userUpdate = new RemoteCallback<User>() {
    @Override
    public void callback(User result) {
      fetchUsers();
    }
  };

  final private RemoteCallback<User> userDelete = new RemoteCallback<User>() {
    @Override
    public void callback(User result) {
      if (result != null) {
        User u = em.find(User.class, result.getRid());
        em.remove(u);
        em.flush();
        fetchUsers();
      }
    }
  };

  @EventHandler("localWin")
  public void localWin(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);          
    userService.call(pullUserLocalPreserve).getUsers();
    Common.setAttribute("Message", messages.userDataUpdated());
    JQMContext.changePage(pages.getConfirmDialog(), Transition.FLIP);    
  }

  final private RemoteCallback<List<User>> pullUserLocalPreserve = new RemoteCallback<List<User>>() {
    @Override
    public void callback(List<User> remoteData) {
      List<User> localData = em.createNamedQuery("rids", User.class).getResultList();
      List<Long> localRids = new ArrayList<Long>();
      for (User lu : localData) {
        localRids.add(lu.getRid());
      }
      for (User ru : remoteData) {
        if (!localRids.contains(ru.getId())) {
          ru.setRid(ru.getId());
          ru.setId(0L);
          Group g = em.find(Group.class, ru.getGroup().getId());
          ru.setGroup(g);
          em.persist(ru);
        }
      }
      fetchUsers();
    }
  };

  @EventHandler("serverWin")
  public void serverWin(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);          
    userService.call(pullUserLocalOverwrite).getUsers();
    Common.setAttribute("Message", messages.userDataUpdated());
    JQMContext.changePage(pages.getConfirmDialog(), Transition.FLIP);
  }
  
  final private RemoteCallback<List<User>> pullUserLocalOverwrite = new RemoteCallback<List<User>>() {
    @Override
    public void callback(List<User> remoteData) {
      List<User> localData = em.createNamedQuery("rids", User.class).getResultList();
      for (User lu : localData) {
        em.remove(lu);
      }
      for (User ru : remoteData) {
        ru.setRid(ru.getId());
        ru.setId(0L);
        Group g = em.find(Group.class, ru.getGroup().getId());
        ru.setGroup(g);
        em.persist(ru);
      }
      em.flush();
      fetchUsers();
    }
  };
  
  @EventHandler("group")
  public void group(ClickEvent e) {
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);          
    groupService.call(groupGroups).getGroups();    
    Common.setAttribute("Message", messages.groupDataUpdated());
    JQMContext.changePage(pages.getConfirmDialog(), Transition.FLIP);
  }

  final private RemoteCallback<List<Group>> groupGroups = new RemoteCallback<List<Group>>() {
    @Override
    public void callback(List<Group> result) {
      TypedQuery<Group> query = em.createNamedQuery("groups", Group.class);
      List<Group> local = query.getResultList();
      for (Group g : local) {
        em.remove(g);
      }
      for (Group g : result) {
        em.persist(g);
      }
    }
  };
  
}
