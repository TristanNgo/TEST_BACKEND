package cybersoft.java12.crmapp.service;

import java.sql.SQLException;
import java.util.List;

import cybersoft.java12.crmapp.dao.ProjectUserDao;
import cybersoft.java12.crmapp.model.Project_User;

public class ProjectUserService {
	private ProjectUserDao projectuserDao;
	
	public ProjectUserService() {
		projectuserDao = new ProjectUserDao();
	}
	
	public List<Project_User> findAllPU(int id){
		List<Project_User> projects = null;
		try {
			projects = projectuserDao.findAllPU(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return projects;
	}
	 public void add(Project_User projectdto) {
			
			try {
				projectuserDao.add(projectdto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	 public void deleteById(int project_id, int user_id) {
			try {
				projectuserDao.deleteById(project_id,user_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
