package com.cosbeni.demo.mobile;


import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;

@Templated("UserList.html#UserList")
public class UserList extends Composite {
  
  @PostConstruct
  public void init(){
    this.setVisible(false);
  }
      
  @AfterInitialization
  public void afterInit(){
    create();
    this.setVisible(true);
  }
    
  private native void create() /*-{
  $wnd.$("#UserList").page();
  }-*/;
  
}
