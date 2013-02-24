package org.jboss.errai.ioc.client;

import com.cosbeni.demo.mobile.App;
import com.cosbeni.demo.mobile.component.ConfirmDialog;
import com.cosbeni.demo.mobile.component.DeleteDialog;
import com.cosbeni.demo.mobile.component.RemoteUserList;
import com.cosbeni.demo.mobile.component.UserForm;
import com.cosbeni.demo.mobile.component.UserList;
import com.cosbeni.demo.mobile.page.ConfirmDialogPage;
import com.cosbeni.demo.mobile.page.DeleteDialogPage;
import com.cosbeni.demo.mobile.page.Pages;
import com.cosbeni.demo.mobile.page.RemotePage;
import com.cosbeni.demo.mobile.page.UserFormPage;
import com.cosbeni.demo.mobile.page.UserListPage;
import com.cosbeni.demo.shared.service.GroupService;
import com.cosbeni.demo.shared.service.UserService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasAllDragAndDropHandlers;
import com.google.gwt.event.dom.client.HasAllFocusHandlers;
import com.google.gwt.event.dom.client.HasAllGestureHandlers;
import com.google.gwt.event.dom.client.HasAllKeyHandlers;
import com.google.gwt.event.dom.client.HasAllMouseHandlers;
import com.google.gwt.event.dom.client.HasAllTouchHandlers;
import com.google.gwt.event.dom.client.HasBlurHandlers;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasDoubleClickHandlers;
import com.google.gwt.event.dom.client.HasDragEndHandlers;
import com.google.gwt.event.dom.client.HasDragEnterHandlers;
import com.google.gwt.event.dom.client.HasDragHandlers;
import com.google.gwt.event.dom.client.HasDragLeaveHandlers;
import com.google.gwt.event.dom.client.HasDragOverHandlers;
import com.google.gwt.event.dom.client.HasDragStartHandlers;
import com.google.gwt.event.dom.client.HasDropHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.dom.client.HasGestureChangeHandlers;
import com.google.gwt.event.dom.client.HasGestureEndHandlers;
import com.google.gwt.event.dom.client.HasGestureStartHandlers;
import com.google.gwt.event.dom.client.HasKeyDownHandlers;
import com.google.gwt.event.dom.client.HasKeyPressHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.event.dom.client.HasMouseDownHandlers;
import com.google.gwt.event.dom.client.HasMouseMoveHandlers;
import com.google.gwt.event.dom.client.HasMouseOutHandlers;
import com.google.gwt.event.dom.client.HasMouseOverHandlers;
import com.google.gwt.event.dom.client.HasMouseUpHandlers;
import com.google.gwt.event.dom.client.HasMouseWheelHandlers;
import com.google.gwt.event.dom.client.HasTouchCancelHandlers;
import com.google.gwt.event.dom.client.HasTouchEndHandlers;
import com.google.gwt.event.dom.client.HasTouchMoveHandlers;
import com.google.gwt.event.dom.client.HasTouchStartHandlers;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.HasAttachHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.i18n.client.AutoDirectionHandler.Target;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.i18n.shared.HasDirectionEstimator;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasAutoHorizontalAlignment;
import com.google.gwt.user.client.ui.HasDirectionalText;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.HasFocus;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVisibility;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HasWordWrap;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.IndexedPanel.ForIsWidget;
import com.google.gwt.user.client.ui.IsRenderable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LabelBase;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RenderableStamper;
import com.google.gwt.user.client.ui.SourcesChangeEvents;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.SourcesFocusEvents;
import com.google.gwt.user.client.ui.SourcesKeyboardEvents;
import com.google.gwt.user.client.ui.SourcesMouseEvents;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.user.client.ui.ValueBoxBase;
import com.google.gwt.user.client.ui.Widget;
import com.sksamuel.jqm4gwt.HasDataRole;
import com.sksamuel.jqm4gwt.HasFullScreen;
import com.sksamuel.jqm4gwt.HasId;
import com.sksamuel.jqm4gwt.HasInset;
import com.sksamuel.jqm4gwt.HasTheme;
import com.sksamuel.jqm4gwt.HasTransition;
import com.sksamuel.jqm4gwt.JQMContainer;
import com.sksamuel.jqm4gwt.JQMPage;
import com.sksamuel.jqm4gwt.JQMWidget;
import com.sksamuel.jqm4gwt.form.elements.JQMSelect;
import com.sksamuel.jqm4gwt.list.HasFilter;
import com.sksamuel.jqm4gwt.list.JQMList;
import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import org.jboss.errai.databinding.client.DataBinderProvider;
import org.jboss.errai.databinding.client.DataBindingModuleBootstrapper;
import org.jboss.errai.enterprise.client.cdi.CDIEventTypeLookup;
import org.jboss.errai.enterprise.client.cdi.EventProvider;
import org.jboss.errai.enterprise.client.cdi.InstanceProvider;
import org.jboss.errai.enterprise.client.cdi.api.CDI;
import org.jboss.errai.enterprise.client.jaxrs.JaxrsModuleBootstrapper;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ioc.client.api.ContextualTypeProvider;
import org.jboss.errai.ioc.client.api.builtin.CallerProvider;
import org.jboss.errai.ioc.client.api.builtin.DisposerProvider;
import org.jboss.errai.ioc.client.api.builtin.IOCBeanManagerProvider;
import org.jboss.errai.ioc.client.api.builtin.InitBallotProvider;
import org.jboss.errai.ioc.client.api.builtin.MessageBusProvider;
import org.jboss.errai.ioc.client.api.builtin.RequestDispatcherProvider;
import org.jboss.errai.ioc.client.api.builtin.RootPanelProvider;
import org.jboss.errai.ioc.client.api.builtin.SenderProvider;
import org.jboss.errai.ioc.client.container.CreationalCallback;
import org.jboss.errai.ioc.client.container.CreationalContext;
import org.jboss.errai.ioc.client.container.IOCBeanManager;
import org.jboss.errai.ioc.client.container.InitializationCallback;
import org.jboss.errai.ioc.client.container.ProxyResolver;
import org.jboss.errai.jpa.client.local.ErraiEntityManagerProvider;
import org.jboss.errai.ui.client.widget.ListWidgetProvider;
import org.jboss.errai.ui.shared.ElementWrapperWidget;
import org.jboss.errai.ui.shared.Template;
import org.jboss.errai.ui.shared.TemplateUtil;

