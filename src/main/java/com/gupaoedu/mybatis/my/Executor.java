package com.gupaoedu.mybatis.my;

/**
 * 在MyBatis中，select有多种形式，比如selectOne,selectList，那么其实到最后，还是向JDBC发出一个SQL而已。对于执行器而言，其实对于查询，提供一个query接口就可以了。
 */
public interface Executor {
    <E> E query(String statement, Object parameter);
}