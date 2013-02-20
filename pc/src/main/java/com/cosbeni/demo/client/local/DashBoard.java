package com.cosbeni.demo.client.local;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Page;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main application entry point.
 */
@Page(startingPage = true)
@Templated("#DashBoard")
public class DashBoard extends Composite {

  @DataField
  private SpanElement language = Document.get().createSpanElement();

  @DataField
  private SpanElement menu = Document.get().createSpanElement();

  @DataField
  private SpanElement main = Document.get().createSpanElement();

  @PostConstruct
  public void init() {

  }

  @EventHandler("language")
  public void language(MouseOverEvent e) {
    RootPanel.get("LanguageSpace").getWidget(0).addStyleName("alert-error");
  }
  
  @EventHandler("language")
  public void language(MouseOutEvent e) {
    RootPanel.get("LanguageSpace").getWidget(0).removeStyleName("alert-error");
  }
  
  @EventHandler("menu")
  public void menu(MouseOverEvent e) {
    RootPanel.get("MenuSpace").getWidget(0).addStyleName("alert-error");
  }
  
  @EventHandler("menu")
  public void menu(MouseOutEvent e) {
    RootPanel.get("MenuSpace").getWidget(0).removeStyleName("alert-error");
  }

  @EventHandler("main")
  public void main(MouseOverEvent e) {
    RootPanel.get("MainSpace").getWidget(0).addStyleName("alert-error");
  }
  
  @EventHandler("main")
  public void main(MouseOutEvent e) {
    RootPanel.get("MainSpace").getWidget(0).removeStyleName("alert-error");
  }
  
}
