package io.veicot;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

@ContextName("greeter-context")
public class GreeterRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("undertow:http://localhost/hello")
                .log("Greeting to ${header.name}")
                .setBody(simple("Hello ${header.name}"));
    }
}
