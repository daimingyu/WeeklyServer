package com.weekly.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	/**
	 * ��ȡsession����
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSession() throws IOException {
		String resource = "MybatisConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//��ȡSqlSession�Ķ��� �ܹ�ִ���Ѿ�ӡ���sql���
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
