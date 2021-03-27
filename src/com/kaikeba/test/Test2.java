package com.kaikeba.test;

import com.kaikeba.bean.User;
import com.kaikeba.service.UserService;

public class Test2 {
    public static void main(String[] args){
        User user = new User();
        user.setFace_id("123");
        user.setCity("wuhan");
        UserService.insert(user);
    }
}
