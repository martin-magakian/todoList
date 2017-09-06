package com.humanbooster.todolist;

import io.dropwizard.views.View;

public class PersonView extends View {
    private final Task task;

    public PersonView(Task task) {
        super("task.ftl");
        this.task = task;
    }

}