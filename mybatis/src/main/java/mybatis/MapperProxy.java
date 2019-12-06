package mybatis;

import mybatis.mapper.UserMapperXML;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author jiangyunxiong
 * @Date 2019/12/6 10:48 PM
 */
public class MapperProxy implements InvocationHandler {
    private SqlSession sqlSession;

    public MapperProxy() {
    }

    public MapperProxy(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 通过反射获取mapper接口和方法名称、参数，然后调用执行器实现真正调用
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String mapperClass = method.getDeclaringClass().getName();
        if (UserMapperXML.namespace.equals(mapperClass)) {
            String methodName = method.getName();
            String methodSql = UserMapperXML.getMethodSql(methodName);
            String mergeSql = String.format(methodSql, String.valueOf(args[0]));
            return sqlSession.selectOne(mergeSql);
        }
        return null;
    }
}
