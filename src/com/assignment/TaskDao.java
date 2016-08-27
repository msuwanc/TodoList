package com.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

	public List<Task> getAllTasks() {
		List<Task> taskList = null;
		try {
			File file = new File("Tasks.dat");
			if (!file.exists()) {
				Task task = new Task(1, "Subject", "Detail", "Status");
				taskList = new ArrayList<Task>();
				taskList.add(task);
				saveTaskList(taskList);
			} else {
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				taskList = (List<Task>) ois.readObject();
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	public Task getTask(int id) {
		List<Task> tasks = getAllTasks();

		for (Task task : tasks) {
			if (task.getId() == id) {
				return task;
			}
		}
		return null;
	}

	public int addTask(Task pTask) {
		List<Task> taskList = getAllTasks();
		boolean taskExists = false;
		for (Task task : taskList) {
			if (task.getId() == pTask.getId()) {
				taskExists = true;
				break;
			}
		}
		if (!taskExists) {
			taskList.add(pTask);
			saveTaskList(taskList);
			return 1;
		}
		return 0;
	}

	public int updateTask(Task pTask) {
		List<Task> taskList = getAllTasks();

		for (Task task : taskList) {
			if (task.getId() == pTask.getId()) {
				int index = taskList.indexOf(task);
				taskList.set(index, pTask);
				saveTaskList(taskList);
				return 1;
			}
		}
		return 0;
	}

	public int updateStatus(int pId, String pStatus) {
		List<Task> taskList = getAllTasks();

		for (Task task : taskList) {
			if (task.getId() == pId) {
				int index = taskList.indexOf(task);

				Task tempTask = new Task(taskList.get(index).getId(), taskList.get(index).getSubject(),
						taskList.get(index).getDetail(), pStatus);
				taskList.set(index, tempTask);

				saveTaskList(taskList);
				return 1;
			}
		}
		return 0;
	}

	public int deleteTask(int id) {
		List<Task> taskList = getAllTasks();

		for (Task task : taskList) {
			if (task.getId() == id) {
				int index = taskList.indexOf(task);
				taskList.remove(index);
				saveTaskList(taskList);
				return 1;
			}
		}
		return 0;
	}

	private void saveTaskList(List<Task> taskList) {
		try {
			File file = new File("Tasks.dat");
			FileOutputStream fos;

			fos = new FileOutputStream(file);

			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(taskList);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
