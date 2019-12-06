package mybatis;

/**
 * 执行器接口
 */
public interface Executor {
    public <T> T query(String statement);
}