public class BootstrapperImpl implements Bootstrapper {
  {
    new CDI().initLookupTable(CDIEventTypeLookup.get());
    new DataBindingModuleBootstrapper().run();
    new JaxrsModuleBootstrapper().run();
  }
  private final Default _1998831462Default_527992193 = new Default() {
    public Class annotationType() {
      return Default.class;
    }
  };
  private final Any _1998831462Any_562358347 = new Any() {
    public Class annotationType() {
      return Any.class;
    }
  };
  private final Annotation[] arrayOf_19635043Annotation_1117084415 = new Annotation[] { _1998831462Default_527992193, _1998831462Any_562358347 };
  private final BootstrapperInjectionContext injContext = new BootstrapperInjectionContext();
  private final CreationalContext context = injContext.getRootContext();
  private final CreationalCallback<DataBinderProvider> inj70381_DataBinderProvider_creational = new CreationalCallback<DataBinderProvider>() {
    public DataBinderProvider getInstance(final CreationalContext context) {
      final DataBinderProvider inj70368_DataBinderProvider = new DataBinderProvider();
      context.addBean(context.getBeanReference(DataBinderProvider.class, arrayOf_19635043Annotation_1117084415), inj70368_DataBinderProvider);
      return inj70368_DataBinderProvider;
    }
  };
  private final DataBinderProvider inj70368_DataBinderProvider = inj70381_DataBinderProvider_creational.getInstance(context);
  private final CreationalCallback<RequestDispatcherProvider> inj70382_RequestDispatcherProvider_creational = new CreationalCallback<RequestDispatcherProvider>() {
    public RequestDispatcherProvider getInstance(final CreationalContext context) {
      final RequestDispatcherProvider inj70360_RequestDispatcherProvider = new RequestDispatcherProvider();
      context.addBean(context.getBeanReference(RequestDispatcherProvider.class, arrayOf_19635043Annotation_1117084415), inj70360_RequestDispatcherProvider);
      return inj70360_RequestDispatcherProvider;
    }
  };
  private final RequestDispatcherProvider inj70360_RequestDispatcherProvider = inj70382_RequestDispatcherProvider_creational.getInstance(context);
  private final CreationalCallback<InstanceProvider> inj70383_InstanceProvider_creational = new CreationalCallback<InstanceProvider>() {
    public InstanceProvider getInstance(final CreationalContext context) {
      final InstanceProvider inj70370_InstanceProvider = new InstanceProvider();
      context.addBean(context.getBeanReference(InstanceProvider.class, arrayOf_19635043Annotation_1117084415), inj70370_InstanceProvider);
      return inj70370_InstanceProvider;
    }
  };
  private final InstanceProvider inj70370_InstanceProvider = inj70383_InstanceProvider_creational.getInstance(context);
  private final CreationalCallback<ErraiEntityManagerProvider> inj70388_ErraiEntityManagerProvider_creational = new CreationalCallback<ErraiEntityManagerProvider>() {
    public ErraiEntityManagerProvider getInstance(final CreationalContext context) {
      final ErraiEntityManagerProvider inj70366_ErraiEntityManagerProvider = new ErraiEntityManagerProvider();
      context.addBean(context.getBeanReference(ErraiEntityManagerProvider.class, arrayOf_19635043Annotation_1117084415), inj70366_ErraiEntityManagerProvider);
      return inj70366_ErraiEntityManagerProvider;
    }
  };
  private final ErraiEntityManagerProvider inj70366_ErraiEntityManagerProvider = inj70388_ErraiEntityManagerProvider_creational.getInstance(context);
  private final CreationalCallback<JQMList> inj70390_JQMList_creational = new CreationalCallback<JQMList>() {
    public JQMList getInstance(final CreationalContext context) {
      final JQMList inj70021_JQMList = new JQMList();
      context.addBean(context.getBeanReference(JQMList.class, arrayOf_19635043Annotation_1117084415), inj70021_JQMList);
      return inj70021_JQMList;
    }
  };
  private InitializationCallback<UserList> init_inj69950_UserList = new InitializationCallback<UserList>() {
    public void init(final UserList obj) {
      obj.init();
    }
  };
  private final CreationalCallback<UserList> inj70387_UserList_creational = new CreationalCallback<UserList>() {
    public UserList getInstance(final CreationalContext context) {
      final UserList inj69950_UserList = new UserList();
      context.addBean(context.getBeanReference(UserList.class, arrayOf_19635043Annotation_1117084415), inj69950_UserList);
      _$1137283503_em(inj69950_UserList, inj70366_ErraiEntityManagerProvider.get());
      final Pages_inj70389_proxy inj70389_proxy = new Pages_inj70389_proxy();
      context.addUnresolvedProxy(new ProxyResolver<Pages>() {
        public void resolve(Pages obj) {
          inj70389_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj70389_proxy, obj);
        }
      }, Pages.class, arrayOf_19635043Annotation_1117084415);
      _$1137283503_pages(inj69950_UserList, inj70389_proxy);
      _$1137283503_formattedList(inj69950_UserList, inj70390_JQMList_creational.getInstance(context));
      context.addInitializationCallback(inj69950_UserList, new InitializationCallback<UserList>() {
        public void init(UserList obj) {
          com_cosbeni_demo_mobile_component_UserListTemplateResource var497 = GWT.create(com_cosbeni_demo_mobile_component_UserListTemplateResource.class);
          Element var498 = TemplateUtil.getRootTemplateElement(var497.getContents().getText(), "UserList");
          Map<String, Element> var499 = TemplateUtil.getDataFieldElements(var498);
          Map<String, Widget> var500 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserList", "com/cosbeni/demo/mobile/component/Template.html", _$1137283503_content(inj69950_UserList), var499, "content");
          var500.put("content", _$1137283503_content(inj69950_UserList));
          TemplateUtil.initWidget(inj69950_UserList, var498, var500.values());
        }
      });
      context.addInitializationCallback(inj69950_UserList, init_inj69950_UserList);
      return inj69950_UserList;
    }
  };
  private InitializationCallback<UserListPage> init_inj70015_UserListPage = new InitializationCallback<UserListPage>() {
    public void init(final UserListPage obj) {
      obj.init();
    }
  };
  private final CreationalCallback<UserListPage> inj70386_UserListPage_creational = new CreationalCallback<UserListPage>() {
    public UserListPage getInstance(final CreationalContext context) {
      final UserListPage inj70015_UserListPage = new UserListPage();
      context.addBean(context.getBeanReference(UserListPage.class, arrayOf_19635043Annotation_1117084415), inj70015_UserListPage);
      _745152032_userList(inj70015_UserListPage, inj70387_UserList_creational.getInstance(context));
      final Pages_inj70389_proxy inj70389_proxy = new Pages_inj70389_proxy();
      context.addUnresolvedProxy(new ProxyResolver<Pages>() {
        public void resolve(Pages obj) {
          inj70389_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj70389_proxy, obj);
        }
      }, Pages.class, arrayOf_19635043Annotation_1117084415);
      _745152032_pages(inj70015_UserListPage, inj70389_proxy);
      context.addInitializationCallback(inj70015_UserListPage, init_inj70015_UserListPage);
      return inj70015_UserListPage;
    }
  };
  private final CreationalCallback<TextBox> inj70393_TextBox_creational = new CreationalCallback<TextBox>() {
    public TextBox getInstance(final CreationalContext context) {
      final TextBox inj70027_TextBox = new TextBox();
      context.addBean(context.getBeanReference(TextBox.class, arrayOf_19635043Annotation_1117084415), inj70027_TextBox);
      return inj70027_TextBox;
    }
  };
  private final CreationalCallback<Label> inj70394_Label_creational = new CreationalCallback<Label>() {
    public Label getInstance(final CreationalContext context) {
      final Label inj70105_Label = new Label();
      context.addBean(context.getBeanReference(Label.class, arrayOf_19635043Annotation_1117084415), inj70105_Label);
      return inj70105_Label;
    }
  };
  private InitializationCallback<UserForm> init_inj69951_UserForm = new InitializationCallback<UserForm>() {
    public void init(final UserForm obj) {
      obj.init();
    }
  };
  private final CreationalCallback<UserForm> inj70392_UserForm_creational = new CreationalCallback<UserForm>() {
    public UserForm getInstance(final CreationalContext context) {
      final UserForm inj69951_UserForm = new UserForm();
      context.addBean(context.getBeanReference(UserForm.class, arrayOf_19635043Annotation_1117084415), inj69951_UserForm);
      _$1137456521_em(inj69951_UserForm, inj70366_ErraiEntityManagerProvider.get());
      _$1137456521_id(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_rid(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_userName(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_password(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_firstName(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_lastName(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_email(inj69951_UserForm, inj70393_TextBox_creational.getInstance(context));
      _$1137456521_addBox(inj69951_UserForm, inj70394_Label_creational.getInstance(context));
      _$1137456521_updateBox(inj69951_UserForm, inj70394_Label_creational.getInstance(context));
      context.addInitializationCallback(inj69951_UserForm, new InitializationCallback<UserForm>() {
        public void init(UserForm obj) {
          com_cosbeni_demo_mobile_component_UserFormTemplateResource var501 = GWT.create(com_cosbeni_demo_mobile_component_UserFormTemplateResource.class);
          Element var502 = TemplateUtil.getRootTemplateElement(var501.getContents().getText(), "UserForm");
          Map<String, Element> var503 = TemplateUtil.getDataFieldElements(var502);
          Map<String, Widget> var504 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_id(inj69951_UserForm), var503, "id");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_idLabel(inj69951_UserForm)), var503, "idLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_rid(inj69951_UserForm), var503, "rid");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_ridLabel(inj69951_UserForm)), var503, "ridLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_userName(inj69951_UserForm), var503, "userName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_userNameLabel(inj69951_UserForm)), var503, "userNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_userNameMessage(inj69951_UserForm)), var503, "userNameMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_password(inj69951_UserForm), var503, "password");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_passwordLabel(inj69951_UserForm)), var503, "passwordLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_passwordMessage(inj69951_UserForm)), var503, "passwordMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_firstName(inj69951_UserForm), var503, "firstName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_firstNameLabel(inj69951_UserForm)), var503, "firstNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_firstNameMessage(inj69951_UserForm)), var503, "firstNameMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_lastName(inj69951_UserForm), var503, "lastName");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_lastNameLabel(inj69951_UserForm)), var503, "lastNameLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_lastNameMessage(inj69951_UserForm)), var503, "lastNameMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_email(inj69951_UserForm), var503, "email");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_emailLabel(inj69951_UserForm)), var503, "emailLabel");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_emailMessage(inj69951_UserForm)), var503, "emailMessage");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_group(inj69951_UserForm), var503, "group");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_addBox(inj69951_UserForm), var503, "addBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_add(inj69951_UserForm)), var503, "add");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", _$1137456521_updateBox(inj69951_UserForm), var503, "updateBox");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_update(inj69951_UserForm)), var503, "update");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_delete(inj69951_UserForm)), var503, "delete");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.UserForm", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$1137456521_cancel(inj69951_UserForm)), var503, "cancel");
          var504.put("id", _$1137456521_id(inj69951_UserForm));
          var504.put("idLabel", new ElementWrapperWidget(_$1137456521_idLabel(inj69951_UserForm)));
          var504.put("rid", _$1137456521_rid(inj69951_UserForm));
          var504.put("ridLabel", new ElementWrapperWidget(_$1137456521_ridLabel(inj69951_UserForm)));
          var504.put("userName", _$1137456521_userName(inj69951_UserForm));
          var504.put("userNameLabel", new ElementWrapperWidget(_$1137456521_userNameLabel(inj69951_UserForm)));
          var504.put("userNameMessage", new ElementWrapperWidget(_$1137456521_userNameMessage(inj69951_UserForm)));
          var504.put("password", _$1137456521_password(inj69951_UserForm));
          var504.put("passwordLabel", new ElementWrapperWidget(_$1137456521_passwordLabel(inj69951_UserForm)));
          var504.put("passwordMessage", new ElementWrapperWidget(_$1137456521_passwordMessage(inj69951_UserForm)));
          var504.put("firstName", _$1137456521_firstName(inj69951_UserForm));
          var504.put("firstNameLabel", new ElementWrapperWidget(_$1137456521_firstNameLabel(inj69951_UserForm)));
          var504.put("firstNameMessage", new ElementWrapperWidget(_$1137456521_firstNameMessage(inj69951_UserForm)));
          var504.put("lastName", _$1137456521_lastName(inj69951_UserForm));
          var504.put("lastNameLabel", new ElementWrapperWidget(_$1137456521_lastNameLabel(inj69951_UserForm)));
          var504.put("lastNameMessage", new ElementWrapperWidget(_$1137456521_lastNameMessage(inj69951_UserForm)));
          var504.put("email", _$1137456521_email(inj69951_UserForm));
          var504.put("emailLabel", new ElementWrapperWidget(_$1137456521_emailLabel(inj69951_UserForm)));
          var504.put("emailMessage", new ElementWrapperWidget(_$1137456521_emailMessage(inj69951_UserForm)));
          var504.put("group", _$1137456521_group(inj69951_UserForm));
          var504.put("addBox", _$1137456521_addBox(inj69951_UserForm));
          var504.put("add", new ElementWrapperWidget(_$1137456521_add(inj69951_UserForm)));
          var504.put("updateBox", _$1137456521_updateBox(inj69951_UserForm));
          var504.put("update", new ElementWrapperWidget(_$1137456521_update(inj69951_UserForm)));
          var504.put("delete", new ElementWrapperWidget(_$1137456521_delete(inj69951_UserForm)));
          var504.put("cancel", new ElementWrapperWidget(_$1137456521_cancel(inj69951_UserForm)));
          TemplateUtil.initWidget(inj69951_UserForm, var502, var504.values());
          TemplateUtil.setupWrappedElementEventHandler(inj69951_UserForm, var504.get("add"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69951_UserForm.add(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69951_UserForm, var504.get("update"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69951_UserForm.update(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69951_UserForm, var504.get("delete"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69951_UserForm.delete(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69951_UserForm, var504.get("cancel"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69951_UserForm.cancel(event);
            }
          }, ClickEvent.getType());
        }
      });
      context.addInitializationCallback(inj69951_UserForm, init_inj69951_UserForm);
      return inj69951_UserForm;
    }
  };
  private InitializationCallback<UserFormPage> init_inj70009_UserFormPage = new InitializationCallback<UserFormPage>() {
    public void init(final UserFormPage obj) {
      obj.init();
    }
  };
  private final CreationalCallback<UserFormPage> inj70391_UserFormPage_creational = new CreationalCallback<UserFormPage>() {
    public UserFormPage getInstance(final CreationalContext context) {
      final UserFormPage inj70009_UserFormPage = new UserFormPage();
      context.addBean(context.getBeanReference(UserFormPage.class, arrayOf_19635043Annotation_1117084415), inj70009_UserFormPage);
      _$126814394_userForm(inj70009_UserFormPage, inj70392_UserForm_creational.getInstance(context));
      final Pages_inj70389_proxy inj70389_proxy = new Pages_inj70389_proxy();
      context.addUnresolvedProxy(new ProxyResolver<Pages>() {
        public void resolve(Pages obj) {
          inj70389_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj70389_proxy, obj);
        }
      }, Pages.class, arrayOf_19635043Annotation_1117084415);
      _$126814394_pages(inj70009_UserFormPage, inj70389_proxy);
      context.addInitializationCallback(inj70009_UserFormPage, init_inj70009_UserFormPage);
      return inj70009_UserFormPage;
    }
  };
  private final CreationalCallback<CallerProvider> inj70397_CallerProvider_creational = new CreationalCallback<CallerProvider>() {
    public CallerProvider getInstance(final CreationalContext context) {
      final CallerProvider inj70376_CallerProvider = new CallerProvider();
      context.addBean(context.getBeanReference(CallerProvider.class, arrayOf_19635043Annotation_1117084415), inj70376_CallerProvider);
      return inj70376_CallerProvider;
    }
  };
  private final CallerProvider inj70376_CallerProvider = inj70397_CallerProvider_creational.getInstance(context);
  private InitializationCallback<RemoteUserList> init_inj69952_RemoteUserList = new InitializationCallback<RemoteUserList>() {
    public void init(final RemoteUserList obj) {
      obj.init();
    }
  };
  private final CreationalCallback<RemoteUserList> inj70396_RemoteUserList_creational = new CreationalCallback<RemoteUserList>() {
    public RemoteUserList getInstance(final CreationalContext context) {
      final RemoteUserList inj69952_RemoteUserList = new RemoteUserList();
      context.addBean(context.getBeanReference(RemoteUserList.class, arrayOf_19635043Annotation_1117084415), inj69952_RemoteUserList);
      _$536703305_em(inj69952_RemoteUserList, inj70366_ErraiEntityManagerProvider.get());
      _$536703305_userService(inj69952_RemoteUserList, inj70376_CallerProvider.provide(new Class[] { UserService.class }, null));
      _$536703305_groupService(inj69952_RemoteUserList, inj70376_CallerProvider.provide(new Class[] { GroupService.class }, null));
      _$536703305_formattedList(inj69952_RemoteUserList, inj70390_JQMList_creational.getInstance(context));
      final Pages_inj70389_proxy inj70389_proxy = new Pages_inj70389_proxy();
      context.addUnresolvedProxy(new ProxyResolver<Pages>() {
        public void resolve(Pages obj) {
          inj70389_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj70389_proxy, obj);
        }
      }, Pages.class, arrayOf_19635043Annotation_1117084415);
      _$536703305_pages(inj69952_RemoteUserList, inj70389_proxy);
      context.addInitializationCallback(inj69952_RemoteUserList, new InitializationCallback<RemoteUserList>() {
        public void init(RemoteUserList obj) {
          com_cosbeni_demo_mobile_component_RemoteUserListTemplateResource var505 = GWT.create(com_cosbeni_demo_mobile_component_RemoteUserListTemplateResource.class);
          Element var506 = TemplateUtil.getRootTemplateElement(var505.getContents().getText(), "RemoteUserList");
          Map<String, Element> var507 = TemplateUtil.getDataFieldElements(var506);
          Map<String, Widget> var508 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.RemoteUserList", "com/cosbeni/demo/mobile/component/Template.html", _$536703305_content(inj69952_RemoteUserList), var507, "content");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.RemoteUserList", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$536703305_upload(inj69952_RemoteUserList)), var507, "upload");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.RemoteUserList", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$536703305_localWin(inj69952_RemoteUserList)), var507, "localWin");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.RemoteUserList", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$536703305_serverWin(inj69952_RemoteUserList)), var507, "serverWin");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.RemoteUserList", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$536703305_group(inj69952_RemoteUserList)), var507, "group");
          var508.put("content", _$536703305_content(inj69952_RemoteUserList));
          var508.put("upload", new ElementWrapperWidget(_$536703305_upload(inj69952_RemoteUserList)));
          var508.put("localWin", new ElementWrapperWidget(_$536703305_localWin(inj69952_RemoteUserList)));
          var508.put("serverWin", new ElementWrapperWidget(_$536703305_serverWin(inj69952_RemoteUserList)));
          var508.put("group", new ElementWrapperWidget(_$536703305_group(inj69952_RemoteUserList)));
          TemplateUtil.initWidget(inj69952_RemoteUserList, var506, var508.values());
          TemplateUtil.setupWrappedElementEventHandler(inj69952_RemoteUserList, var508.get("upload"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69952_RemoteUserList.upload(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69952_RemoteUserList, var508.get("localWin"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69952_RemoteUserList.localWin(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69952_RemoteUserList, var508.get("serverWin"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69952_RemoteUserList.serverWin(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69952_RemoteUserList, var508.get("group"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69952_RemoteUserList.group(event);
            }
          }, ClickEvent.getType());
        }
      });
      context.addInitializationCallback(inj69952_RemoteUserList, init_inj69952_RemoteUserList);
      return inj69952_RemoteUserList;
    }
  };
  private InitializationCallback<RemotePage> init_inj70014_RemotePage = new InitializationCallback<RemotePage>() {
    public void init(final RemotePage obj) {
      obj.init();
    }
  };
  private final CreationalCallback<RemotePage> inj70395_RemotePage_creational = new CreationalCallback<RemotePage>() {
    public RemotePage getInstance(final CreationalContext context) {
      final RemotePage inj70014_RemotePage = new RemotePage();
      context.addBean(context.getBeanReference(RemotePage.class, arrayOf_19635043Annotation_1117084415), inj70014_RemotePage);
      _1251415773_remoteUserList(inj70014_RemotePage, inj70396_RemoteUserList_creational.getInstance(context));
      final Pages_inj70389_proxy inj70389_proxy = new Pages_inj70389_proxy();
      context.addUnresolvedProxy(new ProxyResolver<Pages>() {
        public void resolve(Pages obj) {
          inj70389_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj70389_proxy, obj);
        }
      }, Pages.class, arrayOf_19635043Annotation_1117084415);
      _1251415773_pages(inj70014_RemotePage, inj70389_proxy);
      context.addInitializationCallback(inj70014_RemotePage, init_inj70014_RemotePage);
      return inj70014_RemotePage;
    }
  };
  private InitializationCallback<ConfirmDialog> init_inj69953_ConfirmDialog = new InitializationCallback<ConfirmDialog>() {
    public void init(final ConfirmDialog obj) {
      obj.init();
    }
  };
  private final CreationalCallback<ConfirmDialog> inj70399_ConfirmDialog_creational = new CreationalCallback<ConfirmDialog>() {
    public ConfirmDialog getInstance(final CreationalContext context) {
      final ConfirmDialog inj69953_ConfirmDialog = new ConfirmDialog();
      context.addBean(context.getBeanReference(ConfirmDialog.class, arrayOf_19635043Annotation_1117084415), inj69953_ConfirmDialog);
      context.addInitializationCallback(inj69953_ConfirmDialog, new InitializationCallback<ConfirmDialog>() {
        public void init(ConfirmDialog obj) {
          com_cosbeni_demo_mobile_component_ConfirmDialogTemplateResource var509 = GWT.create(com_cosbeni_demo_mobile_component_ConfirmDialogTemplateResource.class);
          Element var510 = TemplateUtil.getRootTemplateElement(var509.getContents().getText(), "ConfirmDialog");
          Map<String, Element> var511 = TemplateUtil.getDataFieldElements(var510);
          Map<String, Widget> var512 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.ConfirmDialog", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$2100997664_message(inj69953_ConfirmDialog)), var511, "message");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.ConfirmDialog", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_$2100997664_confirm(inj69953_ConfirmDialog)), var511, "confirm");
          var512.put("message", new ElementWrapperWidget(_$2100997664_message(inj69953_ConfirmDialog)));
          var512.put("confirm", new ElementWrapperWidget(_$2100997664_confirm(inj69953_ConfirmDialog)));
          TemplateUtil.initWidget(inj69953_ConfirmDialog, var510, var512.values());
          TemplateUtil.setupWrappedElementEventHandler(inj69953_ConfirmDialog, var512.get("confirm"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69953_ConfirmDialog.confirm(event);
            }
          }, ClickEvent.getType());
        }
      });
      context.addInitializationCallback(inj69953_ConfirmDialog, init_inj69953_ConfirmDialog);
      return inj69953_ConfirmDialog;
    }
  };
  private InitializationCallback<ConfirmDialogPage> init_inj70011_ConfirmDialogPage = new InitializationCallback<ConfirmDialogPage>() {
    public void init(final ConfirmDialogPage obj) {
      obj.init();
    }
  };
  private final CreationalCallback<ConfirmDialogPage> inj70398_ConfirmDialogPage_creational = new CreationalCallback<ConfirmDialogPage>() {
    public ConfirmDialogPage getInstance(final CreationalContext context) {
      final ConfirmDialogPage inj70011_ConfirmDialogPage = new ConfirmDialogPage();
      context.addBean(context.getBeanReference(ConfirmDialogPage.class, arrayOf_19635043Annotation_1117084415), inj70011_ConfirmDialogPage);
      _1727058671_confirmDialog(inj70011_ConfirmDialogPage, inj70399_ConfirmDialog_creational.getInstance(context));
      context.addInitializationCallback(inj70011_ConfirmDialogPage, init_inj70011_ConfirmDialogPage);
      return inj70011_ConfirmDialogPage;
    }
  };
  private InitializationCallback<DeleteDialog> init_inj69948_DeleteDialog = new InitializationCallback<DeleteDialog>() {
    public void init(final DeleteDialog obj) {
      obj.init();
    }
  };
  private final CreationalCallback<DeleteDialog> inj70401_DeleteDialog_creational = new CreationalCallback<DeleteDialog>() {
    public DeleteDialog getInstance(final CreationalContext context) {
      final DeleteDialog inj69948_DeleteDialog = new DeleteDialog();
      context.addBean(context.getBeanReference(DeleteDialog.class, arrayOf_19635043Annotation_1117084415), inj69948_DeleteDialog);
      _1509202459_em(inj69948_DeleteDialog, inj70366_ErraiEntityManagerProvider.get());
      final Pages_inj70389_proxy inj70389_proxy = new Pages_inj70389_proxy();
      context.addUnresolvedProxy(new ProxyResolver<Pages>() {
        public void resolve(Pages obj) {
          inj70389_proxy.__$setProxiedInstance$(obj);
          context.addProxyReference(inj70389_proxy, obj);
        }
      }, Pages.class, arrayOf_19635043Annotation_1117084415);
      _1509202459_pages(inj69948_DeleteDialog, inj70389_proxy);
      context.addInitializationCallback(inj69948_DeleteDialog, new InitializationCallback<DeleteDialog>() {
        public void init(DeleteDialog obj) {
          com_cosbeni_demo_mobile_component_DeleteDialogTemplateResource var513 = GWT.create(com_cosbeni_demo_mobile_component_DeleteDialogTemplateResource.class);
          Element var514 = TemplateUtil.getRootTemplateElement(var513.getContents().getText(), "DeleteDialog");
          Map<String, Element> var515 = TemplateUtil.getDataFieldElements(var514);
          Map<String, Widget> var516 = new LinkedHashMap<String, Widget>();
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.DeleteDialog", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_1509202459_message(inj69948_DeleteDialog)), var515, "message");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.DeleteDialog", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_1509202459_deleteConfirm(inj69948_DeleteDialog)), var515, "deleteConfirm");
          TemplateUtil.compositeComponentReplace("com.cosbeni.demo.mobile.component.DeleteDialog", "com/cosbeni/demo/mobile/component/Template.html", new ElementWrapperWidget(_1509202459_deleteCancel(inj69948_DeleteDialog)), var515, "deleteCancel");
          var516.put("message", new ElementWrapperWidget(_1509202459_message(inj69948_DeleteDialog)));
          var516.put("deleteConfirm", new ElementWrapperWidget(_1509202459_deleteConfirm(inj69948_DeleteDialog)));
          var516.put("deleteCancel", new ElementWrapperWidget(_1509202459_deleteCancel(inj69948_DeleteDialog)));
          TemplateUtil.initWidget(inj69948_DeleteDialog, var514, var516.values());
          TemplateUtil.setupWrappedElementEventHandler(inj69948_DeleteDialog, var516.get("deleteConfirm"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69948_DeleteDialog.confirm(event);
            }
          }, ClickEvent.getType());
          TemplateUtil.setupWrappedElementEventHandler(inj69948_DeleteDialog, var516.get("deleteCancel"), new ClickHandler() {
            public void onClick(ClickEvent event) {
              inj69948_DeleteDialog.cancel(event);
            }
          }, ClickEvent.getType());
        }
      });
      context.addInitializationCallback(inj69948_DeleteDialog, init_inj69948_DeleteDialog);
      return inj69948_DeleteDialog;
    }
  };
  private InitializationCallback<DeleteDialogPage> init_inj70012_DeleteDialogPage = new InitializationCallback<DeleteDialogPage>() {
    public void init(final DeleteDialogPage obj) {
      obj.init();
    }
  };
  private final CreationalCallback<DeleteDialogPage> inj70400_DeleteDialogPage_creational = new CreationalCallback<DeleteDialogPage>() {
    public DeleteDialogPage getInstance(final CreationalContext context) {
      final DeleteDialogPage inj70012_DeleteDialogPage = new DeleteDialogPage();
      context.addBean(context.getBeanReference(DeleteDialogPage.class, arrayOf_19635043Annotation_1117084415), inj70012_DeleteDialogPage);
      _$1658092310_deleteDialog(inj70012_DeleteDialogPage, inj70401_DeleteDialog_creational.getInstance(context));
      context.addInitializationCallback(inj70012_DeleteDialogPage, init_inj70012_DeleteDialogPage);
      return inj70012_DeleteDialogPage;
    }
  };
  private final CreationalCallback<Pages> inj70385_Pages_creational = new CreationalCallback<Pages>() {
    public Pages getInstance(final CreationalContext context) {
      final Pages inj70384_Pages = new Pages();
      context.addBean(context.getBeanReference(Pages.class, arrayOf_19635043Annotation_1117084415), inj70384_Pages);
      _$1078139940_userListPage(inj70384_Pages, inj70386_UserListPage_creational.getInstance(context));
      _$1078139940_userFormPage(inj70384_Pages, inj70391_UserFormPage_creational.getInstance(context));
      _$1078139940_remotePage(inj70384_Pages, inj70395_RemotePage_creational.getInstance(context));
      _$1078139940_confirmDialog(inj70384_Pages, inj70398_ConfirmDialogPage_creational.getInstance(context));
      _$1078139940_deleteDialog(inj70384_Pages, inj70400_DeleteDialogPage_creational.getInstance(context));
      return inj70384_Pages;
    }
  };
  private final Pages inj70384_Pages = inj70385_Pages_creational.getInstance(context);
  private InitializationCallback<App> init_inj70402_App = new InitializationCallback<App>() {
    public void init(final App obj) {
      obj.init();
    }
  };
  private final CreationalCallback<App> inj70403_App_creational = new CreationalCallback<App>() {
    public App getInstance(final CreationalContext context) {
      final App inj70402_App = new App();
      context.addBean(context.getBeanReference(App.class, arrayOf_19635043Annotation_1117084415), inj70402_App);
      _2007837066_pages(inj70402_App, inj70384_Pages);
      context.addInitializationCallback(inj70402_App, init_inj70402_App);
      return inj70402_App;
    }
  };
  private final App inj70402_App = inj70403_App_creational.getInstance(context);
  private final CreationalCallback<EventProvider> inj70404_EventProvider_creational = new CreationalCallback<EventProvider>() {
    public EventProvider getInstance(final CreationalContext context) {
      final EventProvider inj70374_EventProvider = new EventProvider();
      context.addBean(context.getBeanReference(EventProvider.class, arrayOf_19635043Annotation_1117084415), inj70374_EventProvider);
      return inj70374_EventProvider;
    }
  };
  private final EventProvider inj70374_EventProvider = inj70404_EventProvider_creational.getInstance(context);
  private final CreationalCallback<MessageBusProvider> inj70405_MessageBusProvider_creational = new CreationalCallback<MessageBusProvider>() {
    public MessageBusProvider getInstance(final CreationalContext context) {
      final MessageBusProvider inj70358_MessageBusProvider = new MessageBusProvider();
      context.addBean(context.getBeanReference(MessageBusProvider.class, arrayOf_19635043Annotation_1117084415), inj70358_MessageBusProvider);
      return inj70358_MessageBusProvider;
    }
  };
  private final MessageBusProvider inj70358_MessageBusProvider = inj70405_MessageBusProvider_creational.getInstance(context);
  private final CreationalCallback<IOCBeanManagerProvider> inj70406_IOCBeanManagerProvider_creational = new CreationalCallback<IOCBeanManagerProvider>() {
    public IOCBeanManagerProvider getInstance(final CreationalContext context) {
      final IOCBeanManagerProvider inj70364_IOCBeanManagerProvider = new IOCBeanManagerProvider();
      context.addBean(context.getBeanReference(IOCBeanManagerProvider.class, arrayOf_19635043Annotation_1117084415), inj70364_IOCBeanManagerProvider);
      return inj70364_IOCBeanManagerProvider;
    }
  };
  private final IOCBeanManagerProvider inj70364_IOCBeanManagerProvider = inj70406_IOCBeanManagerProvider_creational.getInstance(context);
  private final CreationalCallback<SenderProvider> inj70407_SenderProvider_creational = new CreationalCallback<SenderProvider>() {
    public SenderProvider getInstance(final CreationalContext context) {
      final SenderProvider inj70380_SenderProvider = new SenderProvider();
      context.addBean(context.getBeanReference(SenderProvider.class, arrayOf_19635043Annotation_1117084415), inj70380_SenderProvider);
      return inj70380_SenderProvider;
    }
  };
  private final SenderProvider inj70380_SenderProvider = inj70407_SenderProvider_creational.getInstance(context);
  private final CreationalCallback<InitBallotProvider> inj70408_InitBallotProvider_creational = new CreationalCallback<InitBallotProvider>() {
    public InitBallotProvider getInstance(final CreationalContext context) {
      final InitBallotProvider inj70372_InitBallotProvider = new InitBallotProvider();
      context.addBean(context.getBeanReference(InitBallotProvider.class, arrayOf_19635043Annotation_1117084415), inj70372_InitBallotProvider);
      return inj70372_InitBallotProvider;
    }
  };
  private final InitBallotProvider inj70372_InitBallotProvider = inj70408_InitBallotProvider_creational.getInstance(context);
  private final CreationalCallback<RootPanelProvider> inj70409_RootPanelProvider_creational = new CreationalCallback<RootPanelProvider>() {
    public RootPanelProvider getInstance(final CreationalContext context) {
      final RootPanelProvider inj70362_RootPanelProvider = new RootPanelProvider();
      context.addBean(context.getBeanReference(RootPanelProvider.class, arrayOf_19635043Annotation_1117084415), inj70362_RootPanelProvider);
      return inj70362_RootPanelProvider;
    }
  };
  private final RootPanelProvider inj70362_RootPanelProvider = inj70409_RootPanelProvider_creational.getInstance(context);
  private final CreationalCallback<ListWidgetProvider> inj70410_ListWidgetProvider_creational = new CreationalCallback<ListWidgetProvider>() {
    public ListWidgetProvider getInstance(final CreationalContext context) {
      final ListWidgetProvider inj70356_ListWidgetProvider = new ListWidgetProvider();
      context.addBean(context.getBeanReference(ListWidgetProvider.class, arrayOf_19635043Annotation_1117084415), inj70356_ListWidgetProvider);
      return inj70356_ListWidgetProvider;
    }
  };
  private final ListWidgetProvider inj70356_ListWidgetProvider = inj70410_ListWidgetProvider_creational.getInstance(context);
  private final CreationalCallback<DisposerProvider> inj70411_DisposerProvider_creational = new CreationalCallback<DisposerProvider>() {
    public DisposerProvider getInstance(final CreationalContext context) {
      final DisposerProvider inj70378_DisposerProvider = new DisposerProvider();
      context.addBean(context.getBeanReference(DisposerProvider.class, arrayOf_19635043Annotation_1117084415), inj70378_DisposerProvider);
      _$1300398733_beanManager(inj70378_DisposerProvider, inj70364_IOCBeanManagerProvider.get());
      return inj70378_DisposerProvider;
    }
  };
  private final DisposerProvider inj70378_DisposerProvider = inj70411_DisposerProvider_creational.getInstance(context);
  static class Pages_inj70389_proxy extends Pages {
    private Pages $$_proxy_$$;
    public UserListPage getUserListPage() {
      return $$_proxy_$$.getUserListPage();
    }

    public UserFormPage getUserFormPage() {
      return $$_proxy_$$.getUserFormPage();
    }

    public RemotePage getRemotePage() {
      return $$_proxy_$$.getRemotePage();
    }

    public ConfirmDialogPage getConfirmDialog() {
      return $$_proxy_$$.getConfirmDialog();
    }

    public DeleteDialogPage getDeleteDialog() {
      return $$_proxy_$$.getDeleteDialog();
    }

    public void claimElement(Element a0) {
      $$_proxy_$$.claimElement(a0);
    }

    public void initializeClaimedElement() {
      $$_proxy_$$.initializeClaimedElement();
    }

    public boolean isAttached() {
      return $$_proxy_$$.isAttached();
    }

    public void onBrowserEvent(Event a0) {
      $$_proxy_$$.onBrowserEvent(a0);
    }

    public SafeHtml render(RenderableStamper a0) {
      return $$_proxy_$$.render(a0);
    }

    public void render(RenderableStamper a0, SafeHtmlBuilder a1) {
      $$_proxy_$$.render(a0, a1);
    }

    public native Widget _$642645761_getWidget(Composite instance) /*-{
      return instance.@com.google.gwt.user.client.ui.Composite::getWidget()();
    }-*/;

    public Widget getWidget() {
      return _$642645761_getWidget($$_proxy_$$);
    }

    public native void _$642645761_initWidget(Composite instance, Widget a0) /*-{
      instance.@com.google.gwt.user.client.ui.Composite::initWidget(Lcom/google/gwt/user/client/ui/Widget;)(a0);
    }-*/;

    public void initWidget(Widget a0) {
      _$642645761_initWidget($$_proxy_$$, a0);
    }

    public native void _$642645761_onAttach(Composite instance) /*-{
      instance.@com.google.gwt.user.client.ui.Composite::onAttach()();
    }-*/;

    public void onAttach() {
      _$642645761_onAttach($$_proxy_$$);
    }

    public native void _$642645761_onDetach(Composite instance) /*-{
      instance.@com.google.gwt.user.client.ui.Composite::onDetach()();
    }-*/;

    public void onDetach() {
      _$642645761_onDetach($$_proxy_$$);
    }

    public native Element _$642645761_resolvePotentialElement(Composite instance) /*-{
      return instance.@com.google.gwt.user.client.ui.Composite::resolvePotentialElement()();
    }-*/;

    public Element resolvePotentialElement() {
      return _$642645761_resolvePotentialElement($$_proxy_$$);
    }

    public native void _$642645761_setWidget(Composite instance, Widget a0) /*-{
      instance.@com.google.gwt.user.client.ui.Composite::setWidget(Lcom/google/gwt/user/client/ui/Widget;)(a0);
    }-*/;

    public void setWidget(Widget a0) {
      _$642645761_setWidget($$_proxy_$$, a0);
    }

    public HandlerRegistration addAttachHandler(Handler a0) {
      return $$_proxy_$$.addAttachHandler(a0);
    }

    public Widget asWidget() {
      return $$_proxy_$$.asWidget();
    }

    public void fireEvent(GwtEvent a0) {
      $$_proxy_$$.fireEvent(a0);
    }

    public Object getLayoutData() {
      return $$_proxy_$$.getLayoutData();
    }

    public Widget getParent() {
      return $$_proxy_$$.getParent();
    }

    public void removeFromParent() {
      $$_proxy_$$.removeFromParent();
    }

    public void setLayoutData(Object a0) {
      $$_proxy_$$.setLayoutData(a0);
    }

    public void sinkEvents(int a0) {
      $$_proxy_$$.sinkEvents(a0);
    }

    public native HandlerManager _$1585570100_createHandlerManager(Widget instance) /*-{
      return instance.@com.google.gwt.user.client.ui.Widget::createHandlerManager()();
    }-*/;

    public HandlerManager createHandlerManager() {
      return _$1585570100_createHandlerManager($$_proxy_$$);
    }

    public native void _$1585570100_delegateEvent(Widget instance, Widget a0, GwtEvent a1) /*-{
      instance.@com.google.gwt.user.client.ui.Widget::delegateEvent(Lcom/google/gwt/user/client/ui/Widget;Lcom/google/gwt/event/shared/GwtEvent;)(a0, a1);
    }-*/;

    public void delegateEvent(Widget a0, GwtEvent a1) {
      _$1585570100_delegateEvent($$_proxy_$$, a0, a1);
    }

    public native void _$1585570100_doAttachChildren(Widget instance) /*-{
      instance.@com.google.gwt.user.client.ui.Widget::doAttachChildren()();
    }-*/;

    public void doAttachChildren() {
      _$1585570100_doAttachChildren($$_proxy_$$);
    }

    public native void _$1585570100_doDetachChildren(Widget instance) /*-{
      instance.@com.google.gwt.user.client.ui.Widget::doDetachChildren()();
    }-*/;

    public void doDetachChildren() {
      _$1585570100_doDetachChildren($$_proxy_$$);
    }

    public native int _$1585570100_getHandlerCount(Widget instance, Type a0) /*-{
      return instance.@com.google.gwt.user.client.ui.Widget::getHandlerCount(Lcom/google/gwt/event/shared/GwtEvent$Type;)(a0);
    }-*/;

    public int getHandlerCount(Type a0) {
      return _$1585570100_getHandlerCount($$_proxy_$$, a0);
    }

    public native void _$1585570100_onLoad(Widget instance) /*-{
      instance.@com.google.gwt.user.client.ui.Widget::onLoad()();
    }-*/;

    public void onLoad() {
      _$1585570100_onLoad($$_proxy_$$);
    }

    public native void _$1585570100_onUnload(Widget instance) /*-{
      instance.@com.google.gwt.user.client.ui.Widget::onUnload()();
    }-*/;

    public void onUnload() {
      _$1585570100_onUnload($$_proxy_$$);
    }

    public boolean isVisible() {
      return $$_proxy_$$.isVisible();
    }

    public void setVisible(boolean a0) {
      $$_proxy_$$.setVisible(a0);
    }

    public String getStyleName() {
      return $$_proxy_$$.getStyleName();
    }

    public String getStylePrimaryName() {
      return $$_proxy_$$.getStylePrimaryName();
    }

    public void setStyleName(String a0, boolean a1) {
      $$_proxy_$$.setStyleName(a0, a1);
    }

    public void setStyleName(String a0) {
      $$_proxy_$$.setStyleName(a0);
    }

    public void setStylePrimaryName(String a0) {
      $$_proxy_$$.setStylePrimaryName(a0);
    }

    public void addStyleDependentName(String a0) {
      $$_proxy_$$.addStyleDependentName(a0);
    }

    public void addStyleName(String a0) {
      $$_proxy_$$.addStyleName(a0);
    }

    public int getAbsoluteLeft() {
      return $$_proxy_$$.getAbsoluteLeft();
    }

    public int getAbsoluteTop() {
      return $$_proxy_$$.getAbsoluteTop();
    }

    public com.google.gwt.user.client.Element getElement() {
      return $$_proxy_$$.getElement();
    }

    public int getOffsetHeight() {
      return $$_proxy_$$.getOffsetHeight();
    }

    public int getOffsetWidth() {
      return $$_proxy_$$.getOffsetWidth();
    }

    public String getTitle() {
      return $$_proxy_$$.getTitle();
    }

    public void removeStyleDependentName(String a0) {
      $$_proxy_$$.removeStyleDependentName(a0);
    }

    public void removeStyleName(String a0) {
      $$_proxy_$$.removeStyleName(a0);
    }

    public void setHeight(String a0) {
      $$_proxy_$$.setHeight(a0);
    }

    public void setPixelSize(int a0, int a1) {
      $$_proxy_$$.setPixelSize(a0, a1);
    }

    public void setSize(String a0, String a1) {
      $$_proxy_$$.setSize(a0, a1);
    }

    public void setStyleDependentName(String a0, boolean a1) {
      $$_proxy_$$.setStyleDependentName(a0, a1);
    }

    public void setTitle(String a0) {
      $$_proxy_$$.setTitle(a0);
    }

    public void setWidth(String a0) {
      $$_proxy_$$.setWidth(a0);
    }

    public void sinkBitlessEvent(String a0) {
      $$_proxy_$$.sinkBitlessEvent(a0);
    }

    public void unsinkEvents(int a0) {
      $$_proxy_$$.unsinkEvents(a0);
    }

    public native com.google.gwt.user.client.Element _$1446135461_getStyleElement(UIObject instance) /*-{
      return instance.@com.google.gwt.user.client.ui.UIObject::getStyleElement()();
    }-*/;

    public com.google.gwt.user.client.Element getStyleElement() {
      return _$1446135461_getStyleElement($$_proxy_$$);
    }

    public native void _$1446135461_onEnsureDebugId(UIObject instance, String a0) /*-{
      instance.@com.google.gwt.user.client.ui.UIObject::onEnsureDebugId(Ljava/lang/String;)(a0);
    }-*/;

    public void onEnsureDebugId(String a0) {
      _$1446135461_onEnsureDebugId($$_proxy_$$, a0);
    }

    public native void _$1446135461_setElement(UIObject instance, com.google.gwt.user.client.Element a0) /*-{
      instance.@com.google.gwt.user.client.ui.UIObject::setElement(Lcom/google/gwt/user/client/Element;)(a0);
    }-*/;

    public void setElement(com.google.gwt.user.client.Element a0) {
      _$1446135461_setElement($$_proxy_$$, a0);
    }

    public int hashCode() {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to hashCode() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.hashCode();
      }
    }

    public boolean equals(Object o) {
      if ($$_proxy_$$ == null) {
        throw new IllegalStateException("call to equals() on an unclosed proxy.");
      } else {
        return $$_proxy_$$.equals(o);
      }
    }

    public void __$setProxiedInstance$(Pages proxy) {
      $$_proxy_$$ = proxy;
    }
  }
  public interface com_cosbeni_demo_mobile_component_UserListTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/component/Template.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_mobile_component_UserFormTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/component/Template.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_mobile_component_RemoteUserListTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/component/Template.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_mobile_component_ConfirmDialogTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/component/Template.html") public TextResource getContents(); }
  public interface com_cosbeni_demo_mobile_component_DeleteDialogTemplateResource extends Template, ClientBundle {
  @Source("com/cosbeni/demo/mobile/component/Template.html") public TextResource getContents(); }
  private void declareBeans_0() {
    injContext.addBean(DataBinderProvider.class, DataBinderProvider.class, inj70381_DataBinderProvider_creational, inj70368_DataBinderProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, DataBinderProvider.class, inj70381_DataBinderProvider_creational, inj70368_DataBinderProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(RequestDispatcherProvider.class, RequestDispatcherProvider.class, inj70382_RequestDispatcherProvider_creational, inj70360_RequestDispatcherProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Provider.class, RequestDispatcherProvider.class, inj70382_RequestDispatcherProvider_creational, inj70360_RequestDispatcherProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(InstanceProvider.class, InstanceProvider.class, inj70383_InstanceProvider_creational, inj70370_InstanceProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, InstanceProvider.class, inj70383_InstanceProvider_creational, inj70370_InstanceProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ErraiEntityManagerProvider.class, ErraiEntityManagerProvider.class, inj70388_ErraiEntityManagerProvider_creational, inj70366_ErraiEntityManagerProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Provider.class, ErraiEntityManagerProvider.class, inj70388_ErraiEntityManagerProvider_creational, inj70366_ErraiEntityManagerProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMList.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(HasClickHandlers.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasInset.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFilter.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMWidget.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTheme.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasId.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDataRole.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Composite.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, JQMList.class, inj70390_JQMList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UserList.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Composite.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, UserList.class, inj70387_UserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UserListPage.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(JQMPage.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFullScreen.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTheme.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasId.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMContainer.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTransition.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ComplexPanel.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ForIsWidget.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IndexedPanel.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Panel.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasWidgets.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Iterable.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, UserListPage.class, inj70386_UserListPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(TextBox.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(TextBoxBase.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesChangeEvents.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ValueBoxBase.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasChangeHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasName.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDirectionEstimator.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasValue.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(TakesValue.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasValueChangeHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Target.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasText.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDirection.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasKeyUpHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsEditor.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(FocusWidget.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesClickEvents.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasClickHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFocus.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Focusable.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesFocusEvents.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesKeyboardEvents.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasEnabled.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragEndHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragEnterHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragOverHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragStartHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDropHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllFocusHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFocusHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasBlurHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllGestureHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasGestureStartHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasGestureEndHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllKeyHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasKeyDownHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasKeyPressHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllMouseHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseDownHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseUpHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseOutHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseOverHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllTouchHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchStartHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchEndHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesMouseEvents.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, TextBox.class, inj70393_TextBox_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Label.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(HasDirectionalText.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasText.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDirection.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasClickHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDoubleClickHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesClickEvents.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SourcesMouseEvents.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllDragAndDropHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragEndHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragEnterHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragLeaveHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragOverHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDragStartHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDropHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllGestureHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasGestureStartHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasGestureChangeHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasGestureEndHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllMouseHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseDownHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseUpHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseOutHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseOverHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseMoveHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasMouseWheelHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAllTouchHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchStartHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchMoveHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchEndHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTouchCancelHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsEditor.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(LabelBase.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasWordWrap.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasDirectionEstimator.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAutoHorizontalAlignment.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHorizontalAlignment.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, Label.class, inj70394_Label_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UserForm.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Composite.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, UserForm.class, inj70392_UserForm_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UserFormPage.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(JQMPage.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFullScreen.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTheme.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasId.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMContainer.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTransition.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ComplexPanel.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ForIsWidget.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IndexedPanel.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Panel.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasWidgets.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Iterable.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, UserFormPage.class, inj70391_UserFormPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(CallerProvider.class, CallerProvider.class, inj70397_CallerProvider_creational, inj70376_CallerProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, CallerProvider.class, inj70397_CallerProvider_creational, inj70376_CallerProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(RemoteUserList.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Composite.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, RemoteUserList.class, inj70396_RemoteUserList_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(RemotePage.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(JQMPage.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFullScreen.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTheme.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasId.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMContainer.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTransition.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ComplexPanel.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ForIsWidget.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IndexedPanel.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Panel.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasWidgets.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Iterable.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, RemotePage.class, inj70395_RemotePage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ConfirmDialog.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Composite.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, ConfirmDialog.class, inj70399_ConfirmDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ConfirmDialogPage.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(JQMPage.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFullScreen.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTheme.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasId.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMContainer.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTransition.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ComplexPanel.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ForIsWidget.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IndexedPanel.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Panel.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasWidgets.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Iterable.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, ConfirmDialogPage.class, inj70398_ConfirmDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(DeleteDialog.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Composite.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, DeleteDialog.class, inj70401_DeleteDialog_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(DeleteDialogPage.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(JQMPage.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasFullScreen.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTheme.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasId.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(JQMContainer.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasTransition.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ComplexPanel.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ForIsWidget.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IndexedPanel.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Panel.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(com.google.gwt.user.client.ui.HasWidgets.ForIsWidget.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasWidgets.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Iterable.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, DeleteDialogPage.class, inj70400_DeleteDialogPage_creational, null, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Pages.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Composite.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsRenderable.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(Widget.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(EventListener.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasAttachHandlers.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasHandlers.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IsWidget.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(UIObject.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(HasVisibility.class, Pages.class, inj70385_Pages_creational, inj70384_Pages, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(App.class, App.class, inj70403_App_creational, inj70402_App, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(EventProvider.class, EventProvider.class, inj70404_EventProvider_creational, inj70374_EventProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, EventProvider.class, inj70404_EventProvider_creational, inj70374_EventProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(MessageBusProvider.class, MessageBusProvider.class, inj70405_MessageBusProvider_creational, inj70358_MessageBusProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Provider.class, MessageBusProvider.class, inj70405_MessageBusProvider_creational, inj70358_MessageBusProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(IOCBeanManagerProvider.class, IOCBeanManagerProvider.class, inj70406_IOCBeanManagerProvider_creational, inj70364_IOCBeanManagerProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Provider.class, IOCBeanManagerProvider.class, inj70406_IOCBeanManagerProvider_creational, inj70364_IOCBeanManagerProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(SenderProvider.class, SenderProvider.class, inj70407_SenderProvider_creational, inj70380_SenderProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, SenderProvider.class, inj70407_SenderProvider_creational, inj70380_SenderProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(InitBallotProvider.class, InitBallotProvider.class, inj70408_InitBallotProvider_creational, inj70372_InitBallotProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, InitBallotProvider.class, inj70408_InitBallotProvider_creational, inj70372_InitBallotProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(RootPanelProvider.class, RootPanelProvider.class, inj70409_RootPanelProvider_creational, inj70362_RootPanelProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(Provider.class, RootPanelProvider.class, inj70409_RootPanelProvider_creational, inj70362_RootPanelProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(ListWidgetProvider.class, ListWidgetProvider.class, inj70410_ListWidgetProvider_creational, inj70356_ListWidgetProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, ListWidgetProvider.class, inj70410_ListWidgetProvider_creational, inj70356_ListWidgetProvider, arrayOf_19635043Annotation_1117084415, null, false);
    injContext.addBean(DisposerProvider.class, DisposerProvider.class, inj70411_DisposerProvider_creational, inj70378_DisposerProvider, arrayOf_19635043Annotation_1117084415, null, true);
    injContext.addBean(ContextualTypeProvider.class, DisposerProvider.class, inj70411_DisposerProvider_creational, inj70378_DisposerProvider, arrayOf_19635043Annotation_1117084415, null, false);
  }

  private native static AnchorElement _$1137456521_cancel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::cancel;
  }-*/;

  private native static void _$1137456521_cancel(UserForm instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::cancel = value;
  }-*/;

  private native static void _$1658092310_deleteDialog(DeleteDialogPage instance, DeleteDialog value) /*-{
    instance.@com.cosbeni.demo.mobile.page.DeleteDialogPage::deleteDialog = value;
  }-*/;

  private native static void _$1078139940_confirmDialog(Pages instance, ConfirmDialogPage value) /*-{
    instance.@com.cosbeni.demo.mobile.page.Pages::confirmDialog = value;
  }-*/;

  private native static HTMLPanel _$536703305_content(RemoteUserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.RemoteUserList::content;
  }-*/;

  private native static void _$536703305_content(RemoteUserList instance, HTMLPanel value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::content = value;
  }-*/;

  private native static void _1251415773_remoteUserList(RemotePage instance, RemoteUserList value) /*-{
    instance.@com.cosbeni.demo.mobile.page.RemotePage::remoteUserList = value;
  }-*/;

  private native static LabelElement _$1137456521_userNameMessage(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::userNameMessage;
  }-*/;

  private native static void _$1137456521_userNameMessage(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::userNameMessage = value;
  }-*/;

  private native static AnchorElement _$1137456521_delete(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::delete;
  }-*/;

  private native static void _$1137456521_delete(UserForm instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::delete = value;
  }-*/;

  private native static void _$1137283503_formattedList(UserList instance, JQMList value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserList::formattedList = value;
  }-*/;

  private native static void _$1078139940_remotePage(Pages instance, RemotePage value) /*-{
    instance.@com.cosbeni.demo.mobile.page.Pages::remotePage = value;
  }-*/;

  private native static TextBox _$1137456521_lastName(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::lastName;
  }-*/;

  private native static void _$1137456521_lastName(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::lastName = value;
  }-*/;

  private native static LabelElement _$1137456521_lastNameMessage(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::lastNameMessage;
  }-*/;

  private native static void _$1137456521_lastNameMessage(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::lastNameMessage = value;
  }-*/;

  private native static void _2007837066_pages(App instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.App::pages = value;
  }-*/;

  private native static TextBox _$1137456521_id(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::id;
  }-*/;

  private native static void _$1137456521_id(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::id = value;
  }-*/;

  private native static LabelElement _$1137456521_lastNameLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::lastNameLabel;
  }-*/;

  private native static void _$1137456521_lastNameLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::lastNameLabel = value;
  }-*/;

  private native static void _745152032_userList(UserListPage instance, UserList value) /*-{
    instance.@com.cosbeni.demo.mobile.page.UserListPage::userList = value;
  }-*/;

  private native static TextBox _$1137456521_rid(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::rid;
  }-*/;

  private native static void _$1137456521_rid(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::rid = value;
  }-*/;

  private native static LabelElement _$1137456521_passwordLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::passwordLabel;
  }-*/;

  private native static void _$1137456521_passwordLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::passwordLabel = value;
  }-*/;

  private native static void _1509202459_em(DeleteDialog instance, EntityManager value) /*-{
    instance.@com.cosbeni.demo.mobile.component.DeleteDialog::em = value;
  }-*/;

  private native static void _$126814394_userForm(UserFormPage instance, UserForm value) /*-{
    instance.@com.cosbeni.demo.mobile.page.UserFormPage::userForm = value;
  }-*/;

  private native static void _1251415773_pages(RemotePage instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.page.RemotePage::pages = value;
  }-*/;

  private native static HeadingElement _1509202459_message(DeleteDialog instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.DeleteDialog::message;
  }-*/;

  private native static void _1509202459_message(DeleteDialog instance, HeadingElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.DeleteDialog::message = value;
  }-*/;

  private native static void _$536703305_pages(RemoteUserList instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::pages = value;
  }-*/;

  private native static void _$1078139940_deleteDialog(Pages instance, DeleteDialogPage value) /*-{
    instance.@com.cosbeni.demo.mobile.page.Pages::deleteDialog = value;
  }-*/;

  private native static AnchorElement _$536703305_localWin(RemoteUserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.RemoteUserList::localWin;
  }-*/;

  private native static void _$536703305_localWin(RemoteUserList instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::localWin = value;
  }-*/;

  private native static LabelElement _$1137456521_emailLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::emailLabel;
  }-*/;

  private native static void _$1137456521_emailLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::emailLabel = value;
  }-*/;

  private native static LabelElement _$1137456521_passwordMessage(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::passwordMessage;
  }-*/;

  private native static void _$1137456521_passwordMessage(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::passwordMessage = value;
  }-*/;

  private native static LabelElement _$1137456521_userNameLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::userNameLabel;
  }-*/;

  private native static void _$1137456521_userNameLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::userNameLabel = value;
  }-*/;

  private native static void _$1137456521_em(UserForm instance, EntityManager value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::em = value;
  }-*/;

  private native static TextBox _$1137456521_userName(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::userName;
  }-*/;

  private native static void _$1137456521_userName(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::userName = value;
  }-*/;

  private native static void _$1300398733_beanManager(DisposerProvider instance, IOCBeanManager value) /*-{
    instance.@org.jboss.errai.ioc.client.api.builtin.DisposerProvider::beanManager = value;
  }-*/;

  private native static void _$1137283503_em(UserList instance, EntityManager value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserList::em = value;
  }-*/;

  private native static LabelElement _$1137456521_emailMessage(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::emailMessage;
  }-*/;

  private native static void _$1137456521_emailMessage(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::emailMessage = value;
  }-*/;

  private native static AnchorElement _$536703305_upload(RemoteUserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.RemoteUserList::upload;
  }-*/;

  private native static void _$536703305_upload(RemoteUserList instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::upload = value;
  }-*/;

  private native static LabelElement _$1137456521_idLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::idLabel;
  }-*/;

  private native static void _$1137456521_idLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::idLabel = value;
  }-*/;

  private native static TextBox _$1137456521_password(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::password;
  }-*/;

  private native static void _$1137456521_password(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::password = value;
  }-*/;

  private native static LabelElement _$1137456521_ridLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::ridLabel;
  }-*/;

  private native static void _$1137456521_ridLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::ridLabel = value;
  }-*/;

  private native static JQMSelect _$1137456521_group(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::group;
  }-*/;

  private native static void _$1137456521_group(UserForm instance, JQMSelect value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::group = value;
  }-*/;

  private native static AnchorElement _$2100997664_confirm(ConfirmDialog instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.ConfirmDialog::confirm;
  }-*/;

  private native static void _$2100997664_confirm(ConfirmDialog instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.ConfirmDialog::confirm = value;
  }-*/;

  private native static LabelElement _$1137456521_firstNameMessage(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::firstNameMessage;
  }-*/;

  private native static void _$1137456521_firstNameMessage(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::firstNameMessage = value;
  }-*/;

  private native static void _$1078139940_userFormPage(Pages instance, UserFormPage value) /*-{
    instance.@com.cosbeni.demo.mobile.page.Pages::userFormPage = value;
  }-*/;

  private native static Label _$1137456521_updateBox(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::updateBox;
  }-*/;

  private native static void _$1137456521_updateBox(UserForm instance, Label value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::updateBox = value;
  }-*/;

  private native static void _1509202459_pages(DeleteDialog instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.component.DeleteDialog::pages = value;
  }-*/;

  private native static LabelElement _$1137456521_firstNameLabel(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::firstNameLabel;
  }-*/;

  private native static void _$1137456521_firstNameLabel(UserForm instance, LabelElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::firstNameLabel = value;
  }-*/;

  private native static void _$536703305_groupService(RemoteUserList instance, Caller value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::groupService = value;
  }-*/;

  private native static void _745152032_pages(UserListPage instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.page.UserListPage::pages = value;
  }-*/;

  private native static AnchorElement _1509202459_deleteConfirm(DeleteDialog instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.DeleteDialog::deleteConfirm;
  }-*/;

  private native static void _1509202459_deleteConfirm(DeleteDialog instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.DeleteDialog::deleteConfirm = value;
  }-*/;

  private native static HeadingElement _$2100997664_message(ConfirmDialog instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.ConfirmDialog::message;
  }-*/;

  private native static void _$2100997664_message(ConfirmDialog instance, HeadingElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.ConfirmDialog::message = value;
  }-*/;

  private native static void _$1137283503_pages(UserList instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserList::pages = value;
  }-*/;

  private native static void _$126814394_pages(UserFormPage instance, Pages value) /*-{
    instance.@com.cosbeni.demo.mobile.page.UserFormPage::pages = value;
  }-*/;

  private native static TextBox _$1137456521_email(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::email;
  }-*/;

  private native static void _$1137456521_email(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::email = value;
  }-*/;

  private native static Label _$1137456521_addBox(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::addBox;
  }-*/;

  private native static void _$1137456521_addBox(UserForm instance, Label value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::addBox = value;
  }-*/;

  private native static AnchorElement _$536703305_group(RemoteUserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.RemoteUserList::group;
  }-*/;

  private native static void _$536703305_group(RemoteUserList instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::group = value;
  }-*/;

  private native static AnchorElement _$536703305_serverWin(RemoteUserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.RemoteUserList::serverWin;
  }-*/;

  private native static void _$536703305_serverWin(RemoteUserList instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::serverWin = value;
  }-*/;

  private native static TextBox _$1137456521_firstName(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::firstName;
  }-*/;

  private native static void _$1137456521_firstName(UserForm instance, TextBox value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::firstName = value;
  }-*/;

  private native static void _$536703305_formattedList(RemoteUserList instance, JQMList value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::formattedList = value;
  }-*/;

  private native static AnchorElement _1509202459_deleteCancel(DeleteDialog instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.DeleteDialog::deleteCancel;
  }-*/;

  private native static void _1509202459_deleteCancel(DeleteDialog instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.DeleteDialog::deleteCancel = value;
  }-*/;

  private native static void _$536703305_em(RemoteUserList instance, EntityManager value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::em = value;
  }-*/;

  private native static void _$536703305_userService(RemoteUserList instance, Caller value) /*-{
    instance.@com.cosbeni.demo.mobile.component.RemoteUserList::userService = value;
  }-*/;

  private native static void _$1078139940_userListPage(Pages instance, UserListPage value) /*-{
    instance.@com.cosbeni.demo.mobile.page.Pages::userListPage = value;
  }-*/;

  private native static void _1727058671_confirmDialog(ConfirmDialogPage instance, ConfirmDialog value) /*-{
    instance.@com.cosbeni.demo.mobile.page.ConfirmDialogPage::confirmDialog = value;
  }-*/;

  private native static AnchorElement _$1137456521_add(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::add;
  }-*/;

  private native static void _$1137456521_add(UserForm instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::add = value;
  }-*/;

  private native static AnchorElement _$1137456521_update(UserForm instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserForm::update;
  }-*/;

  private native static void _$1137456521_update(UserForm instance, AnchorElement value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserForm::update = value;
  }-*/;

  private native static HTMLPanel _$1137283503_content(UserList instance) /*-{
    return instance.@com.cosbeni.demo.mobile.component.UserList::content;
  }-*/;

  private native static void _$1137283503_content(UserList instance, HTMLPanel value) /*-{
    instance.@com.cosbeni.demo.mobile.component.UserList::content = value;
  }-*/;

  // The main IOC bootstrap method.
  public BootstrapperInjectionContext bootstrapContainer() {
    declareBeans_0();
    return injContext;
  }
}