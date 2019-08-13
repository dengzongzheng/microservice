package com.dzz.user.service.domain.model;

import javax.persistence.*;
import lombok.Data;

/**
 * @author dzz
 */
@Data
public class User {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

}