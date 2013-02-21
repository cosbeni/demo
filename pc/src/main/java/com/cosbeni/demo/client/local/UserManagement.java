package com.cosbeni.demo.client.local;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.Caller;

import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageHiding;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.client.data.UserClientDS;
import com.cosbeni.demo.client.data.UserRecord;
import com.cosbeni.demo.client.data.UserServerDS;
import com.cosbeni.demo.client.i18n.DemoConstants;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.cosbeni.demo.shared.service.GroupService;
import com.cosbeni.demo.shared.service.UserService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.ListDataProvider;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;

/**
 * Main application entry point.
 */

@Page
@Templated("#UserManagement")
public class UserManagement extends Composite {

  final String serverPath = "/demo-server/rest";

  @Inject
  EntityManager em;

  @Inject
  private Caller<UserService> userService;

  @Inject
  private Caller<GroupService> groupService;

  @DataField
  ListGrid usersClientTable = new ListGrid();

  @DataField
  ListGrid usersServerTable = new ListGrid();

  private ListDataProvider<User> dataProvider = new ListDataProvider<User>();

  @Inject
  @DataField
  private Label userBox;

  @Inject
  @DataField
  private Label info;

  @DataField
  private HeadingElement infoMessage = Document.get().createHElement(4);

  @Inject
  @DataField
  private Label alert;

  @DataField
  private HeadingElement alertMessage = Document.get().createHElement(4);

  @Inject
  @DataField
  private Label idBox;

  @DataField
  private LabelElement id = DOM.createLabel().cast();

  @DataField
  private LabelElement idLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private Label ridBox;

  @DataField
  private LabelElement rid = DOM.createLabel().cast();

  @DataField
  private LabelElement ridLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private Label userNameBox;

  @Inject
  @DataField
  private TextBox userName;

  @DataField
  private LabelElement userNameLabel = DOM.createLabel().cast();

  @DataField
  private SpanElement userNameMessage = DOM.createSpan().cast();

  @Inject
  @DataField
  private Label passwordBox;

  @Inject
  @DataField
  private TextBox password;

  @DataField
  private LabelElement passwordLabel = DOM.createLabel().cast();
  
  @DataField
  private SpanElement passwordMessage = DOM.createSpan().cast();

  @Inject
  @DataField
  private Label firstNameBox;

  @Inject
  @DataField
  private TextBox firstName;

  @DataField
  private LabelElement firstNameLabel = DOM.createLabel().cast();

  @DataField
  private SpanElement firstNameMessage = DOM.createSpan().cast();

  @Inject
  @DataField
  private Label lastNameBox;

  @Inject
  @DataField
  private TextBox lastName;

  @DataField
  private LabelElement lastNameLabel = DOM.createLabel().cast();

  @DataField
  private SpanElement lastNameMessage = DOM.createSpan().cast();

  @Inject
  @DataField
  private Label emailBox;

  @Inject
  @DataField
  private TextBox email;

  @DataField
  private LabelElement emailLabel = DOM.createLabel().cast();

  @DataField
  private SpanElement emailMessage = DOM.createSpan().cast();

  @Inject
  @DataField
  private Label groupBox;

  @Inject
  @DataField
  private ListBox group;

  @DataField
  private LabelElement groupLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private Button add;

  @Inject
  @DataField
  private Button update;

  @Inject
  @DataField
  private Button delete;

  @Inject
  @DataField
  private Button cancel;

  @Inject
  @DataField
  private Button deleteConfirm;

  @Inject
  @DataField
  private Button deleteCancel;

  @Inject
  @DataField
  private Button pullGroup;

  @Inject
  @DataField
  private Button pushUser;

  @Inject
  @DataField
  private Button pullUser;

  private DemoConstants demoConstants;

  private User user = new User();

  @PageShowing
  private void preparePage() {
    demoConstants = GWT.create(DemoConstants.class);
    userBox.setVisible(true);
    add.setText(demoConstants.add());
    add.setVisible(true);
    update.setText(demoConstants.update());
    update.setVisible(false);
    delete.setText(demoConstants.delete());
    delete.setVisible(false);
    cancel.setText(demoConstants.cancel());
    cancel.setVisible(false);
    deleteConfirm.setText(demoConstants.delete());
    deleteConfirm.setVisible(true);
    alert.setVisible(false);
    info.setVisible(false);

    idLabel.setInnerText(demoConstants.id());
    userNameLabel.setInnerText(demoConstants.userName());
    userNameMessage.setInnerText("");
    passwordLabel.setInnerText(demoConstants.password());
    firstNameLabel.setInnerText(demoConstants.firstName());
    firstNameMessage.setInnerText("");
    lastNameLabel.setInnerText(demoConstants.lastName());
    lastNameMessage.setInnerText("");
    emailLabel.setInnerText(demoConstants.email());
    emailMessage.setInnerText("");
    groupLabel.setInnerText(demoConstants.group());
    usersClientTable.setWidth(570);
    usersClientTable.setHeight(400);
    usersClientTable.setShowFilterEditor(true);
    usersClientTable.setFilterOnKeypress(true);
    usersClientTable.addSelectionChangedHandler(new SelectionChangedHandler() {
      public void onSelectionChanged(SelectionEvent event) {
        UserRecord u = (UserRecord) usersClientTable.getSelectedRecord();
        if (u != null) {
          user = u.getUser();
          toWidget();
          add.setVisible(false);
          update.setVisible(true);
          delete.setVisible(true);
          cancel.setVisible(true);
        }
      }
    });

    usersServerTable.setWidth(570);
    usersServerTable.setHeight(400);
    usersServerTable.setShowFilterEditor(true);
    usersServerTable.setFilterOnKeypress(true);
    fetchUsers();
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    userService.call(userUsers).getUsers();
    TypedQuery<Group> query = em.createNamedQuery("groups", Group.class);
    List<Group> groups = query.getResultList();
    for (Group g : groups) {
      group.addItem(g.getGroupName(), g.getId().toString());
    }

  }

