package cybersoft.java12.crmapp.service;

import java.sql.SQLException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import cybersoft.java12.crmapp.dao.RoleDao;
import cybersoft.java12.crmapp.dto.RoleCreateDto;

import cybersoft.java12.crmapp.model.Role;

public class RoleService {
	private RoleDao roleDao;

	public RoleService() {
		roleDao = new RoleDao();
	}

	public List<Role> findAll() {
		List<Role> roles = null;
		try {
			roles = roleDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

	public Role findById(int id) {
		Role role = new Role();

		try {
			role = roleDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	public void deleteById(int id) {
		try {
			roleDao.deleteById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(RoleCreateDto rodto) {
		try {
			roleDao.add(rodto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(RoleCreateDto rodto) {
		try {
			roleDao.update(rodto);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
