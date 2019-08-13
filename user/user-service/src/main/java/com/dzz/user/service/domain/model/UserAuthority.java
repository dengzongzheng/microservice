package com.dzz.user.service.domain.model;

import javax.persistence.*;
import lombok.Data;

/**
 * @author dzz
 */
@Table(name = "user_authority")
@Data
public class UserAuthority {

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户权限
     */
    private String authority;

}