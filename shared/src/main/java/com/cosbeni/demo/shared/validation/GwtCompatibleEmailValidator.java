package com.cosbeni.demo.shared.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.gwt.regexp.shared.RegExp;

/**
 *
 * @author Takahiro Imata <imata@cosbeni.co.jp>
 */
public class GwtCompatibleEmailValidator implements ConstraintValidator<Email, String> {

  private static String ATOM = "[a-z0-9!#$%&'*+/=?^_`{|}~-]";
  private static String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";
  private static String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";

  private RegExp pattern = RegExp.compile(
      "^" + ATOM + "+(\\." + ATOM + "+)*@"
          + DOMAIN
          + "|"
          + IP_DOMAIN
          + ")$",
          "i"
      );

  @Override
  public void initialize(Email constraintAnnotation) {
    // no op
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if ( value == null || value.length() == 0 ) {
      return true;
    }
    return pattern.test( value );
  }

}
