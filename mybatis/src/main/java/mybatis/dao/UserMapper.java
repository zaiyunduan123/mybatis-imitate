package mybatis.dao;

import mybatis.bean.User;

public interface UserMapper {

    void insert(User user);

    User findUserById(Long id);
}
