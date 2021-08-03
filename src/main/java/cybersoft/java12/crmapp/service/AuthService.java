package cybersoft.java12.crmapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import cybersoft.java12.crmapp.dto.UserLoginDto;
import cybersoft.java12.crmapp.dao.AuthDao;
import cybersoft.java12.crmapp.dbconnection.MySqlConnection;

public class AuthService {

	private AuthDao dao;
	
	public AuthService() {
		dao = new AuthDao();
		
	}
	public boolean login(String username,String password)
	{
		UserLoginDto dto = null;
		
		try {
			dto = dao.findUserLogin(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(dto == null)
			return false;
		
		return BCrypt.checkpw(password, dto.getPassword());
	}
	
//	public UserLoginDto login(String email, String password) {
//		try {
//			String query="SELECT email, password FROM user Where  email=? and password=?";
//			Connection connection = MySqlConnection.getConnection();
//			PreparedStatement statement = connection.prepareStatement(query);
//			statement.setString(1, email);
//			statement.setString(2, password);
//			ResultSet result = statement.executeQuery();
//			
//			while(result.next()) {
//				UserLoginDto userAccount = new UserLoginDto(result.getString(1), result.getString(2));
//				return userAccount;
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
}
