package com.cosbeni.demo.mobile;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ioc.client.api.EntryPoint;

import com.cosbeni.demo.mobile.page.Pages;
import com.sksamuel.jqm4gwt.JQMContext;

/**
 * Main application entry point.
 */
@EntryPoint
public class App {

  @Inject
  private Pages pages;

  @PostConstruct
  public void init() {
    JQMContext.changePage(pages.getUserListPage());
  }

}
