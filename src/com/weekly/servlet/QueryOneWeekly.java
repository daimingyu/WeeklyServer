package com.weekly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.bean.Weekly;
import com.weekly.json.Json;
import com.weekly.json.QueryAllWeeklyByUserIdData;
import com.weekly.json.QueryOneWeeklyData;
import com.weekly.json.StatusObject;
import com.weekly.service.WeeklyService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class QueryOneWeekly
 */
@WebServlet("/QueryOneWeekly")
public class QueryOneWeekly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOneWeekly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置返回值类型为json
		response.setContentType("application/json;charset=utf-8");
		
		//获取传过来的参数
		String weeklyId = request.getParameter("weeklyId");
		String callback = request.getParameter("callback");
		
		//调用Service服务,检查用户密码是否合法
		WeeklyService us = new WeeklyService();
		Weekly weekly =  us.getAllWeeklyByWeeklyID(weeklyId);
		
		//生成json对象
		QueryOneWeeklyData qowd = new QueryOneWeeklyData(weekly);
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(qowd);
		
		//将对象转化成json
		JSONObject responseText = JSONObject.fromObject(json);
				
		//返回给客户端
		response.getWriter().print(callback + "(" + responseText + ")");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
