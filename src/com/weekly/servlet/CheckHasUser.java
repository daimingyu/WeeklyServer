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
import com.weekly.json.CheckHasUserData;
import com.weekly.service.UserService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class checkHasUser
 */
@WebServlet("/CheckHasUser")
public class CheckHasUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckHasUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * method: get
	 * return: jsonp
	 * data: jsonpCallback({"msg":"ok","code":200,"data":{"hasUser":false}})
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置返回值类型为json
		response.setContentType("application/json;charset=utf-8");
		
		//获取传过来的参数
		String userName = URLDecoder.decode(request.getParameter("username"), "UTF-8");
		String callback = request.getParameter("callback");
		
		//调用Service服务,检查用户密码是否合法
		UserService us = new UserService();
		Boolean flag =  us.checkHasUser(userName);
		
		//生成json对象
		CheckHasUserData chud = new CheckHasUserData(flag);
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(chud);
		
		//将对象转化成json
		JSONObject responseText = JSONObject.fromObject(json);
				
		//返回给客户端
		response.getWriter().print(callback + "(" + responseText + ")");}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
