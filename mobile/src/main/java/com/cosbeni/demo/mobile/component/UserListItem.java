package com.cosbeni.demo.mobile.component;

import com.sksamuel.jqm4gwt.list.JQMListItem;

public class UserListItem extends JQMListItem {

  public UserListItem(String text, String url, Long userId) {
    super(text, url);
    this.userId = userId;
  }

  private Long userId;

  public Long getUserId() {
    return userId;
  }

}
