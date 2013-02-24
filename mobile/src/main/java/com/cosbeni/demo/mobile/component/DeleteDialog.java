package com.cosbeni.demo.mobile.component;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.cosbeni.demo.mobile.i18n.Messages;
import com.cosbeni.demo.mobile.page.Pages;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.Transition;
import com.sksamuel.jqm4gwt.list.JQMList;

@Templated("Template.html#DeleteDialog")
public class DeleteDialog extends Composite {

  @Inject
  EntityManager em;

  @DataField
  private HeadingElement message = Document.get().createHElement(1);

  @DataField
  private AnchorElement deleteConfirm = Document.get().createAnchorElement();

  @DataField
  private AnchorElement deleteCancel = Document.get().createAnchorElement();

  @Inject
  private Pages pages;

  private Messages messages;

  private User user = new User();

  @PostConstruct
  public void init() {
    messages = GWT.create(Messages.class);
  }

  public void refresh() {
    Object userId = Common.getAttribute("UserId");
    if (userId != null) {
      user = em.find(User.class, userId);
      em.detach(user);
    }
    message.setInnerText(messages.deleteConfirm(user.getUserName()));
  }

  @EventHandler("deleteConfirm")
  public void confirm(ClickEvent e) {
    Object userId = Common.getAttribute("UserId");
    if (userId != null) {
      user = em.find(User.class, userId);
      user.setCommand("DELETE");
      user.setFlag(false);
      if (user.getRid() == 0) {
        em.remove(user);
      } else {
        em.flush();
      }
      em.detach(user);
    }
    JQMContext.changePage(pages.getUserListPage(), Transition.FLIP);
  }

  @EventHandler("deleteCancel")
  public void cancel(ClickEvent e) {
    JQMContext.changePage(pages.getUserFormPage(), Transition.FLIP);
  }
  
}
