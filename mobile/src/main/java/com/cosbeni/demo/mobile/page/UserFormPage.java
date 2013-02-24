package com.cosbeni.demo.mobile.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.component.UserForm;
import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.Transition;
import com.sksamuel.jqm4gwt.button.JQMButton;
import com.sksamuel.jqm4gwt.toolbar.JQMFooter;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;
import com.sksamuel.jqm4gwt.toolbar.JQMNavBar;

public class UserFormPage extends JQMPage {

  @Inject
  private UserForm userForm;
    
  @Inject
  private Pages pages;
  
  private DemoConstants demoConstants;

  public UserFormPage() {
    super("UserFormPage");    
  }

  @PostConstruct
  public void init() {
    demoConstants = GWT.create(DemoConstants.class);
    JQMHeader h = new JQMHeader(demoConstants.user());
    h.setBackButton(demoConstants.back());
    JQMButton newUser = new JQMButton(demoConstants.newUser());
    newUser.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          Common.removeAttribute("UserId");
          userForm.reset();
        }
      });
    h.setRightButton( newUser);
    add(h);
    JQMNavBar n = new JQMNavBar();
    n.add(new JQMButton(demoConstants.userList(),pages.getUserListPage()));
    n.add(new JQMButton(demoConstants.userInput(),pages.getUserFormPage()));
    n.add(new JQMButton(demoConstants.remote(), pages.getRemotePage()));    
    n.setDataRole("navbar");
    JQMFooter f = new JQMFooter(n);
    f.removeText();
    f.setFixed(true);
    add(f);
    add(userForm);
  }
  
  @Override
  protected void onPageBeforeShow() {
    Common.setAttribute("Page", pages.getUserFormPage());
    userForm.refresh();
  }

}
