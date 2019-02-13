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
	 * 根据xml 配置文件，创建一个SQLSeccsion
	 * @throws IOException
	 */
	public static void getSqlSession() throws IOException {
		//获取SqlSession工厂方法
		String resource = "MybatisConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//获取SqlSession的对象 能够执行已经印社的sql语句
		SqlSession openSession = sqlSessionFactory.openSession();
		
		//第一个参数 sql语句的唯一标识
		//第二个为sql语句的参数
		//查询一个
		User u = openSession.selectOne("org.mybatis.example.UserMapper.selectUser", "0123456789");
		System.out.print("查询一个学生:"+u);
		
		//查询所有学生
		List<User> list = openSession.selectList("org.mybatis.example.UserMapper.queryAll");
		System.out.print("查询所有学生:"+list);
		
		//添加一个user
//		User u1 = new User("6666666666", "usermq_a", ".123456a");
//		int count = openSession.insert("org.mybatis.example.UserMapper.addUser", u1);
//		openSession.commit(); //提交事务
//		System.out.print(count);

		//删除一个user
//		int c1 = openSession.delete("org.mybatis.example.UserMapper.deleteUser", "6666666666");
//		openSession.commit();
//		System.out.print("删除一个学生:"+c1);
		
		//修改学生
		User u2 = openSession.selectOne("org.mybatis.example.UserMapper.selectUser", "0123456789");
		u2.setPassword(".123456a");
		System.out.print(u2);
		int c2 = openSession.update("org.mybatis.example.UserMapper.updateUser", u2);
		openSession.commit();
		System.out.print("修改一个学生:"+c2);
		
		
		openSession.close();
}
}