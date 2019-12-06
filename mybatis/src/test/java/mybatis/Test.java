package mybatis;

import mybatis.dao.UserMapper;
import mybatis.bean.User;

/**
 * @Author jiangyunxiong
 * @Date 2019/12/6 10:55 PM
 */
public class Test {

    public static void main(String[] args) {
        DefaultSqlSession defaultSqlSession = new DefaultSqlSession();
        // mapper映射器其实就是一个动态代理对象，进入到MapperMethod的方法就能找到SqlSession的删除、更新、查询、选择方法，从底层实现来说：通过动态代理技术，让接口跑起来
        UserMapper mapper = defaultSqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1L);
        System.out.println(user);
    }
}
