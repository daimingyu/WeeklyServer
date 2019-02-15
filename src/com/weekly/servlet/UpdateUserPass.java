package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.json.UpdateUserNameData;
import com.weekly.json.UpdateUserPassData;
import com.weekly.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateUserPass
 */
@WebServlet("/UpdateUserPass")
public class UpdateUserPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserPass() {
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
		String password = request.getParameter("password");
		String userId = URLDecoder.decode(request.getParameter("userId"), "UTF-8");
		String callback = request.getParameter("callback");
		
		//����Service����,����û������Ƿ�Ϸ�
		UserService us = new UserService();
		//map������������
		Map<String, String> map = new HashMap<String, String>();
		map.put("password", password);
		map.put("userId", userId);
		Boolean flag =  us.updateUserPass(map);
		
		//����json����
		UpdateUserPassData uupd = new UpdateUserPassData(flag);
		
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(uupd);
		
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
