package com.cosbeni.demo.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;
import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.TransitionTo;

import com.cosbeni.demo.client.i18n.DemoConstants;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main application entry point.
 */

@EntryPoint
public class App extends Composite {

  @Inject
  private Navigation navigation;
  
  @Inject
  private DashBoard dashBoard;
  
  @Inject
  private UserManagement userManagement;

  @Inject
  private GroupManagement groupManagement;
    
  @Inject
  private Language language;

  @Inject
  private Menu menu;
    
 private DemoConstants demoConstants;

  @PostConstruct
  public void init() {
    demoConstants = GWT.create(DemoConstants.class);
    RootPanel.get("MainLoading").setVisible(false);
    RootPanel.get("MainSpace").add(navigation.getContentPanel());
    RootPanel.get("MenuLoading").setVisible(false);
    RootPanel.get("MenuSpace").add(menu);
    RootPanel.get("LanguageLoading").setVisible(false);
    RootPanel.get("LanguageSpace").add(language);
  }

}
