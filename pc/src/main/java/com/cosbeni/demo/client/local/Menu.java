package com.cosbeni.demo.client.local;


import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.client.i18n.DemoConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

/**
 * Menu
 */
@Templated("Main.html#Menu")
public class Menu extends Composite {
    
  @DataField
  private LIElement userPage = Document.get().createLIElement();

  @DataField
  private AnchorElement userAnchor = Document.get().createAnchorElement();

  @DataField
  private LIElement groupPage = Document.get().createLIElement();

  @DataField
  private AnchorElement groupAnchor = Document.get().createAnchorElement();
  
  @DataField
  private LIElement mobilePage = Document.get().createLIElement();

  @DataField
  private AnchorElement mobileAnchor = Document.get().createAnchorElement();
  
  @Inject
  TransitionTo<UserManagement> transitionUser;

  @Inject
  TransitionTo<GroupManagement> transitionGroup;
  
  
  private DemoConstants demoConstants;
  
  @PostConstruct
  public void init() {  
    demoConstants = GWT.create(DemoConstants.class);
    userAnchor.setInnerText(demoConstants.user());
    groupAnchor.setInnerText(demoConstants.group());
  }
  
  @EventHandler("userPage")
  public void userPage(ClickEvent e) {
    userPage.setClassName("active");
    transitionUser.go();
  }
  
  @EventHandler("groupPage")
  public void groupPage(ClickEvent e) {
    groupPage.setClassName("active");
    transitionGroup.go();
  }
  
  @EventHandler("mobilePage")
  public void phonePage(ClickEvent e) {
    mobilePage.setClassName("active");
  }
    
}
