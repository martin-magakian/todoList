package com.humanbooster.todolist;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HelloWorldResource {

    private List<Task> tasks = new ArrayList<Task>();

    @GET
    public String sayHello() {

        String tasksHtml = "";
        int i = 0;
        for(Task task : tasks){
            tasksHtml += "<div id='task_"+i+"'><a href='/view/"+i+"'>"+task.getTitle()+"</a> <a href='/delete/"+i+"'>X</a></div>";
            i++;
        }

        return tasksHtml+
                "<form action='/' method='POST'>" +
                "<div>Add Task: <input id='taskTitle' type='text' name='taskTitle' /></div>" +
                "<div>Due Date: <input id='taskDue' type='text' name='taskDue' /></div>" +
                "<input id='submit' type='submit' />"+
                "</form>";
    }

    @POST
    public Response createTask(@FormParam("taskTitle") String taskTitle, @FormParam("taskDue") String taskDue) {
        tasks.add(new Task(taskTitle, taskDue));
        URI redirect = UriBuilder.fromUri("/").build();
        return Response.seeOther(redirect).build();
    }

    @GET
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        tasks.remove(id);
        URI redirect = UriBuilder.fromUri("/").build();
        return Response.seeOther(redirect).build();
    }

    @GET
    @Path("/view/{id}")
    public String view(@PathParam("id") int id) {
        Task taskToDisplay = tasks.get(id);
        return "Task:"+ taskToDisplay.getTitle()+" due date: "+taskToDisplay.getDueDate();
    }
}
