package com.example.demoexception_2.handle;

import com.example.demoexception_2.dto.request.command.message.CommandRequestData;
import com.example.demoexception_2.dto.request.query.message.QueryRequestData;
import com.example.demoexception_2.dto.request.query.user.RequestData;
import com.example.demoexception_2.handle.command.user.CommandHandler;
import com.example.demoexception_2.handle.query.user.QueryHandler;
import com.example.demoexception_2.handle.query.user.IHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@AllArgsConstructor
public class MessageHandleManagement implements ApplicationContextAware {

    private final ApplicationContext context;

    Map<Class<? extends CommandRequestData>, CommandHandler> COMMAND_HANDLER_MAP = new HashMap<>();
    Map<Class<? extends QueryRequestData>, QueryHandler> QUERY_HANDLER_MAP = new HashMap<>();

    @PostConstruct
    public void initial() throws ClassNotFoundException {
        COMMAND_HANDLER_MAP = HandlerMapManagement.getCommandHandlerMap(context);
        QUERY_HANDLER_MAP = HandlerMapManagement.getQueryHandlerMap(context);
    }

    public <T extends RequestData> IHandler  getHandler(T requestData) {
        if (requestData instanceof CommandRequestData) {
            for (Class<? extends CommandRequestData> commandRequest : COMMAND_HANDLER_MAP.keySet()) {
                if (requestData.getClass().getName().equals(commandRequest.getName())) {
                    return COMMAND_HANDLER_MAP.get(commandRequest);
                }
            }
        } else if (requestData instanceof QueryRequestData) {
            for (Class<? extends QueryRequestData> queryRequest : QUERY_HANDLER_MAP.keySet()) {
                if (requestData.getClass().getName().equals(queryRequest.getName())) {
                    return QUERY_HANDLER_MAP.get(queryRequest);
                }
            }
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext){

    }
}
