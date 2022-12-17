package tw.com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tw.com.beans.User;

public class MySqlUser implements UserDao {

	@Override
	public boolean login(String account, String password) {
		// TODO Auto-generated method stub
		User user = findUserByAccount(account);
		if (user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean regisrter(String account, String password) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user_info(account,password) VALUES(?,?)";
		try(Connection conn = DbTools.getConnection();
			PreparedStatement	stm = conn.prepareStatement(sql)){
			stm.setString(1, account);
			stm.setString(2, password);
			int count = stm.executeUpdate();
			return count > 0; 
			
		}catch(SQLException ex) {
			
			System.out.println(ex);
		}
		return false;
	}

	@Override
	public User findUserByAccount(String account) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user_info WHERE account = ?";
		try(Connection conn = DbTools.getConnection();
			PreparedStatement stm = conn.prepareStatement(sql)){
			stm.setString(1, account);
			ResultSet result = stm.executeQuery();
			if (result.next()) {
				int id = result.getInt(1);
				String resAccount = result.getString(2);
				String resPassword = result.getString(3);
				User user = new User();
				user.setId(id);
				user.setAccount(resAccount);
				user.setPassword(resPassword);
				return user;
				
			}
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

}
