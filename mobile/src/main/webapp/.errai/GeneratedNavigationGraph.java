package org.jboss.errai.ui.nav.client.local.spi;

import com.cosbeni.demo.mobile.UserForm;
import com.cosbeni.demo.mobile.UserList;
import org.jboss.errai.ui.nav.client.local.HistoryToken;

public class GeneratedNavigationGraph extends NavigationGraph {
  public GeneratedNavigationGraph() {
    pagesByName.put("UserForm", new PageNode<UserForm>() {
      public String name() {
        return "UserForm";
      }

      public Class contentType() {
        return UserForm.class;
      }

      public UserForm content() {
        return bm.lookupBean(UserForm.class).getInstance();
      }

      public void pageHiding(UserForm widget) {

      }

      public native void _$561112730_init(UserForm instance) /*-{
        instance.@com.cosbeni.demo.mobile.UserForm::init()();
      }-*/;

      public void pageShowing(UserForm widget, HistoryToken state) {
        _$561112730_init(widget);
      }
    });
    final PageNode defaultPage = new PageNode<UserList>() {
      public String name() {
        return "UserList";
      }

      public Class contentType() {
        return UserList.class;
      }

      public UserList content() {
        return bm.lookupBean(UserList.class).getInstance();
      }

      public native void _$560939712_unpreparePage(UserList instance) /*-{
        instance.@com.cosbeni.demo.mobile.UserList::unpreparePage()();
      }-*/;

      public void pageHiding(UserList widget) {
        _$560939712_unpreparePage(widget);
      }

      public native void _$560939712_preparePage(UserList instance) /*-{
        instance.@com.cosbeni.demo.mobile.UserList::preparePage()();
      }-*/;

      public void pageShowing(UserList widget, HistoryToken state) {
        _$560939712_preparePage(widget);
      }
    };
    pagesByName.put("", defaultPage);
    pagesByName.put("UserList", defaultPage);
  }

}