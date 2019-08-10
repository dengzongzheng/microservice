package com.dzz.policy.service.domain.model;

import javax.persistence.*;
import lombok.Data;

/**
 * @author dzz
 */
@Data
public class Policy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_no")
    private String policyNo;

}