package com.gupaoedu.mybatis.demo;

import com.gupaoedu.mybatis.beans.Test;
import com.gupaoedu.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by James on 2017/3/26.
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */
public class MyBatisDemo {

    public static SqlSession getSqlSession() throws FileNotFoundException {
        InputStream configFile = new FileInputStream("E:\\workspace\\code\\gupaoedu-mybatis\\src\\main\\java\\com\\gupaoedu\\mybatis\\demo\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        return sqlSessionFactory.openSession();
    }

    public static Test get(SqlSession sqlSession, int id) {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        return testMapper.selectByPrimaryKey(id);
    }

    public static int insert(SqlSession sqlSession, Test test) {
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        return testMapper.insert(test);
    }

    public static void main(String[] args) throws FileNotFoundException {
        SqlSession sqlSession = getSqlSession();
        try {
            System.out.println(get(sqlSession, 1));
//            System.out.println(insert(sqlSession, new Test(null, 66, "test insert")));
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
