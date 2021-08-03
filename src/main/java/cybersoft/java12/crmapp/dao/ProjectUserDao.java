package cybersoft.java12.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.crmapp.dbconnection.MySqlConnection;
import cybersoft.java12.crmapp.model.Project;
import cybersoft.java12.crmapp.model.Project_User;

public class ProjectUserDao {

	public List<Project_User> findAllPU(int id) {
		List<Project_User> project_users = new LinkedList<Project_User>();
		String query = "SELECT p.id as project_id, u.id as user_id, u.name as user_name, p.name as project_name,u.email as email,"
				+ " u.phone as phone,pu.join_date,pu.role_description"
				+ " FROM user u, project p, project_user pu WHERE u.id = pu.user_id and p.id = pu.project_id and project_id = ?";

		try {
			Connection connection = MySqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Project_User project_user = new Project_User();
				project_user.setUser_id(resultSet.getInt("user_id"));
				project_user.setProject_id(resultSet.getInt("project_id"));
				project_user.setProject_name(resultSet.getString("project_name"));
				project_user.setUser_name(resultSet.getString("user_name"));
				project_user.setEmail(resultSet.getString("email"));
				project_user.setPhone(resultSet.getString("phone"));
				project_user.setRole_description(resultSet.getString("role_description"));
				project_user.setJoin_date(resultSet.getDate("join_date"));
				project_users.add(project_user);
			}
			connection.close();

		} catch (Exception e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		}
		return project_users;

	}

	public void deleteById(int project_id, int user_id) throws SQLException {
		Connection connection = MySqlConnection.getConnection();
		String query = "delete from project_user where project_id = ? and user_id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, project_id);
			statement.setInt(2, user_id);
			statement.executeUpdate();

		} catch (Exception e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();

		} finally {
			connection.close();

		}
	}

	public void add(Project_User projectdto) throws SQLException {
		String query = "INSERT INTO project_user(project_id, user_id,join_date, role_description)" + "VALUES(?,?,?,?)";

		Connection connection = MySqlConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setInt(1, projectdto.getProject_id());
			statement.setInt(2, projectdto.getUser_id());
			statement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			statement.setString(4, projectdto.getRole_description());
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Unable to connect to database.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
