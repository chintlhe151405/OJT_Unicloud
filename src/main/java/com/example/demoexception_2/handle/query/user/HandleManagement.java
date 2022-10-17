package com.example.demoexception_2.handle.query.user;

import com.example.demoexception_2.dto.request.query.user.RequestData;
import com.example.demoexception_2.dto.request.command.user.CommandRequestData;
import com.example.demoexception_2.dto.request.command.user.RegisterCommandRequestData;
import com.example.demoexception_2.dto.request.query.user.GetUserQueryRequestData;
import com.example.demoexception_2.dto.request.query.user.LoginQueryRequestData;
import com.example.demoexception_2.dto.request.query.user.QueryRequestData;
import com.example.demoexception_2.handle.command.user.RegisterHandler;
import com.example.demoexception_2.handle.query.user.LoginHandler;
import com.example.demoexception_2.handle.query.user.UserInforHandle;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
@Component
public class HandleManagement implements ApplicationContextAware {
    private ApplicationContext context;

    private Map<Class<? extends LoginQueryRequestData>, LoginHandler> LOGIN_HANDLER_MAP = new HashMap<>();
    private Map<Class<? extends RegisterCommandRequestData>, RegisterHandler> REGISTER_HANDLER_MAP = new HashMap<>();
    private Map<Class<? extends GetUserQueryRequestData>, UserInforHandle> USERINFOR_HANDLE_MAP = new HashMap<>();

    public <I extends RequestData> LoginHandler getHandle(I requestData) {
        if (requestData instanceof QueryRequestData){
            return getCommandHandler(requestData);
        }
        return null;
    }
    public <I extends RequestData> RegisterHandler getHandleRegister(I requestData) {
        if (requestData instanceof CommandRequestData){
            return getCommandRegisterHandler(requestData);
        }
        return null;
    }

    public <I extends RequestData> UserInforHandle getHandleUser(I requestData) {
        if (requestData instanceof QueryRequestData){
            return getQueryUserInforHandler(requestData);
        }
        return null;
    }
    public <T extends RequestData> UserInforHandle getQueryUserInforHandler(T requestData){
        return USERINFOR_HANDLE_MAP.get(requestData.getClass());
    }
    public <T extends RequestData> RegisterHandler getCommandRegisterHandler(T requestData){
        return REGISTER_HANDLER_MAP.get(requestData.getClass());
    }
    public <T extends RequestData> LoginHandler getCommandHandler(T requestData){
        return LOGIN_HANDLER_MAP.get(requestData.getClass());
    }
    @PostConstruct
    private void init() {
        initLoginHandlerMap();
       // System.err.println(LOGIN_HANDLER_MAP);

        initRegisterHandlerMap();
       // System.err.println(REGISTER_HANDLER_MAP);

        initUserInforHandlerMap();
        //System.err.println(USERINFOR_HANDLE_MAP);
    }
    public void initUserInforHandlerMap(){
        Map<String, UserInforHandle> handles = context.getBeansOfType(UserInforHandle.class);

        handles.forEach((key, value) -> {
            UserInforHandle handle = value;

            String requestBeanName = ((ParameterizedType) handle.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();
            Class request = getClassByName(requestBeanName);

            USERINFOR_HANDLE_MAP.put(request, handle);
        });
    }
    public void initLoginHandlerMap(){
        Map<String, LoginHandler> handles = context.getBeansOfType(LoginHandler.class);

        handles.forEach((key, value) -> {
            LoginHandler handle = value;

            String requestBeanName = ((ParameterizedType) handle.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();
            Class request = getClassByName(requestBeanName);

            LOGIN_HANDLER_MAP.put(request, handle);
        });
    }
    public void initRegisterHandlerMap(){
        Map<String, RegisterHandler> handles = context.getBeansOfType(RegisterHandler.class);

        handles.forEach((key, value) -> {
            RegisterHandler handle = value;

            String requestBeanName = ((ParameterizedType) handle.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();
            Class request = getClassByName(requestBeanName);

            REGISTER_HANDLER_MAP.put(request, handle);
        });
    }
    private Class getClassByName(String name){
        try {
            Class newClass = Class.forName(name);
            return newClass;
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return null;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
