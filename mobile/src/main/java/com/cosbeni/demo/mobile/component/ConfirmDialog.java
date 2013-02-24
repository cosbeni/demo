package com.cosbeni.demo.mobile.component;

import javax.annotation.PostConstruct;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.cosbeni.demo.mobile.Common;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Composite;
import com.sksamuel.jqm4gwt.JQMContainer;
import com.sksamuel.jqm4gwt.JQMContext;
import com.sksamuel.jqm4gwt.Transition;

@Templated("Template.html#ConfirmDialog")
public class ConfirmDialog extends Composite {

  @DataField
  private HeadingElement message = Document.get().createHElement(1);

  @DataField
  private AnchorElement confirm = Document.get().createAnchorElement();

  @PostConstruct
  public void init() {
  }

  public void refresh() {
    Object m = Common.getAttribute("Message");
    if (m != null) {
      message.setInnerText(m.toString());
    }
  }

  @EventHandler("confirm")
  public void confirm(ClickEvent e) {
    Object page = Common.getAttribute("Page");
    if (page != null) {
      JQMContext.changePage((JQMContainer) page, Transition.FLIP);
    }
  }

}
