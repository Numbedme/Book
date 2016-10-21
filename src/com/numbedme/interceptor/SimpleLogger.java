package com.numbedme.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * Created by User on 20.10.2016.
 */

public class SimpleLogger {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        Logger.getLogger(context.getTarget().getClass().getName()).info(context.getTarget().getClass().getSimpleName() + " invoked method " + context.getMethod().getName());
        return context.proceed();
    }

    @PostConstruct
    public void init(InvocationContext context) {
        Logger.getLogger(context.getTarget().getClass().getName()).info(context.getTarget().getClass().getSimpleName() + " is initialized");
    }

    @PreDestroy
    public void destroy(InvocationContext context){
        Logger.getLogger(context.getTarget().getClass().getName()).info(context.getTarget().getClass().getSimpleName() + " is destroyed");
    }
}
