package com.kaikeba.controller;

import com.kaikeba.bean.Result;
import com.kaikeba.bean.User;
import com.kaikeba.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/v1/user/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //在这里处理请求
        //1.接受参数
        String face_id =request.getParameter("face_id");
        String username = request.getParameter("username");
        String description = request.getParameter("description");
        //2.封装参数
        User user = new User();
        user.setUserName(username);
        user.setDescription(description);
        //3.传递参数service，进行数据库的存储
        int rowCount = UserService.updateUserByFaceId(face_id,user);
        //在这里进行响应
        //4.根据存储的结果准备不同的响应内容
        Result result = null;
        if(rowCount >0){
            result = new Result(0,"更新成功");
        }else{
            result = new Result(-1,"更新失败");
        }
        //5.进行内容的JSON格式转换
        String json= result.toString();
        //6.将内容响应给小程序
        response.getWriter().append(json);
    }
}
