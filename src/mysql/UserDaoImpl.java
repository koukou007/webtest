package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    //添加用户
	@Override
	public void addUser(String name,String password) {
		// TODO Auto-generated method stub
	    Connection conn = DButil.getConn();
	    String sql = "insert into stu(name,password) values(?,?)";
	    boolean rs ;
	    try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			
			rs = pstm.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("添加失败");
		}
	}
    //按照用户名和用户密码查询用户
	@Override
	public User queryUser(String name, String password) {
		// TODO Auto-generated method stub
		Connection conn = DButil.getConn();
		String sql ="select * from stu where name = ? and password =?";
		ResultSet rs ;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if(rs.next()){
				User user = new User();
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	

}
