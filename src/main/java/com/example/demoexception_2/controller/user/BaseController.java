package com.example.demoexception_2.controller.user;


import com.example.demoexception_2.dto.request.query.user.RequestData;
import com.example.demoexception_2.dto.response.query.user.ResponseData;
import com.example.demoexception_2.handle.MessageHandleManagement;
import com.example.demoexception_2.handle.query.user.IHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    @Autowired
    protected MessageHandleManagement messageHandleManagement;
    public  <T extends ResponseData, I extends RequestData> ResponseEntity<T> excute(I request){
        IHandler handler =  messageHandleManagement.getHandler(request);
        T response = (T) handler.handle(request);
        return new ResponseEntity<T>((T) response, HttpStatus.OK);
    }
}
