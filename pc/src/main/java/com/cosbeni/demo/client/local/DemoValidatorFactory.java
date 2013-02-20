package com.cosbeni.demo.client.local;

import javax.validation.Validator;
import javax.validation.groups.Default;

import com.cosbeni.demo.shared.entity.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;

/**
 * 
 * @author Takahiro Imata <imata@cosbeni.co.jp>
 */
public final class DemoValidatorFactory extends AbstractGwtValidatorFactory {

  @GwtValidation(value = {User.class}, groups = {Default.class})
  public interface GwtValidator extends Validator {
  }

  @Override
  public AbstractGwtValidator createValidator() {
    return GWT.create(GwtValidator.class);
  }
  
}