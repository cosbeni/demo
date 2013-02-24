package com.cosbeni.demo.mobile.page;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.cosbeni.demo.mobile.component.DeleteDialog;
import com.sksamuel.jqm4gwt.JQMPage;

public class DeleteDialogPage extends JQMPage {

  @Inject
  private DeleteDialog deleteDialog;

  public DeleteDialogPage() {
    super("DeleteDialog");
    setAttribute("data-role", "dialog");
  }

  @PostConstruct
  public void init() {
    add(deleteDialog);
  }

  @Override
  protected void onPageBeforeShow() {
    deleteDialog.refresh();
  }

}
