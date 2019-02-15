package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.naming.ldap.HasControls;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.bean.User;
import com.weekly.json.CheckUserLoginData;
import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.json.UpdateUserNameData;
import com.weekly.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateUserName
 */
@WebServlet("/UpdateUserName")
public class UpdateUserName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserName() {
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
		String userName = URLDecoder.decode(request.getParameter("username"), "UTF-8");
		String userId = URLDecoder.decode(request.getParameter("userid"), "UTF-8");
		String callback = request.getParameter("callback");
		
		//����Service����,����û������Ƿ�Ϸ�
		UserService us = new UserService();
		//map������������
		Map<String, String> map = new HashMap<String, String>();
		map.put("userName", userName);
		map.put("userId", userId);
		Boolean flag =  us.updateUserName(map);
		
		//����json����
		UpdateUserNameData uund = new UpdateUserNameData(flag);
		
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(uund);
		
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
