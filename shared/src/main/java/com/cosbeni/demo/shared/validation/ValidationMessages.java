/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.cosbeni.demo.shared.validation;

/**
 * 
 * @author Takahiro Imata <imata@cosbeni.co.jp>
 */
public interface ValidationMessages extends
    com.google.gwt.i18n.client.ConstantsWithLookup {

  
  @DefaultStringValue("Confirm Password did not much with Password.")
  @Key("password.not.much.message")
  String password_not_much_message();
  
  @DefaultStringValue("Password must be at least {min} characters long.")
  @Key("password.min.size.message")
  String password_min_size_message();
  
  @DefaultStringValue("The field must be in email format.")
  @Key("email.message")
  String email_message();
  
  @DefaultStringValue("required field.")  
  @Key("required.message")
  String required_message();
  
  @DefaultStringValue("Your input did not much with captcha image.")  
  @Key("captcha.incorrect")
  String captcha_incorrect();

}
