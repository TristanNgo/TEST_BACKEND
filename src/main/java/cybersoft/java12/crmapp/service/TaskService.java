package cybersoft.java12.crmapp.service;

import java.sql.SQLException;
import java.util.List;


import cybersoft.java12.crmapp.dao.TaskDao;
import cybersoft.java12.crmapp.dto.TaskCreateDto;
import cybersoft.java12.crmapp.model.Task;

public class TaskService {

	private TaskDao dao;
	
	public TaskService() {
		dao = new TaskDao();
	}
	public List<Task> findAll() {
		List<Task> tasks = null;
		try {
			tasks = dao.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return tasks;
	}
	public void deleteById(int id) {
		try {
			dao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Task findTaskById(int id) {
		Task task = new Task();
		try {
			task = dao.findTaskById(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;

	}

	public void updateTask(TaskCreateDto taskDto) {
		try {
			dao.updateTask(taskDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(TaskCreateDto taskDto) {
		try {
			dao.addTask(taskDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
