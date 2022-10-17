package com.example.demoexception_2.handle;

import com.example.demoexception_2.dto.request.command.message.CommandRequestData;
import com.example.demoexception_2.dto.request.query.message.QueryRequestData;
import com.example.demoexception_2.handle.command.user.CommandHandler;
import com.example.demoexception_2.handle.query.user.QueryHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

@Component
public class HandlerMapManagement {
    public static Map<Class<? extends CommandRequestData>, CommandHandler> getCommandHandlerMap(ApplicationContext context) throws ClassNotFoundException {

        Map<Class<? extends CommandRequestData>, CommandHandler> mapCommandHandler = new HashMap<>();

        Map<String, CommandHandler> listCommand = context.getBeansOfType(CommandHandler.class);

        listCommand.forEach((key, value) -> {

            String requestBeanName = ((ParameterizedType) value.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();
            Class request = getClassByName(requestBeanName);

            mapCommandHandler.put(request, value);
        });
        return mapCommandHandler;
    }

    public static Map<Class<? extends QueryRequestData>, QueryHandler> getQueryHandlerMap(ApplicationContext context) throws ClassNotFoundException {

        Map<Class<? extends QueryRequestData>, QueryHandler> mapQueryHandler = new HashMap<>();

        Map<String, QueryHandler> listQuery = context.getBeansOfType(QueryHandler.class);

        listQuery.forEach((key, value) -> {

            String requestBeanName = ((ParameterizedType) value.getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0]
                    .getTypeName();
            Class request = getClassByName(requestBeanName);

            mapQueryHandler.put(request, value);
        });
        return mapQueryHandler;
    }

    private static Class getClassByName(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.toString());
        }
        return null;
    }


}
