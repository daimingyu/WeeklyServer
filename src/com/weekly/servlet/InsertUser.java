package com.weekly.servlet;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekly.bean.User;
import com.weekly.json.Json;
import com.weekly.json.StatusObject;
import com.weekly.json.InsertUserData;
import com.weekly.service.UserService;
import com.weekly.utils.RandomUID;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class insertUser
 */
@WebServlet("/InsertUser")
public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * method: get
	 * return: jsonp
	 * data: jsonpCallback({"msg":"ok","code":200,"data":{"success":true}})
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置返回值类型为json
		response.setContentType("application/json;charset=utf-8");
		
		//获取传过来的参数
		String userName = URLDecoder.decode(request.getParameter("username"), "UTF-8");
		String password = request.getParameter("password");
		String callback = request.getParameter("callback");
		
		System.out.print(userName);
		
		//调用Service服务,插入用户
		UserService us = new UserService();
		String uid = RandomUID.getRandomNumber(10);
		User user = new User(uid, userName, password);
		Boolean flag =  us.insertUser(user);
		
		//生成json对象
		InsertUserData iud = new InsertUserData(flag);
		Json json = new Json();
		json.set(StatusObject.STATUS_OK);
		json.setData(iud);
		
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
	/**
	 *         获取指定位数的随机数
	 * @param digCount
	 * @return
	 */
	
}
