package com.cosbeni.demo.mobile.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.cosbeni.demo.mobile.Common;
import com.cosbeni.demo.mobile.component.RemoteUserList;
import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.button.JQMButton;
import com.sksamuel.jqm4gwt.toolbar.JQMFooter;
import com.sksamuel.jqm4gwt.toolbar.JQMHeader;
import com.sksamuel.jqm4gwt.toolbar.JQMNavBar;

public class RemotePage extends JQMPage {

  @Inject
  private RemoteUserList remoteUserList;
  
  private JQMHeader h = new JQMHeader("");

  @Inject
  private Pages pages;

  private DemoConstants demoConstants;

  public RemotePage() {
    super("RemotePage");
  }

  @PostConstruct
  public void init() {
    demoConstants = GWT.create(DemoConstants.class);     
    h.setText(demoConstants.remote());
    add(h);
    JQMNavBar fn = new JQMNavBar();
    fn.add(new JQMButton(demoConstants.userList(), pages.getUserListPage()));
    fn.add(new JQMButton(demoConstants.userInput(), pages.getUserFormPage()));
    fn.add(new JQMButton(demoConstants.remote(), pages.getRemotePage()));
    fn.setDataRole("navbar");
    JQMFooter f = new JQMFooter(fn);
    f.removeText();
    f.setFixed(true);
    add(f);
    add(remoteUserList);
  }

  @Override
  protected void onPageBeforeShow() {
    Common.setAttribute("Page", pages.getRemotePage());
    remoteUserList.fetchUsers();
  }
  
}
