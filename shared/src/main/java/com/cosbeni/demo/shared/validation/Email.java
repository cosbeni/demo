package com.cosbeni.demo.shared.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Takahiro Imata <imata@cosbeni.co.jp>
 */
@Target( { METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = GwtCompatibleEmailValidator.class)
public @interface Email {
  
  String message() default "{com.cosbeni.common.validator.constraints.email.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
