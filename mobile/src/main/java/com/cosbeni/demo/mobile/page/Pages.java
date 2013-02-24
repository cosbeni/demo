package com.cosbeni.demo.mobile.page;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import com.google.gwt.user.client.ui.Composite;

@ApplicationScoped
public class Pages extends Composite {
 
  @Inject
  private UserListPage userListPage;
  
  @Inject
  private UserFormPage userFormPage;
  
  @Inject
  private RemotePage remotePage;
  
  @Inject 
  private ConfirmDialogPage confirmDialog;
  
  @Inject 
  private DeleteDialogPage deleteDialog;
  
  public UserListPage getUserListPage(){
    return userListPage;
  }
   
  public UserFormPage getUserFormPage(){
    return userFormPage;
  }

  public RemotePage getRemotePage(){
    return remotePage;
  }

  public ConfirmDialogPage getConfirmDialog(){
    return confirmDialog;
  }
  
  public DeleteDialogPage getDeleteDialog(){
    return deleteDialog;
  }
}
