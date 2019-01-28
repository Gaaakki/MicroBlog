package bupt.renying.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {
    
    //创建数据库连接池
    public static DataSource ds = null;
    static {
        try {
            //1.加载配置文件
            Properties p = new Properties();
            FileInputStream in;
            in = new FileInputStream("resource/db.properties");
            p.load(in);
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //从数据库连接池中取出一条连接
    public static Connection getConn() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //关闭各种资源
    public static void close(AutoCloseable... ac) {
        for(AutoCloseable c: ac) {
            if(c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
