package cybersoft.java12.crmapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java12.crmapp.dbconnection.MySqlConnection;
import cybersoft.java12.crmapp.dto.RoleCreateDto;
import cybersoft.java12.crmapp.dto.StatusCreateDto;
import cybersoft.java12.crmapp.model.Role;
import cybersoft.java12.crmapp.model.Status;

public class StatusDao {
	public List<Status> findAll(){
		List<Status> statuss = new LinkedList<Status>();
 
 try {
		Connection connection = MySqlConnection.getConnection();
		
		String query ="SELECT * FROM status";
		PreparedStatement statement = connection.prepareStatement(query);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			Status status = new Status();
			status.setId(resultSet.getInt("id"));
			status.setName(resultSet.getString("name"));
			status.setDescription(resultSet.getString("Description"));
			statuss.add(status);
		}
		connection.close();
		
	} catch (Exception e) {
		System.out.println("Unable to connect to database.");
		e.printStackTrace();
	}
	return statuss;
	

}
	// delete
		public void deleteById(int id) throws SQLException {
			Connection connection = MySqlConnection.getConnection();
			String query = "DELETE FROM status WHERE id = ?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, id);
				statement.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("Unable to connect to database.");
				e.printStackTrace();
			
			}
			finally {
				connection.close();
			
			}
		}
		
		public void add(StatusCreateDto statusdto) throws SQLException {
			String query = "INSERT INTO status(name,description)"
					+ "VALUES(?,?)";
			
			Connection connection = MySqlConnection.getConnection();
			
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				
			
				statement.setNString(1, statusdto.getName());
				statement.setNString(2, statusdto.getDescription());
				
				
				statement.executeUpdate();
				
			}catch (SQLException e) {
				System.out.println("Unable to connect to database.");
				e.printStackTrace();
			} finally {
				connection.close();
				}
			}
		public Status findById(int id) {
			Status status = new Status();
			Connection connection = MySqlConnection.getConnection();
			String query ="SELECT * FROM status WHERE id=?";
			
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
				
				while(resultSet.next()) {
					
					status.setId(resultSet.getInt("id"));
					status.setName(resultSet.getString("name"));
					status.setDescription(resultSet.getString("description"));
					
				}
				connection.close();
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return status;
		}
		public void update(StatusCreateDto statusdto) throws SQLException {
			String query = "UPDATE status set name=?, description=? WHERE id=?";
			
			Connection connection = MySqlConnection.getConnection();
			
			try {
				PreparedStatement statement = connection.prepareStatement(query);
				
				
				statement.setNString(1, statusdto.getName());
				statement.setNString(2, statusdto.getDescription());
				
				statement.setInt(3,statusdto.getId());
				
				
				statement.executeUpdate();
				
			}catch (SQLException e) {	
				System.out.println("Unable to connect to database.");
				e.printStackTrace();
			} finally {
				connection.close();
			}
		
		}
	
}
