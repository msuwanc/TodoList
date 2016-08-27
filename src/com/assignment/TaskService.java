package com.assignment;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/TaskService")
public class TaskService {

	TaskDao taskDao = new TaskDao();
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	@GET
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_XML)
	public List<Task> getTasks() {
		return taskDao.getAllTasks();
	}

	@GET
	@Path("/tasks/{taskid}")
	@Produces(MediaType.APPLICATION_XML)
	public Task getTask(@PathParam("taskid") int taskid) {
		return taskDao.getTask(taskid);
	}

	@PUT
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String createTask(@FormParam("id") int id, @FormParam("subject") String subject,
			@FormParam("detail") String detail, @FormParam("status") String status,
			@Context HttpServletResponse servletResponse) throws IOException {
		Task task = new Task(id, subject, detail, status);
		int result = taskDao.addTask(task);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@POST
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateTask(@FormParam("id") int id, @FormParam("subject") String subject,
			@FormParam("detail") String detail, @FormParam("status") String status,
			@Context HttpServletResponse servletResponse) throws IOException {
		Task task = new Task(id, subject, detail, status);
		int result = taskDao.updateTask(task);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@POST
	@Path("/tasks/status")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String updateStatus(@FormParam("id") int id, @FormParam("status") String status,
			@Context HttpServletResponse servletResponse) throws IOException {
		Task task = new Task(id, "subject", "detail", status);
		int result = taskDao.updateTask(task);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@DELETE
	@Path("/tasks/{taskid}")
	@Produces(MediaType.APPLICATION_XML)
	public String deleteTask(@PathParam("taskid") int taskid) {
		int result = taskDao.deleteTask(taskid);
		if (result == 1) {
			return SUCCESS_RESULT;
		}
		return FAILURE_RESULT;
	}

	@OPTIONS
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_XML)
	public String getSupportedOperations() {
		return "<operations>GET, PUT, POST, DELETE</operations>";
	}
}
