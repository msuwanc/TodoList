# TodoList

TodoList is a RESTful web service with many operations to use to manage tasks.

# Installation

1. Clone this project to your machine.

2. Import this project to your IDE.

3. Export WAR file.

4. Copy the file to your server.

5. Start your server.

# Usage

1. Make a request to ToDoList to get list of all the tasks.

 GET : http://localhost:8080/ToDoList/rest/TaskService/tasks

2. Make a request to ToDoList to get a single task.

 GET : http://localhost:8080/ToDoList/rest/TaskService/tasks/{taskid}

3. Make a request to ToDoList to add a task.

 PUT : http://localhost:8080/ToDoList/rest/TaskService/tasks/

 We consume APPLICATION_FORM_URLENCODED type with 4 parameters (id, subject, detail and status).

4. Make a request to ToDoList to edit the task.

 POST : http://localhost:8080/ToDoList/rest/TaskService/tasks/

 We consume APPLICATION_FORM_URLENCODED type with 4 parameters (id, subject, detail and status).

5. Make a request to ToDoList to set the task status.

 POST : http://localhost:8080/ToDoList/rest/TaskService/tasks/status

 We consume APPLICATION_FORM_URLENCODED type with 2 parameters (id and status).

6. Make a request to ToDoList to delete the task.

 DELETE : http://localhost:8080/ToDoList/rest/TaskService/tasks/{taskid}

7. Make a request to ToDoList to get list of all HTTP method for this service.

 OPTIONS : http://localhost:8080/ToDoList/rest/TaskService/tasks

***All methods will return an XML.
