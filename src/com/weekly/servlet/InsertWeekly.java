package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.bean.Weekly;
import com.weekly.json.InsertWeeklyData;
import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.service.WeeklyService;
import com.weekly.utils.RandomUID;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class InsertWeekly
 */
@WebServlet("/InsertWeekly")
public class InsertWeekly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertWeekly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���÷���ֵ����Ϊjson
		response.setContentType("application/json;charset=utf-8");
	    //����ͻ��˷��ʽ����������
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		
		//��ȡ�������Ĳ���
		String weeklyName = URLDecoder.decode(request.getParameter("weeklyName"), "UTF-8");
		String workContent = URLDecoder.decode(request.getParameter("workContent"), "UTF-8");
		String solveProblems = URLDecoder.decode(request.getParameter("solveProblems"), "UTF-8");
		String summingUpExperience = URLDecoder.decode(request.getParameter("summingUpExperience"), "UTF-8");
		String remainingProblems = URLDecoder.decode(request.getParameter("remainingProblems"), "UTF-8");
		String nextWeekPlan = URLDecoder.decode(request.getParameter("nextWeekPlan"), "UTF-8");
		String userId = request.getParameter("userId");
		
		
		//����Service����,�����û�
		WeeklyService us = new WeeklyService();
		String wid = RandomUID.getRandomNumber(10);
		Weekly weekly = new Weekly(wid, weeklyName, workContent, solveProblems, summingUpExperience, remainingProblems, nextWeekPlan, userId);
		System.out.print(weekly);
		Boolean flag =  us.insertWeekly(weekly);
		
		//����json����
		InsertWeeklyData iwd = new InsertWeeklyData(flag);
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(iwd);
		
		//������ת����json
		JSONObject responseText = JSONObject.fromObject(json);
				
		//���ظ��ͻ���
		response.getWriter().print(responseText);
	}
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

}