  @PageHiding
  private void unpreparePage() {
  }

  final private RemoteCallback<List<User>> userUsers = new RemoteCallback<List<User>>() {
    @Override
    public void callback(List<User> result) {
      ArrayList<UserRecord> users = new ArrayList<UserRecord>();
      for (User u : result) {
        users.add(new UserRecord(u));
      }
      UserServerDS.getInstance().setTestData(users.toArray(new UserRecord[users.size()]));
      usersServerTable.setDataSource(UserServerDS.getInstance());
      usersServerTable.fetchData();
    }
  };

  public void fetchUsers() {
    TypedQuery<User> query = em.createNamedQuery("users", User.class);
    List<User> result = query.getResultList();
    ArrayList<UserRecord> users = new ArrayList<UserRecord>();
    for (User u : result) {
      users.add(new UserRecord(u));
    }
    UserClientDS.getInstance().setTestData(users.toArray(new UserRecord[users.size()]));
    usersClientTable.setDataSource(UserClientDS.getInstance());
    usersClientTable.fetchData();
  }

  @EventHandler("add")
  public void add(ClickEvent e) {
    user = toUserValue(new User(), "ADD", true);
    Boolean violation = false;
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    for (ConstraintViolation<User> cv : violations) {
      String prop = cv.getPropertyPath().toString();
      if (prop.equals("userName")) {
        userNameMessage.setInnerText(cv.getMessage());
        userNameBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("password")) {
        passwordMessage.setInnerText(cv.getMessage());
        passwordBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("firstName")) {
        firstNameMessage.setInnerText(cv.getMessage());
        firstNameBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("lastName")) {
        lastNameMessage.setInnerText(cv.getMessage());
        lastNameBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("email")) {
        emailMessage.setInnerText(cv.getMessage());
        emailBox.addStyleName("error");
        violation = true;
      }
    }

    if (violation == false) {
      TypedQuery<Group> query = em.createNamedQuery("groupById", Group.class);
      query.setParameter("id", user.getGroup().getId());
      Group result = query.getSingleResult();
      user.setGroup(result);
      em.persist(user);
      em.flush();
      em.detach(user);
      fetchUsers();
    }
  }

  @EventHandler("update")
  public void update(ClickEvent e) {
    if (!id.getInnerText().equals("")) {
      user = em.find(User.class, new Long(id.getInnerText()));
    }
    user = toUserValue(user, "UPDATE", true);
    Boolean violation = false;
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    for (ConstraintViolation<User> cv : violations) {
      String prop = cv.getPropertyPath().toString();
      if (prop.equals("userName")) {
        userNameMessage.setInnerText(cv.getMessage());
        userNameBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("firstName")) {
        firstNameMessage.setInnerText(cv.getMessage());
        firstNameBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("lastName")) {
        lastNameMessage.setInnerText(cv.getMessage());
        lastNameBox.addStyleName("error");
        violation = true;
      } else if (prop.equals("email")) {
        emailMessage.setInnerText(cv.getMessage());
        emailBox.addStyleName("error");
        violation = true;
      }
    }

    if (violation == false) {
      em.flush();
      fetchUsers();
    }
    em.detach(user);
  }

  @EventHandler("delete")
  public void delete(ClickEvent e) {
    userBox.setVisible(false);
    alert.setVisible(true);
  }

  @EventHandler("cancel")
  public void cancel(ClickEvent e) {
    user = new User();
    toWidget();
    userBox.setVisible(true);
    add.setVisible(true);
    update.setVisible(false);
    delete.setVisible(false);
    cancel.setVisible(false);
    alert.setVisible(false);
    info.setVisible(false);
  }

