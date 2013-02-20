package org.jboss.errai.ui.nav.client.local.spi;

import com.cosbeni.demo.client.local.DashBoard;
import com.cosbeni.demo.client.local.GroupManagement;
import com.cosbeni.demo.client.local.UserManagement;
import org.jboss.errai.ui.nav.client.local.HistoryToken;

public class GeneratedNavigationGraph extends NavigationGraph {
  public GeneratedNavigationGraph() {
    pagesByName.put("UserManagement", new PageNode<UserManagement>() {
      public String name() {
        return "UserManagement";
      }

      public Class contentType() {
        return UserManagement.class;
      }

      public UserManagement content() {
        return bm.lookupBean(UserManagement.class).getInstance();
      }

      public native void _$251511937_unpreparePage(UserManagement instance) /*-{
        instance.@com.cosbeni.demo.client.local.UserManagement::unpreparePage()();
      }-*/;

      public void pageHiding(UserManagement widget) {
        _$251511937_unpreparePage(widget);
      }

      public native void _$251511937_preparePage(UserManagement instance) /*-{
        instance.@com.cosbeni.demo.client.local.UserManagement::preparePage()();
      }-*/;

      public void pageShowing(UserManagement widget, HistoryToken state) {
        _$251511937_preparePage(widget);
      }
    });
    final PageNode defaultPage = new PageNode<DashBoard>() {
      public String name() {
        return "DashBoard";
      }

      public Class contentType() {
        return DashBoard.class;
      }

      public DashBoard content() {
        return bm.lookupBean(DashBoard.class).getInstance();
      }

      public void pageHiding(DashBoard widget) {

      }

      public void pageShowing(DashBoard widget, HistoryToken state) {

      }
    };
    pagesByName.put("", defaultPage);
    pagesByName.put("DashBoard", defaultPage);
    pagesByName.put("GroupManagement", new PageNode<GroupManagement>() {
      public String name() {
        return "GroupManagement";
      }

      public Class contentType() {
        return GroupManagement.class;
      }

      public GroupManagement content() {
        return bm.lookupBean(GroupManagement.class).getInstance();
      }

      public native void _$1783685839_unpreparePage(GroupManagement instance) /*-{
        instance.@com.cosbeni.demo.client.local.GroupManagement::unpreparePage()();
      }-*/;

      public void pageHiding(GroupManagement widget) {
        _$1783685839_unpreparePage(widget);
      }

      public native void _$1783685839_preparePage(GroupManagement instance) /*-{
        instance.@com.cosbeni.demo.client.local.GroupManagement::preparePage()();
      }-*/;

      public void pageShowing(GroupManagement widget, HistoryToken state) {
        _$1783685839_preparePage(widget);
      }
    });
  }

}