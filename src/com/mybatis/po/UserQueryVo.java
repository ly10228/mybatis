package com.mybatis.po;

import java.util.List;

/**
 * Created by luoyong on 16/11/12.
 * 包装类型类  将来在使用的时候,该类里面的属性值会从页面传到controller-->service-->mapper（dao）
 * 可以做为输入输出的映射
 */
public class UserQueryVo {
    //用户的信息
    private User user;
    //自定义user的扩展对象
    private UserCustom userCustom;
    //用户id的集合
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
