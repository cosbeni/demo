package com.cosbeni.demo.mobile;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.Composite;

/**
 * 
 * @author Takahiro Imata <imata@cosbeni.co.jp>
 */

public class Common extends Composite {
    
  private static Common instance;
  private Map<String, Object> attributeMap = new HashMap<String, Object>();

  private Common(){
  }
  
  public static synchronized Common getInstance() {
    if( instance == null){
      instance = new Common();
    }
    return instance;
  }
  
  public static void setAttribute(String key, Object object){
    Common.getInstance().attributeMap.put(key, object);
  }
  
  public static Object getAttribute(String key){
    return Common.getInstance().attributeMap.get(key);
  }
  
  public static Object removeAttribute(String key){
    return Common.getInstance().attributeMap.remove(key);
  }
  
}
