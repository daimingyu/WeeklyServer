package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.bean.User;
import com.weekly.json.CheckUserLoginData;
import com.weekly.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class checkUserLogin
 */
@WebServlet("/CheckUserLogin")
public class CheckUserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * method: get
	 * return: jsonp
	 * data: jsonpCallback({"msg":"ok","code":200,"data":{"password":".123456a","loginFlag":true,"userName":"������","userId":"5906541349"}})
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���÷���ֵ����Ϊjson
		response.setContentType("application/json;charset=utf-8");
		
		//��ȡ�������Ĳ���
		String userName = URLDecoder.decode(request.getParameter("username"), "UTF-8");
		String password = request.getParameter("password");
		String callback = request.getParameter("callback");
		
		//����Service����,����û������Ƿ�Ϸ�
		UserService us = new UserService();
		Boolean flag =  us.checkUserLogin(userName, password);
		
		//����json����
		CheckUserLoginData culj;
		User user;
		if(flag) {
			user = us.getUser(userName);
			culj = new CheckUserLoginData(true, user.getUserId(), user.getUserName(), user.getPassword());
		}else {
			culj = new CheckUserLoginData(false, null, null, null);
		}
		
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(culj);
		
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
