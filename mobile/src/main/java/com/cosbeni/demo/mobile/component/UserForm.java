package com.cosbeni.demo.mobile.component;

import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.sksamuel.jqm4gwt.form.elements.JQMSelect;

@Templated("Template.html#UserForm")
public class UserForm extends Composite {

  @Inject
  EntityManager em;

  @Inject
  @DataField
  private TextBox id;

  @DataField
  private LabelElement idLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private TextBox rid;

  @DataField
  private LabelElement ridLabel = DOM.createLabel().cast();

  @Inject
  @DataField
  private TextBox userName;

  @DataField
  private LabelElement userNameLabel = DOM.createLabel().cast();

  @DataField
  private LabelElement userNameMessage = DOM.createLabel().cast();

  @Inject
  @DataField
  private TextBox password;

  @DataField
  private LabelElement passwordLabel = DOM.createLabel().cast();

  @DataField
  private LabelElement passwordMessage = DOM.createLabel().cast();

  @Inject
  @DataField
  private TextBox firstName;

  @DataField
  private LabelElement firstNameLabel = DOM.createLabel().cast();

  @DataField
  private LabelElement firstNameMessage = DOM.createLabel().cast();

  @Inject
  @DataField
  private TextBox lastName;

  @DataField
  private LabelElement lastNameLabel = DOM.createLabel().cast();

  @DataField
  private LabelElement lastNameMessage = DOM.createLabel().cast();

  @Inject
  @DataField
  private TextBox email;

  @DataField
  private LabelElement emailLabel = DOM.createLabel().cast();

  @DataField
  private LabelElement emailMessage = DOM.createLabel().cast();

  @DataField
  private JQMSelect group = new JQMSelect();

  @Inject
  @DataField
  private Label addBox;

  @DataField
  private AnchorElement add = Document.get().createAnchorElement();

  @Inject
  @DataField
  private Label updateBox;

  @DataField
  private AnchorElement update = Document.get().createAnchorElement();

  @DataField
  private AnchorElement delete = Document.get().createAnchorElement();

  @DataField
  private AnchorElement cancel = Document.get().createAnchorElement();

  private DemoConstants demoConstants;

  private User user = new User();

  @PostConstruct
  public void init() {
    demoConstants = GWT.create(DemoConstants.class);
    add.setInnerHTML(demoConstants.add());
    addBox.setVisible(true);
    update.setInnerHTML(demoConstants.update());
    delete.setInnerHTML(demoConstants.delete());
    cancel.setInnerHTML(demoConstants.cancel());
    updateBox.setVisible(false);

    idLabel.setInnerText(demoConstants.id());
    ridLabel.setInnerText(demoConstants.rid());
    userNameLabel.setInnerText(demoConstants.userName());
    userNameMessage.setInnerText("");
    passwordLabel.setInnerText(demoConstants.password());
    firstNameLabel.setInnerText(demoConstants.firstName());
    firstNameMessage.setInnerText("");
    lastNameLabel.setInnerText(demoConstants.lastName());
    lastNameMessage.setInnerText("");
    emailLabel.setInnerText(demoConstants.email());
    emailMessage.setInnerText("");
    TypedQuery<Group> query = em.createNamedQuery("groups", Group.class);
    List<Group> groups = query.getResultList();
    for (Group g : groups) {
      group.addOption(g.getId().toString(),g.getGroupName());
    }
    group.setText(demoConstants.group());
  }

  public void refresh() {
    Object userId = Common.getAttribute("UserId");
    group = new JQMSelect();
    group.setText(demoConstants.group());
    TypedQuery<Group> query = em.createNamedQuery("groups", Group.class);
    List<Group> groups = query.getResultList();
    for (Group g : groups) {
      group.addOption(g.getId().toString(),g.getGroupName());
    }
    if (userId != null) {
      user = em.find(User.class, userId);
      em.detach(user);
      toWidget();
      addBox.setVisible(false);
      updateBox.setVisible(true);
    }
  }

  public void reset() {
    user = new User();
    toWidget();
    userNameMessage.setInnerText("");
    passwordMessage.setInnerText("");
    firstNameMessage.setInnerText("");
    lastNameMessage.setInnerText("");
    emailMessage.setInnerText("");
    addBox.setVisible(true);
    updateBox.setVisible(false);
  }

  public Boolean validation(User user) {
    Boolean violation = false;
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    for (ConstraintViolation<User> cv : violations) {
      String prop = cv.getPropertyPath().toString();
      if (prop.equals("userName")) {
        userNameMessage.setInnerText(cv.getMessage());
        violation = true;
      } else if (prop.equals("password")) {
        passwordMessage.setInnerText(cv.getMessage());
        violation = true;
      } else if (prop.equals("firstName")) {
        firstNameMessage.setInnerText(cv.getMessage());
        violation = true;
      } else if (prop.equals("lastName")) {
        lastNameMessage.setInnerText(cv.getMessage());
        violation = true;
      } else if (prop.equals("email")) {
        emailMessage.setInnerText(cv.getMessage());
        violation = true;
      }
    }
    return violation;
  }

  @EventHandler("add")
  public void add(ClickEvent e) {
    user = toUserValue(new User(), "ADD", true);
    if (!validation(user)) {
      TypedQuery<Group> query = em.createNamedQuery("groupById", Group.class);
      query.setParameter("id", user.getGroup().getId());
      Group result = query.getSingleResult();
      user.setGroup(result);
      em.persist(user);
      em.flush();
      em.detach(user);
      reset();
    }
  }

  @EventHandler("update")
  public void update(ClickEvent e) {
    if (!id.getValue().equals("")) {
      user = em.find(User.class, new Long(id.getValue()));
    }
    user = toUserValue(user, "UPDATE", true);
    if (!validation(user)) {
      em.flush();
      reset();
    }
    em.detach(user);
  }

  @EventHandler("delete")
  public void delete(ClickEvent e) {
  }

  @EventHandler("cancel")
  public void cancel(ClickEvent e) {
    reset();
  }

  public User toUserValue(User user, String command, Boolean flag) {
    user.setUserName(userName.getValue());
    user.setPassword(password.getValue());
    user.setFirstName(firstName.getValue());
    user.setLastName(lastName.getValue());
    user.setEmail(email.getValue());
    Group g = em.find(Group.class, new Long(group.getSelectedValue()));
    user.setGroup(g);
    user.setCommand(command);
    user.setFlag(flag);
    return user;
  }

  public void toWidget() {
    if (user.getId() != null) {
      id.setValue(user.getId().toString());
    } else {
      id.setValue("");
    }
    if (user.getRid() != null) {
      rid.setValue(user.getRid().toString());
    } else {
      rid.setValue("");
    }
    userName.setValue(user.getUserName());
    password.setValue(user.getPassword());
    firstName.setValue(user.getFirstName());
    lastName.setValue(user.getLastName());
    email.setValue(user.getEmail());
    if (user.getGroup() != null) {
      group.setSelectedValue(user.getGroup().getId().toString());
      group.refresh();
    }
  }
}
