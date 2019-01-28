package bupt.renying.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bupt.renying.microblog.handler.IResultSetHandler;

public class ExecuteCRUD {
    
    public static void executeUpdate(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps);
        }
    }
    
    public static <T>T executeQuery(String sql, IResultSetHandler<T> rh, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            return rh.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(conn, ps, rs);
        }
        return null;
    }
}
