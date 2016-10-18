package com.inerdstack.mzcj.model;

/**
 * 项目名称：mzcj
 * 模块名称：model
 * 包名：com.inerdstack.mzcj.model
 * 类功能：
 * 创建人：inerdstack
 * 创建时间：2016 16/10/6 上午9:16
 * 联系邮箱: wjnovember@icloud.com
 */
public class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
