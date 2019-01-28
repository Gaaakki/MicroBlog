package bupt.renying.microblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bupt.renying.microblog.domain.User;
import bupt.renying.microblog.handler.IResultSetHandler;
import bupt.renying.util.JdbcUtil;

public class UserDao {
      
    //检查登录账号密码是否正确
    public boolean login(String name, String password) throws Exception {
        Connection conn = JdbcUtil.getConn();
        String sql = "select * from user where name = ? and password = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, password);
        
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            JdbcUtil.close(conn, st, rs);
            return true;
        }
        JdbcUtil.close(conn, st, rs);
        return false;
    }
    
}

class UserResultSetHandImp implements IResultSetHandler<List<User>> {

    @Override
    public List<User> handle(ResultSet rs) throws Exception {
        List<User> list = new ArrayList<>();
        while(rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setName(rs.getString("password"));
            list.add(user);
        }
        return list;
    }
    
}