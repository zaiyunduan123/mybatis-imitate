package mybatis;

import java.lang.reflect.Proxy;

/**
 * @Author jiangyunxiong
 * @Date 2019/12/6 10:45 PM
 *
 *
 */
public class DefaultSqlSession implements SqlSession {

    private Executor executor = new BaseExector();

    public <T> T selectOne(String param) {
        return executor.query(param);
    }

    // 通过jdk动态代理实现SqlSession对象的getMapper方法获取对应Mapper接口的代理对象，接口本身不能执行，可以执行的是其代理对象
    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz}, new MapperProxy(this));
    }
}
