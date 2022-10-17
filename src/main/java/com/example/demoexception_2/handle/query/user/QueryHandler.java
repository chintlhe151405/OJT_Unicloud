package com.example.demoexception_2.handle.query.user;

import com.example.demoexception_2.dto.request.query.message.QueryRequestData;
import com.example.demoexception_2.dto.response.query.message.QueryResponseData;
import com.example.demoexception_2.handle.query.user.IHandler;

public abstract class QueryHandler <T extends QueryRequestData, I extends QueryResponseData> implements IHandler<T, I> {
}
