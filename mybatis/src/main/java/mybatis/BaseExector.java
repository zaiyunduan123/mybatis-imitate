package mybatis;


import mybatis.bean.User;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * @Author jiangyunxiong
 * @Date 2019/12/6 10:24 PM
 *
 * 执行器：真正执行Java与数据库交互的东西，参与了整个SQL查询执行过程中
 */
public class BaseExector implements Executor {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 真正执行Java与数据库交互的方法
    public <T> T query(String statement) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//          String sql = "select * from user where 1=1 and id = ?";
            PreparedStatement stmt = conn.prepareStatement(statement);
            ResultSet resultSet = stmt.executeQuery();

            Class<User> userClass = User.class;
            User user = null;
            if (resultSet.next()){
                //使用反射获取对象并把结果集填充到对象里面
                user = userClass.newInstance();
                Field[] declaredFields = userClass.getDeclaredFields();
                for (Field field : declaredFields){
                    field.setAccessible(true);
                    field.set(user, resultSet.getObject(field.getName()));
                }
            }
            return (T) user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
