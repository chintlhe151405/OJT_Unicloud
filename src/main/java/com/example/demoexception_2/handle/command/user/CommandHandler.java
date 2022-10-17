package com.example.demoexception_2.handle.command.user;

import com.example.demoexception_2.dto.request.command.message.CommandRequestData;
import com.example.demoexception_2.dto.response.command.message.CommandResponseData;
import com.example.demoexception_2.handle.query.user.IHandler;

public abstract class CommandHandler <T extends CommandRequestData, I extends CommandResponseData> implements IHandler<T, I> {
}
