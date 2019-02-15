package com.weekly.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.weekly.bean.Weekly;
import com.weekly.utils.SessionUtil;

public class WeeklyService {
	/**
	 *        添加周总结
	 * @param Weekly
	 * @return
	 */
	public Boolean insertWeekly(Weekly weekly) {
		try {
			SqlSession session = SessionUtil.getSession();
			int affect = session.insert("com.weekly.mapper.WeeklyMapper.insertWeekly", weekly);
			session.commit();
			session.close();
			return affect == 0 ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	/**
	 * 查询所有属于该用户的周总结
	 * @param userId
	 * @return
	 */
	public List<Weekly> getAllWeeklyByUserID(String userId) {
		try {
			SqlSession session = SessionUtil.getSession();
			List<Weekly> list = session.selectList("com.weekly.mapper.WeeklyMapper.getAllWeeklyByUserId", userId);
			session.close();
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	 *  删除一个weekly
	 * @param weeklyId
	 * @return
	 */
	public Boolean deleteWeeklyById(String weeklyId) {
		try {
			SqlSession session = SessionUtil.getSession();
			int affect = session.delete("com.weekly.mapper.WeeklyMapper.deleteWeeklyById", weeklyId);
			session.commit();
			session.close();
			return affect == 0 ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	/**
	 * 查询一个weekly
	 * @param userId
	 * @return
	 */
	public Weekly getAllWeeklyByWeeklyID(String weeklyId) {
		try {
			SqlSession session = SessionUtil.getSession();
			Weekly w = session.selectOne("com.weekly.mapper.WeeklyMapper.getAllWeeklyByWeeklyId", weeklyId);
			session.close();
			return w;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	/**
	 * 更新一个weekly
	 * @param weekly
	 * @return
	 */
	public Boolean updateOneWeekly(Weekly weekly) {
		try {
			SqlSession session = SessionUtil.getSession();
			int affect = session.update("com.weekly.mapper.WeeklyMapper.updateOneWeekly", weekly);
			session.commit();
			session.close();
			return affect == 0 ? false : true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
