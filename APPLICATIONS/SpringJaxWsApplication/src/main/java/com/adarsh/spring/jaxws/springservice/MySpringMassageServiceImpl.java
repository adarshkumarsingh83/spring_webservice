package com.adarsh.spring.jaxws.springservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: Adarsh_K
 * @Author: $LastChangeBy Adarsh_K
 * @Version $Revised Date: 28/1/13 Time: 1:08 PM
 * @Product This file is providing implementation for set of functionality related to.
 */
@Lazy(value = false)
@Scope(value = "singleton")
@Service(value = "mySpringMassageServiceImpl")
public class MySpringMassageServiceImpl implements MySpringMassageService {

    @Value("${app.message}")
    private String msg;

    @Override
    public String getMessage(String name) {
        return msg+" "+name+" "+new Date();
    }
}
