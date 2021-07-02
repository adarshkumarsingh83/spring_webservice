package com.adarsh.spring.jaxws.wsservice;

import com.adarsh.spring.jaxws.springservice.MySpringMassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @Author: Adarsh_K
 * @Author: $LastChangeBy Adarsh_K
 * @Version $Revised Date: 28/1/13 Time: 1:08 PM
 * @Product This file is providing implementation for set of functionality related to.
 */
@Lazy(value = false)
@Scope(value = "singleton")
@Service(value = "myWebServiceMassageServiceImpl")
@WebService
public class MyWebServiceMassageServiceImpl implements MyWebServiceMassageService {

    @Autowired(required = true)
    @Qualifier(value = "mySpringMassageServiceImpl")
    private MySpringMassageService mySpringMassageService;

    @Override
    public String getMessage(String name) {
        return this.mySpringMassageService.getMessage(name);
    }
}
