package com.humanbooster.todolist;

/**
 * Created by sochipan on 02/09/17.
 */
public class Task {

    private final String dueDate;
    private String title;

    public Task(String title, String dueDate){
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }
}
