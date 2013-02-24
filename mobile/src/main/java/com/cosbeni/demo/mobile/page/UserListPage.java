package com.cosbeni.demo.mobile.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.component.UserList;
import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.button.JQMButton;
import com.sksamuel.jqm4gwt.toolbar.JQMFooter;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;
import com.sksamuel.jqm4gwt.toolbar.JQMNavBar;

public class UserListPage extends JQMPage {

  @Inject
  private UserList userList;

  @Inject
  private Pages pages;

  private DemoConstants demoConstants;

  public UserListPage() {
    super("UserListPage");
  }

  @PostConstruct
  public void init() {    
    demoConstants = GWT.create(DemoConstants.class);
    JQMHeader h = new JQMHeader(demoConstants.userList());
    add(h);
    JQMNavBar n = new JQMNavBar();
    n.add(new JQMButton(demoConstants.userList(), pages.getUserListPage()));
    n.add(new JQMButton(demoConstants.userInput(), pages.getUserFormPage()));
    n.add(new JQMButton(demoConstants.remote(), pages.getRemotePage()));    
    n.setDataRole("navbar");
    JQMFooter f = new JQMFooter(n);
    f.removeText();
    f.setFixed(true);
    add(f);
    add(userList);
  }

  @Override
  protected void onPageBeforeShow() {
    Common.setAttribute("Page", pages.getUserListPage());
    userList.fetchUsers();
  }

}
