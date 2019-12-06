package mybatis;

/**
 * @Author jiangyunxiong
 * @Date 2019/12/6 10:42 PM
 *
 * MyBatis最核心的类
 */
public interface SqlSession {

    <T> T selectOne(String param);

    <T> T getMapper(Class<T> clazz);
}
