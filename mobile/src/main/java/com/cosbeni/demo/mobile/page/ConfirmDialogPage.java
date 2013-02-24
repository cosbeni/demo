package com.cosbeni.demo.mobile.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.cosbeni.demo.mobile.component.ConfirmDialog;
import com.sksamuel.jqm4gwt.JQMPage;

public class ConfirmDialogPage extends JQMPage {

  @Inject
  private ConfirmDialog confirmDialog;

  public ConfirmDialogPage() {
    super("ConfirmDialog");
    setAttribute("data-role", "dialog");
  }

  @PostConstruct
  public void init() {
    add(confirmDialog);
  }

  @Override
  protected void onPageBeforeShow() {
    confirmDialog.refresh();
  }

}
