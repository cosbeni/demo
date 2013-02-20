package com.cosbeni.demo.mobile;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ioc.client.api.EntryPoint;

import com.cosbeni.demo.mobile.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.sksamuel.jqm4gwt.Mobile;
import com.sksamuel.jqm4gwt.Transition;


/**
 * Main application entry point.
 */

@EntryPoint
public class App extends Composite {

  private DemoConstants demoConstants;
  
  @Inject 
  private UserList userList;
  
  @Inject
  private UserForm userForm;

  @PostConstruct
  public void init() {
    demoConstants = GWT.create(DemoConstants.class);
    RootPanel.get().add(userList);
    RootPanel.get().add(userForm);
  }
  
  @AfterInitialization
  public void afterInit(){
    changePage("#UserList", "flip");    
  }

  private native void changePage(String url, String t) /*-{
  $wnd.$.mobile.changePage(url, { transition: t } );
  }-*/;
  
}
