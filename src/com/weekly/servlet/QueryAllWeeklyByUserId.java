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
import com.weekly.json.StatusObject;
import com.weekly.service.WeeklyService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class getAllWeeklyByUserId
 */
@WebServlet("/QueryAllWeeklyByUserId")
public class QueryAllWeeklyByUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryAllWeeklyByUserId() {
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
			String userId = request.getParameter("userId");
			String callback = request.getParameter("callback");
			
			//����Service����,����û������Ƿ�Ϸ�
			WeeklyService us = new WeeklyService();
			List<Weekly> list =  us.getAllWeeklyByUserID(userId);
			
			//����json����
			QueryAllWeeklyByUserIdData qawbud = new QueryAllWeeklyByUserIdData(list,list.size());
			System.out.print(qawbud);
			Json json = new Json();
			json.set(StatusObject.STATUS_OK);
			json.setData(qawbud);
			
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
