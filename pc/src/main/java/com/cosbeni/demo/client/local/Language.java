package com.cosbeni.demo.client.local;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.ui.nav.client.local.Navigation;
import org.jboss.errai.ui.nav.client.local.TransitionTo;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

/**
 * Menu
 */
@Templated("Main.html#Language")
public class Language extends Composite {

  @DataField
  private AnchorElement english = DOM.createAnchor().cast();

  @DataField
  private AnchorElement japanese = DOM.createAnchor().cast();

  @DataField
  private AnchorElement indonesian = DOM.createAnchor().cast();

  String cookieName;

  String queryParam;

  String currentLocale;

  @PostConstruct
  public void init() {
    cookieName = LocaleInfo.getLocaleCookieName();
    queryParam = LocaleInfo.getLocaleQueryParam();
    if (cookieName == null && queryParam == null) {
      return;
    }
    currentLocale = LocaleInfo.getCurrentLocale().getLocaleName();
    if (currentLocale.equals("default")) {
      currentLocale = "en";
    }
  }

  @EventHandler("english")
  public void english(ClickEvent e) {
    if (cookieName != null) {
      Date expires = new Date();
      expires.setYear(expires.getYear() + 1);
      Cookies.setCookie(cookieName, "en", expires);
    }
    if (queryParam != null) {
      UrlBuilder builder = Location.createUrlBuilder().setParameter(queryParam, "en");
      Window.Location.replace(builder.buildString());
    } else {
      Window.Location.reload();
    }
  }

  @EventHandler("japanese")
  public void japanese(ClickEvent e) {
    if (cookieName != null) {
      Date expires = new Date();
      expires.setYear(expires.getYear() + 1);
      Cookies.setCookie(cookieName, "ja", expires);
    }
    if (queryParam != null) {
      UrlBuilder builder = Location.createUrlBuilder().setParameter(queryParam, "ja");
      Window.Location.replace(builder.buildString());
    } else {
      Window.Location.reload();
    }
  }

  @EventHandler("indonesian")
  public void indonesian(ClickEvent e) {
    if (cookieName != null) {
      Date expires = new Date();
      expires.setYear(expires.getYear() + 1);
      Cookies.setCookie(cookieName, "in", expires);
    }
    if (queryParam != null) {
      UrlBuilder builder = Location.createUrlBuilder().setParameter(queryParam, "in");
      Window.Location.replace(builder.buildString());
    } else {
      Window.Location.reload();
    }
  }
}
