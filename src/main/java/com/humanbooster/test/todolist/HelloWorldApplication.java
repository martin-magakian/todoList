package com.humanbooster.test.todolist;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // active Mustache
        bootstrap.addBundle(new ViewBundle<HelloWorldConfiguration>());
    }

    @Override
    public void run(HelloWorldConfiguration configuration, Environment environment) {
        // enable HelloWorldResource
        final HelloWorldResource resource = new HelloWorldResource();
        environment.jersey().register(resource);
    }

}