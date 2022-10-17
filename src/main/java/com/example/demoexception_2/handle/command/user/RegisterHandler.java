package com.example.demoexception_2.handle.command.user;

import com.example.demoexception_2.dto.request.query.user.RequestData;
import com.example.demoexception_2.dto.response.query.user.ResponseData;
import com.example.demoexception_2.handle.query.user.IHandler;

public abstract class RegisterHandler <T extends RequestData, I extends ResponseData> implements IHandler<T, I> {
}