  @EventHandler("deleteConfirm")
  public void deleteConfirm(ClickEvent e) {
    if (!id.getInnerText().equals("")) {
      user = em.find(User.class, new Long(id.getInnerText()));
    }
    user = toUserValue(user, "DELETE", false);
    if (user.getRid() == 0) {
      em.remove(user);
    } else {
      em.flush();
      em.detach(user);
    }
    fetchUsers();
    user = new User();
    toWidget();
    userBox.setVisible(true);
    add.setVisible(true);
    update.setVisible(false);
    delete.setVisible(false);
    cancel.setVisible(false);
    alert.setVisible(false);
    info.setVisible(false);
  }

  @EventHandler("deleteCancel")
  public void deleteCancel(ClickEvent e) {
    user = new User();
    toWidget();
    userBox.setVisible(true);
    add.setVisible(true);
    update.setVisible(false);
    delete.setVisible(false);
    cancel.setVisible(false);
    alert.setVisible(false);
    info.setVisible(false);
  }

  @EventHandler("pullUser")
  public void pullUser(ClickEvent e) {
    userService.call(pullData).getUsers();
  }

  final private RemoteCallback<List<User>> pullData = new RemoteCallback<List<User>>() {
    @Override
    public void callback(List<User> remoteData) {
      List<User> localData = em.createNamedQuery("rids", User.class).getResultList();
      List<Long> localRids = new ArrayList<Long>();
      for (User user : localData) {
        localRids.add(user.getRid());
      }
      for (User user : remoteData) {
        if (!localRids.contains(user.getId())) {
          user.setRid(user.getId());
          user.setId(0L);
          Group group = em.find(Group.class, user.getGroup().getId());
          user.setGroup(group);
          em.persist(user);
        }
      }
      fetchUsers();
    }
  };

  @EventHandler("pushUser")
  public void pushUser(ClickEvent e) {
    TypedQuery<User> query = em.createNamedQuery("adds", User.class);
    List<User> users = query.getResultList();
    for (User user : users) {
      userService.call(userAdd).add(user);
    }
    query = em.createNamedQuery("updates", User.class);
    users = query.getResultList();
    for (User user : users) {
      if (user.getRid() == 0)
        userService.call(userAdd).add(user);
      else
        userService.call(userUpdate).update(user);
    }
    query = em.createNamedQuery("deletes", User.class);
    users = query.getResultList();
    for (User user : users) {
      if (user.getRid() == 0)
        em.remove(user);
      else {
        userService.call(userDelete).delete(user.getRid().toString());
      }
    }
    RestClient.setApplicationRoot(serverPath);
    RestClient.setJacksonMarshallingActive(false);
    userService.call(userUsers).getUsers();
  }

  final private RemoteCallback<User> userAdd = new RemoteCallback<User>() {
    @Override
    public void callback(User result) {
      if (result != null) {
        User user = em.find(User.class, result.getRid());
        user.setRid(result.getId());
        em.flush();
        fetchUsers();
      }
      
    }
  };

  final private RemoteCallback<User> userUpdate = new RemoteCallback<User>() {
    @Override
    public void callback(User result) {
    }
  };

  final private RemoteCallback<User> userDelete = new RemoteCallback<User>() {
    @Override
    public void callback(User result) {
      if (result != null) {
        User user = em.find(User.class, result.getRid());
        em.remove(user);
        em.flush();
      }
    }
  };

  @EventHandler("pullGroup")
  public void pullGroup(ClickEvent e) {
    groupService.call(groupGroups).getGroups();
  }

  final private RemoteCallback<List<Group>> groupGroups = new RemoteCallback<List<Group>>() {
    @Override
    public void callback(List<Group> result) {
      TypedQuery<Group> query = em.createNamedQuery("groups", Group.class);
      List<Group> local = query.getResultList();
      for (Group g : local) {
        em.remove(g);
      }
      while (group.getItemCount() != 0) {
        group.removeItem(0);
      }
      for (Group g : result) {
        group.addItem(g.getGroupName(), g.getId().toString());
        em.persist(g);
      }
    }
  };

  public User toUserValue(User user, String command, Boolean flag) {
    user.setUserName(userName.getValue());
    user.setPassword(password.getValue());
    user.setFirstName(firstName.getValue());
    user.setLastName(lastName.getValue());
    user.setEmail(email.getValue());
    Group g = em.find(Group.class, new Long(group.getValue(group.getSelectedIndex())));
    user.setGroup(g);
    user.setCommand(command);
    user.setFlag(flag);
    return user;
  }

  public void toWidget() {
    if (user.getId() != null) {
      id.setInnerText(user.getId().toString());
    } else {
      id.setInnerText("");
    }
    userName.setValue(user.getUserName());
    firstName.setValue(user.getFirstName());
    lastName.setValue(user.getLastName());
    email.setValue(user.getEmail());
    if (user.getGroup() != null) {
      for (int i = 0; i <= group.getItemCount(); i++) {
        if (group.getValue(i).equals(user.getGroup().getId().toString())) {
          group.setItemSelected(i, true);
          break;
        }
      }
    }
  }

}
