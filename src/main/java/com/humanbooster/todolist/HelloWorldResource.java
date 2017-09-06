package com.humanbooster.todolist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {

    public HelloWorldResource() {
    }

    @GET
    @Path("/simple")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "hello world";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/complex")
    public PersonView sayHelloH1(@QueryParam("name") String name) {
        return new PersonView(new Person(name));
    }


}
