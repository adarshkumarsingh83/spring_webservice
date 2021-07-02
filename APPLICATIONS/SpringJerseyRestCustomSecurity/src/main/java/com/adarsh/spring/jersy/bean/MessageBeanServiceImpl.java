package com.adarsh.spring.jersy.bean;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.Date;

@Scope(value = "singleton")
@Service(value = "messageBeanServiceImpl")
public class MessageBeanServiceImpl implements MessageBeanService {

    @Override
    public String getMessage() {
        return "HI Adarsh "+new Date();
    }
}
