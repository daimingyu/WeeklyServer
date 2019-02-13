package com.weekly.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.weekly.bean.User;

public class SqlSessionTest {
	public static void main(String[] args) throws IOException {
		getSqlSession();
	}
	/**
	 * ����xml �����ļ�������һ��SQLSeccsion
	 * @throws IOException
	 */
	public static void getSqlSession() throws IOException {
		//��ȡSqlSession��������
		String resource = "MybatisConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//��ȡSqlSession�Ķ��� �ܹ�ִ���Ѿ�ӡ���sql���
		SqlSession openSession = sqlSessionFactory.openSession();
		
		//��һ������ sql����Ψһ��ʶ
		//�ڶ���Ϊsql���Ĳ���
		//��ѯһ��
		User u = openSession.selectOne("org.mybatis.example.UserMapper.selectUser", "0123456789");
		System.out.print("��ѯһ��ѧ��:"+u);
		
		//��ѯ����ѧ��
		List<User> list = openSession.selectList("org.mybatis.example.UserMapper.queryAll");
		System.out.print("��ѯ����ѧ��:"+list);
		
		//���һ��user
//		User u1 = new User("6666666666", "usermq_a", ".123456a");
//		int count = openSession.insert("org.mybatis.example.UserMapper.addUser", u1);
//		openSession.commit(); //�ύ����
//		System.out.print(count);

		//ɾ��һ��user
//		int c1 = openSession.delete("org.mybatis.example.UserMapper.deleteUser", "6666666666");
//		openSession.commit();
//		System.out.print("ɾ��һ��ѧ��:"+c1);
		
		//�޸�ѧ��
		User u2 = openSession.selectOne("org.mybatis.example.UserMapper.selectUser", "0123456789");
		u2.setPassword(".123456a");
		System.out.print(u2);
		int c2 = openSession.update("org.mybatis.example.UserMapper.updateUser", u2);
		openSession.commit();
		System.out.print("�޸�һ��ѧ��:"+c2);
		
		
		openSession.close();
}
}