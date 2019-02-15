package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.bean.Weekly;
import com.weekly.json.DeleteWeeklyData;
import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.json.UpdateOneWeeklyData;
import com.weekly.service.WeeklyService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateOneWeekly
 */
@WebServlet("/UpdateOneWeekly")
public class UpdateOneWeekly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOneWeekly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���÷���ֵ����Ϊjson
		response.setContentType("application/json;charset=utf-8");
		
		//��ȡ�������Ĳ���
		String weeklyName = URLDecoder.decode(request.getParameter("weeklyName"), "UTF-8");
		String workContent = URLDecoder.decode(request.getParameter("workContent"), "UTF-8");
		String solveProblems = URLDecoder.decode(request.getParameter("solveProblems"), "UTF-8");
		String summingUpExperience = URLDecoder.decode(request.getParameter("summingUpExperience"), "UTF-8");
		String remainingProblems = URLDecoder.decode(request.getParameter("remainingProblems"), "UTF-8");
		String nextWeekPlan = URLDecoder.decode(request.getParameter("nextWeekPlan"), "UTF-8");
		String userId = request.getParameter("userId");
		String weeklyId = request.getParameter("weeklyId");
		String callback = request.getParameter("callback");
		
		//����Service����,����û������Ƿ�Ϸ�
		WeeklyService ws = new WeeklyService();
		Weekly weekly = new Weekly(weeklyId, weeklyName, workContent, solveProblems, summingUpExperience, remainingProblems, nextWeekPlan, userId);
		Boolean flag =  ws.updateOneWeekly(weekly);
		
		//����json����
		UpdateOneWeeklyData uowd = new UpdateOneWeeklyData(flag);
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(uowd);
		
		//������ת����json
		JSONObject responseText = JSONObject.fromObject(json);
				
		//���ظ��ͻ���
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
