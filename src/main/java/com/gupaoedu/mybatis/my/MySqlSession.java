package com.gupaoedu.mybatis.my;


import java.lang.reflect.Proxy;

/**
 *  sqlsession相当于一次数据库会话，打开链接，执行sql，关闭链接。相当于jdbc的session。
 */
public class MySqlSession {
    private Executor executor = new SimpleExecutor();

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement,parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new MapperProxy<T>(this, clazz));
    }
}
