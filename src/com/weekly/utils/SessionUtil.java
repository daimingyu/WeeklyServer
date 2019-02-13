package com.weekly.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	/**
	 * 获取session对象
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSession() throws IOException {
		String resource = "MybatisConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取SqlSession的对象 能够执行已经印社的sql语句
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
