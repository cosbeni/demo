package com.cosbeni.demo.mobile.component;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.page.Pages;
import com.cosbeni.demo.shared.entity.User;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.Transition;
import com.sksamuel.jqm4gwt.list.JQMList;


@Templated("Template.html#UserList")
public class UserList extends Composite {

  @Inject
  EntityManager em;

  @DataField
  private HTMLPanel content = new HTMLPanel("");
  
  @Inject
  private Pages pages;
  
  @Inject
  private JQMList formattedList;

  @PostConstruct
  public void init() {
    content.add(formattedList);    
  }

  public void fetchUsers() {
    TypedQuery<User> query = em.createNamedQuery("users", User.class);
    List<User> result = query.getResultList();
    formattedList.clear();
    for (User user : result) {
      final UserListItem item = new UserListItem(user.getUserName(),"#UserFormPage",user.getId());
      formattedList.addItem(formattedList.getItems().size(), item);
      item.addText(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
      item.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          Common.setAttribute("UserId", item.getUserId());
          JQMContext.changePage(pages.getUserFormPage(), Transition.FLIP);
        }
      });
    }
    formattedList.refresh();
  }
  
}
