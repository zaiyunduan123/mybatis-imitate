package mybatis.mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiangyunxiong
 * @Date 2019/12/6 10:38 PM
 */
public class UserMapperXML {

    public static final String namespace = "mybatis.dao.UserMapper";

    private static Map<String, String> methodSqlMap = new HashMap<String, String>();

    static{
        methodSqlMap.put("findUserById","select * from user where 1=1 and id = ?");
    }

    public static String getMethodSql(String method){
        return methodSqlMap.get(method);
    }

}
