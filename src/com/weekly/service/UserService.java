package com.weekly.service;

import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.weekly.bean.User;
import com.weekly.utils.SessionUtil;

public class UserService {
	/**
	 * �ж��û����������Ƿ�һ��
	 * @param userName
	 * @param password
	 * @return
	 */
	public Boolean checkUserLogin(String userName, String password) {
		try {
			//������
			SqlSession session = SessionUtil.getSession();
			User u = session.selectOne("com.weekly.mapper.UserMapper.getUserbyName", userName);
			session.close();
			return u != null ? password.equals(u.getPassword()) : false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	/**
	 * �����û��� �����û��Ƿ����
	 * @param userName
	 * @return
	 */
	public Boolean checkHasUser(String userName) {
		try {
			SqlSession session = SessionUtil.getSession();
			User u = session.selectOne("com.weekly.mapper.UserMapper.getUserbyName", userName);
			session.close();
			return u != null ? true : false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	/**
	 * �����û�����ȡ�û�
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
		try {
			SqlSession session = SessionUtil.getSession();
			User user = session.selectOne("com.weekly.mapper.UserMapper.getUserbyName", username);
			session.close();
			return user;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	 *        ����û�
	 * @param user
	 * @return
	 */
	public Boolean insertUser(User user) {
		try {
			SqlSession session = SessionUtil.getSession();
			int affect = session.insert("com.weekly.mapper.UserMapper.insertUser", user);
			session.commit();
			session.close();
			return affect == 0 ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	/**
	 * �����û���
	 * @param user
	 * @return
	 */
	public Boolean updateUserName(Map<String, String> map) {
		try {
			SqlSession session = SessionUtil.getSession();
			int affect = session.update("com.weekly.mapper.UserMapper.updateUserName", map);
			session.commit();
			session.close();
			return affect == 0 ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	/**
	 * �����û�����
	 * @param map
	 * @return
	 */
	public Boolean updateUserPass(Map<String, String> map) {
		try {
			SqlSession session = SessionUtil.getSession();
			int affect = session.update("com.weekly.mapper.UserMapper.updateUserPass", map);
			session.commit();
			session.close();
			return affect == 0 ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
