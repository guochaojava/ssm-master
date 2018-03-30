package com.lgd.winter.model;

import lombok.Data;

@Data
public class User {
    /**
     * 对应数据库 user.id
     * 自增主键
     */
    private Integer id;

    /**
     * 对应数据库 user.login_name
     * 登录名
     */
    private String loginName;

    /**
     * 对应数据库 user.password
     * 密码
     */
    private String password;

    /**
     * 对应数据库 user.nick_name
     * 昵称
     */
    private String nickName;

    /**
     * 对应数据库 user.img
     * 头像
     */
    private String img;

    /**
     * 对应数据库 user.sex
     * 性别 默认1：男  0：女
     */
    private Integer sex;

    /**
     * 对应数据库 user.age
     * 年龄
     */
    private Integer age;

    /**
     * 对应数据库 user.address
     * 联系地址
     */
    private String address;

    /**
     * 对应数据库 user.telephone
     * 联系方式
     */
    private String telephone;

    /**
     * 对应数据库 user.email
     * 电子邮箱
     */
    private String email;

    /**
     * 对应数据库 user.create_time
     * 创建时间
     */
    private String createTime;

    /**
     * 对应数据库 user.last_login_time
     * 上次登录时间
     */
    private String lastLoginTime;

    /**
     * 对应数据库 user.police_room
     * 所属警务室
     */
    private String policeRoom;

    /**
     * 对应数据库 user.police_station
     * 所属派出所
     */
    private String policeStation;

    /**
     * 对应数据库 user.status
     * 状态 默认1:正常
     */
    private Integer status;
}