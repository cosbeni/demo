package org.jboss.errai.jpa.client.local;

import com.cosbeni.demo.shared.entity.Demo;
import com.cosbeni.demo.shared.entity.Group;
import com.cosbeni.demo.shared.entity.User;
import com.google.gwt.json.client.JSONObject;
import java.util.Comparator;
import java.util.Iterator;
import javax.persistence.CascadeType;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;
import javax.persistence.metamodel.Bindable.BindableType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Type;
import javax.persistence.metamodel.Type.PersistenceType;
import org.jboss.errai.common.client.api.WrappedPortable;
import org.jboss.errai.jpa.client.local.backend.Comparisons;

public class GeneratedErraiEntityManager extends ErraiEntityManager {
  protected void populateMetamodel() {
    // **
    // ** EntityType for com.cosbeni.demo.shared.entity.Demo
    // **
    final ErraiEntityType et_com_cosbeni_demo_shared_entity_Demo = new ErraiEntityType<Demo>("Demo", Demo.class) {
      public Demo newInstance() {
        return new Demo();
      }

      public void deliverPrePersist(Demo targetEntity) {

      }

      public void deliverPostPersist(Demo targetEntity) {

      }

      public void deliverPreUpdate(Demo targetEntity) {

      }

      public void deliverPostUpdate(Demo targetEntity) {

      }

      public void deliverPreRemove(Demo targetEntity) {

      }

      public void deliverPostRemove(Demo targetEntity) {

      }

      public void deliverPostLoad(Demo targetEntity) {

      }
    };
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389831430_data4(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::data4;
      }-*/;

      private native void _$1389831430_data4(Demo instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::data4 = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_data4((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "data4";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_data4((Demo) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private Iterator<Long> valueGenerator = new LongIdGenerator(GeneratedErraiEntityManager.this, this);
      private native Long _$1389831430_id(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::id;
      }-*/;

      private native void _$1389831430_id(Demo instance, Long value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::id = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_id((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return Long.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return Long.class;
      }
      public String getName() {
        return "id";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return Long.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        return valueGenerator;
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return true;
      }
      public boolean isId() {
        return true;
      }
      public boolean isOptional() {
        return false;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_id((Demo) arg0, (Long) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389831430_data1(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::data1;
      }-*/;

      private native void _$1389831430_data1(Demo instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::data1 = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_data1((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "data1";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_data1((Demo) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389831430_data2(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::data2;
      }-*/;

      private native void _$1389831430_data2(Demo instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::data2 = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_data2((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "data2";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_data2((Demo) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389831430_username(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::username;
      }-*/;

      private native void _$1389831430_username(Demo instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::username = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_username((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "username";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_username((Demo) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389831430_data5(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::data5;
      }-*/;

      private native void _$1389831430_data5(Demo instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::data5 = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_data5((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "data5";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_data5((Demo) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Demo.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389831430_data3(Demo instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Demo::data3;
      }-*/;

      private native void _$1389831430_data3(Demo instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Demo::data3 = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389831430_data3((Demo) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Demo;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "data3";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389831430_data3((Demo) arg0, (String) arg1);
      }
    });
    metamodel.addEntityType(et_com_cosbeni_demo_shared_entity_Demo);
    // **
    // ** EntityType for com.cosbeni.demo.shared.entity.User
    // **
    final ErraiEntityType et_com_cosbeni_demo_shared_entity_User = new ErraiEntityType<User>("User", User.class) {
      public User newInstance() {
        return new User();
      }

      public void deliverPrePersist(User targetEntity) {

      }

      public void deliverPostPersist(User targetEntity) {

      }

      public void deliverPreUpdate(User targetEntity) {

      }

      public void deliverPostUpdate(User targetEntity) {

      }

      public void deliverPreRemove(User targetEntity) {

      }

      public void deliverPostRemove(User targetEntity) {

      }

      public void deliverPostLoad(User targetEntity) {

      }
    };
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389311774_firstName(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::firstName;
      }-*/;

      private native void _$1389311774_firstName(User instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::firstName = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_firstName((User) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "firstName";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_firstName((User) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389311774_email(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::email;
      }-*/;

      private native void _$1389311774_email(User instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::email = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_email((User) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "email";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_email((User) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389311774_password(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::password;
      }-*/;

      private native void _$1389311774_password(User instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::password = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_password((User) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "password";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_password((User) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private Iterator<Long> valueGenerator = new LongIdGenerator(GeneratedErraiEntityManager.this, this);
      private native Long _$1389311774_id(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::id;
      }-*/;

      private native void _$1389311774_id(User instance, Long value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::id = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_id((User) arg0);
      }
      public Class getBindableJavaType() {
        return Long.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return Long.class;
      }
      public String getName() {
        return "id";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return Long.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        return valueGenerator;
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return true;
      }
      public boolean isId() {
        return true;
      }
      public boolean isOptional() {
        return false;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_id((User) arg0, (Long) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389311774_userName(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::userName;
      }-*/;

      private native void _$1389311774_userName(User instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::userName = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_userName((User) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "userName";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_userName((User) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389311774_command(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::command;
      }-*/;

      private native void _$1389311774_command(User instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::command = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_command((User) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "command";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_command((User) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native Boolean _$1389311774_flag(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::flag;
      }-*/;

      private native void _$1389311774_flag(User instance, Boolean value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::flag = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_flag((User) arg0);
      }
      public Class getBindableJavaType() {
        return Boolean.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return Boolean.class;
      }
      public String getName() {
        return "flag";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return Boolean.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_flag((User) arg0, (Boolean) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native String _$1389311774_lastName(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::lastName;
      }-*/;

      private native void _$1389311774_lastName(User instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::lastName = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_lastName((User) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "lastName";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_lastName((User) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native Group _$1389311774_group(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::group;
      }-*/;

      private native void _$1389311774_group(User instance, Group value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::group = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        return false;
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_group((User) arg0);
      }
      public Class getBindableJavaType() {
        return Group.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return Group.class;
      }
      public String getName() {
        return "group";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.MANY_TO_ONE;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return Group.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.ENTITY;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return true;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_group((User) arg0, (Group) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_User.addAttribute(new ErraiSingularAttribute() {
      private native Long _$1389311774_rid(User instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.User::rid;
      }-*/;

      private native void _$1389311774_rid(User instance, Long value) /*-{
        instance.@com.cosbeni.demo.shared.entity.User::rid = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$1389311774_rid((User) arg0);
      }
      public Class getBindableJavaType() {
        return Long.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_User;
      }
      public Class getJavaType() {
        return Long.class;
      }
      public String getName() {
        return "rid";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return Long.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$1389311774_rid((User) arg0, (Long) arg1);
      }
    });
    metamodel.addEntityType(et_com_cosbeni_demo_shared_entity_User);
    // **
    // ** EntityType for com.cosbeni.demo.shared.entity.Group
    // **
    final ErraiEntityType et_com_cosbeni_demo_shared_entity_Group = new ErraiEntityType<Group>("Group", Group.class) {
      public Group newInstance() {
        return new Group();
      }

      public void deliverPrePersist(Group targetEntity) {

      }

      public void deliverPostPersist(Group targetEntity) {

      }

      public void deliverPreUpdate(Group targetEntity) {

      }

      public void deliverPostUpdate(Group targetEntity) {

      }

      public void deliverPreRemove(Group targetEntity) {

      }

      public void deliverPostRemove(Group targetEntity) {

      }

      public void deliverPostLoad(Group targetEntity) {

      }
    };
    et_com_cosbeni_demo_shared_entity_Group.addAttribute(new ErraiSingularAttribute() {
      private native String _$131941304_groupName(Group instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Group::groupName;
      }-*/;

      private native void _$131941304_groupName(Group instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Group::groupName = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$131941304_groupName((Group) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Group;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "groupName";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$131941304_groupName((Group) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Group.addAttribute(new ErraiSingularAttribute() {
      private native String _$131941304_description(Group instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Group::description;
      }-*/;

      private native void _$131941304_description(Group instance, String value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Group::description = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$131941304_description((Group) arg0);
      }
      public Class getBindableJavaType() {
        return String.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Group;
      }
      public Class getJavaType() {
        return String.class;
      }
      public String getName() {
        return "description";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return String.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        throw new UnsupportedOperationException("Not a generated attribute");
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return false;
      }
      public boolean isId() {
        return false;
      }
      public boolean isOptional() {
        return true;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$131941304_description((Group) arg0, (String) arg1);
      }
    });
    et_com_cosbeni_demo_shared_entity_Group.addAttribute(new ErraiSingularAttribute() {
      private Iterator<Long> valueGenerator = new LongIdGenerator(GeneratedErraiEntityManager.this, this);
      private native Long _$131941304_id(Group instance) /*-{
        return instance.@com.cosbeni.demo.shared.entity.Group::id;
      }-*/;

      private native void _$131941304_id(Group instance, Long value) /*-{
        instance.@com.cosbeni.demo.shared.entity.Group::id = value;
      }-*/;
      public boolean cascades(CascadeType arg0) {
        throw new UnsupportedOperationException("Not a relationship attribute");
      }
      public Object get(Object arg0) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        return _$131941304_id((Group) arg0);
      }
      public Class getBindableJavaType() {
        return Long.class;
      }
      public BindableType getBindableType() {
        return BindableType.SINGULAR_ATTRIBUTE;
      }
      public ManagedType getDeclaringType() {
        return et_com_cosbeni_demo_shared_entity_Group;
      }
      public Class getJavaType() {
        return Long.class;
      }
      public String getName() {
        return "id";
      }
      public PersistentAttributeType getPersistentAttributeType() {
        return PersistentAttributeType.BASIC;
      }
      public Type getType() {
        return new Type() {
          public Class getJavaType() {
            return Long.class;
          }
          public PersistenceType getPersistenceType() {
            return PersistenceType.BASIC;
          }
        };
      }
      public Iterator getValueGenerator() {
        return valueGenerator;
      }
      public boolean isAssociation() {
        return false;
      }
      public boolean isCollection() {
        return false;
      }
      public boolean isGeneratedValue() {
        return true;
      }
      public boolean isId() {
        return true;
      }
      public boolean isOptional() {
        return false;
      }
      public boolean isVersion() {
        return false;
      }
      public void set(Object arg0, Object arg1) {
        if (arg0 instanceof WrappedPortable) {
          arg0 = ((WrappedPortable) arg0).unwrap();
        }
        _$131941304_id((Group) arg0, (Long) arg1);
      }
    });
    metamodel.addEntityType(et_com_cosbeni_demo_shared_entity_Group);
    metamodel.freeze();
  }

  protected void populateNamedQueries() {
    // **
    // ** NamedQuery "demos"
    // ** SELECT d FROM Demo d
    // **
    super.namedQueries.put("demos", new TypedQueryFactory(this, Demo.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return null;
          }
          public boolean matches(JSONObject candidate) {
            return true;
          }
        };
      }
    });
    // **
    // ** NamedQuery "demoById"
    // ** SELECT d FROM Demo d WHERE d.id = :id
    // **
    super.namedQueries.put("demoById", new TypedQueryFactory(this, Demo.class, new ErraiParameter[] { new ErraiParameter("id", 0, Long.class) }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return null;
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeEquals(JsonUtil.basicValueFromJson(candidate.get("id"), Long.class), getParameterValue("id"));
          }
        };
      }
    });
    // **
    // ** NamedQuery "groups"
    // ** SELECT g FROM Group g
    // **
    super.namedQueries.put("groups", new TypedQueryFactory(this, Group.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return null;
          }
          public boolean matches(JSONObject candidate) {
            return true;
          }
        };
      }
    });
    // **
    // ** NamedQuery "groupById"
    // ** SELECT g FROM Group g WHERE g.id = :id
    // **
    super.namedQueries.put("groupById", new TypedQueryFactory(this, Group.class, new ErraiParameter[] { new ErraiParameter("id", 0, Long.class) }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return null;
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeEquals(JsonUtil.basicValueFromJson(candidate.get("id"), Long.class), getParameterValue("id"));
          }
        };
      }
    });
    // **
    // ** NamedQuery "users"
    // ** SELECT u FROM User u WHERE u.flag = true ORDER BY u.id
    // **
    super.namedQueries.put("users", new TypedQueryFactory(this, User.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return new Comparator() {
              private final ErraiAttribute u_id_attr = getMetamodel().entity(User.class).getAttribute("id");
              public int compare(Object o1, Object o2) {
                final User lhs = (User) o1;
                final User rhs = (User) o2;
                int result;
                result = Comparisons.nullSafeCompare((Comparable) u_id_attr.get(lhs), (Comparable) u_id_attr.get(rhs));
                if (result != 0) {
                  return + result;
                }
                return 0;
              }
            };
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeEquals(JsonUtil.basicValueFromJson(candidate.get("flag"), Boolean.class), true);
          }
        };
      }
    });
    // **
    // ** NamedQuery "rids"
    // ** SELECT u FROM User u WHERE u.rid > 0
    // **
    super.namedQueries.put("rids", new TypedQueryFactory(this, User.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return null;
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeGreaterThan(JsonUtil.basicValueFromJson(candidate.get("rid"), Long.class), 0.0d);
          }
        };
      }
    });
    // **
    // ** NamedQuery "adds"
    // ** SELECT u FROM User u WHERE u.command = 'ADD' ORDER BY u.id
    // **
    super.namedQueries.put("adds", new TypedQueryFactory(this, User.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return new Comparator() {
              private final ErraiAttribute u_id_attr = getMetamodel().entity(User.class).getAttribute("id");
              public int compare(Object o1, Object o2) {
                final User lhs = (User) o1;
                final User rhs = (User) o2;
                int result;
                result = Comparisons.nullSafeCompare((Comparable) u_id_attr.get(lhs), (Comparable) u_id_attr.get(rhs));
                if (result != 0) {
                  return + result;
                }
                return 0;
              }
            };
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeEquals(JsonUtil.basicValueFromJson(candidate.get("command"), String.class), "ADD");
          }
        };
      }
    });
    // **
    // ** NamedQuery "updates"
    // ** SELECT u FROM User u WHERE u.command = 'UPDATE' ORDER BY u.id
    // **
    super.namedQueries.put("updates", new TypedQueryFactory(this, User.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return new Comparator() {
              private final ErraiAttribute u_id_attr = getMetamodel().entity(User.class).getAttribute("id");
              public int compare(Object o1, Object o2) {
                final User lhs = (User) o1;
                final User rhs = (User) o2;
                int result;
                result = Comparisons.nullSafeCompare((Comparable) u_id_attr.get(lhs), (Comparable) u_id_attr.get(rhs));
                if (result != 0) {
                  return + result;
                }
                return 0;
              }
            };
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeEquals(JsonUtil.basicValueFromJson(candidate.get("command"), String.class), "UPDATE");
          }
        };
      }
    });
    // **
    // ** NamedQuery "deletes"
    // ** SELECT u FROM User u WHERE u.command = 'DELETE' ORDER BY u.id
    // **
    super.namedQueries.put("deletes", new TypedQueryFactory(this, User.class, new ErraiParameter[] { }) {
      protected TypedQuery createQuery() {
        return new ErraiTypedQuery(entityManager, actualResultType, parameters) {
          protected Comparator getComparator() {
            return new Comparator() {
              private final ErraiAttribute u_id_attr = getMetamodel().entity(User.class).getAttribute("id");
              public int compare(Object o1, Object o2) {
                final User lhs = (User) o1;
                final User rhs = (User) o2;
                int result;
                result = Comparisons.nullSafeCompare((Comparable) u_id_attr.get(lhs), (Comparable) u_id_attr.get(rhs));
                if (result != 0) {
                  return + result;
                }
                return 0;
              }
            };
          }
          public boolean matches(JSONObject candidate) {
            return Comparisons.nullSafeEquals(JsonUtil.basicValueFromJson(candidate.get("command"), String.class), "DELETE");
          }
        };
      }
    });
  }
}