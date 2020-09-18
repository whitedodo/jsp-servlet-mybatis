package com.edu.db;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	public static SqlSessionFactory ssf;

    static{

        String resource = "com/edu/db/mybatis-config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ssf = new SqlSessionFactoryBuilder().build(inputStream);

    }
    
    public static SqlSessionFactory getSqlSessionFactory(){
        return ssf;
    }
    
}
