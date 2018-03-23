package com.gupaoedu.mybatis.my;
import com.gupaoedu.mybatis.beans.Test;
import sun.misc.ProxyGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BootStrap {
    public static void start(){
        MySqlSession sqlSession = new MySqlSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
        createProxyClassFile(TestMapper.class);
    }

    public static void main(String[] args) {
        start();
    }

    /**
     * @param c
     */
    private static void  createProxyClassFile(Class c) {

        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[] {c});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("$Proxy0.class");

            try {
                fileOutputStream.write(data);
                fileOutputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}