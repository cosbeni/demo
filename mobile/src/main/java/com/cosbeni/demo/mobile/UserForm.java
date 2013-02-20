package com.cosbeni.demo.mobile;


import javax.annotation.PostConstruct;

import org.jboss.errai.ioc.client.api.AfterInitialization;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.nav.client.local.PageShowing;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;

@Templated("UserForm.html#UserForm")
public class UserForm extends Composite {
 
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
  $wnd.$("#UserForm").page();
  }-*/;
}
