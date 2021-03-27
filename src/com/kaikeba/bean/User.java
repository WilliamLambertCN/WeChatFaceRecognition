package com.kaikeba.bean;

import java.util.Objects;

/**
 * 用户类，描述了用于存储的人脸相关信息
 */
public class User {
    //用户的标识
    private int id;
    //用户的人脸标识
    private String face_id;
    //用户姓名
    private String userName;
    //用户的备注
    private String description;
    //首次被录入的城市
    private String city;
    //录入的次数
    private int count;
    //上一次进店的时间
    private long loginTime;

    //alt+insert
    // 生成了：
    //无参构造器
    //全参构造器
    //get an set
    //toString
    //equals and hashcode
    public User() {
    }

    public User(int id, String face_id, String userName, String description, String city, int count, long loginTime) {
        this.id = id;
        this.face_id = face_id;
        this.userName = userName;
        this.description = description;
        this.city = city;
        this.count = count;
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                count == user.count &&
                loginTime == user.loginTime &&
                Objects.equals(face_id, user.face_id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(description, user.description) &&
                Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, face_id, userName, description, city, count, loginTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", face_id='" + face_id + '\'' +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", count=" + count +
                ", loginTime=" + loginTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }
}
