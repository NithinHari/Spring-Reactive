package com.springflux.Spring.webflux.router;

import com.springflux.Spring.webflux.handler.CustomerHandler;
import com.springflux.Spring.webflux.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler handler;
    @Autowired
    private CustomerStreamHandler streamHandler;
    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
       return RouterFunctions.route()
               .GET("/router/customers",handler::loadCustomers)
               .GET("/router/customers/stream",streamHandler::getCustomers)
               .GET("/router/customers/{input}",handler::findCustomer)
               .POST("/router/customers/save",handler::saveCustomer)
               .build();
    }
}
