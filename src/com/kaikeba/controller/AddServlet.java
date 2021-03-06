package com.kaikeba.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.TreeSet;

import com.kaikeba.bean.Result;
import com.kaikeba.bean.User;
import com.kaikeba.service.UserService;

@WebServlet(name = "/v1/user/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在这里处理请求
        //1.接受参数
        String face_id =request.getParameter("face_id");
        String city = request.getParameter("city");
        //2.封装参数
        User user = new User();
        user.setFace_id(face_id);
        user.setCity(city);
        //3.传递参数service，进行数据库的存储
        int rowCount = UserService.insert(user);
        //在这里进行响应
        //4.根据存储的结果准备不同的响应内容
        Result result = null;
        if(rowCount>0){
            result = new Result(0,"添加成功");
        }else{
            result = new Result(-1,"添加失败");
        }
        //5.进行内容的JSON格式转换
        String json= result.toString();
        //6.将内容响应给小程序
        response.getWriter().append(json);
    }
}
