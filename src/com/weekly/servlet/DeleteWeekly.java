package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.bean.User;
import com.weekly.json.CheckUserLoginData;
import com.weekly.json.DeleteWeeklyData;
import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.service.UserService;
import com.weekly.service.WeeklyService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class DeleteWeekly
 */
@WebServlet("/DeleteWeekly")
public class DeleteWeekly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWeekly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���÷���ֵ����Ϊjson
		response.setContentType("application/json;charset=utf-8");
		
		//��ȡ�������Ĳ���
		String weeklyId = request.getParameter("weeklyId");
		String callback = request.getParameter("callback");
		
		//����Service����,����û������Ƿ�Ϸ�
		WeeklyService ws = new WeeklyService();
		Boolean flag =  ws.deleteWeeklyById(weeklyId);
		
		//����json����
		DeleteWeeklyData dwd = new DeleteWeeklyData(flag);
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(dwd);
		
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
