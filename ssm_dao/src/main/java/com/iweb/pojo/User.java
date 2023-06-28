package com.iweb.pojo;

public class User {
    private Integer id;
    private String username;
    private String loginname;
    private String password;
    private String createDate;

    public User() {
    }

    public User(String loginname, String password) {
        this.loginname = loginname;
        this.password = password;
    }

    public User(Integer id, String username, String loginname, String password, String createDate) {
        this.id = id;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
