package com.dzz.policy.service.domain.model;

import javax.persistence.*;

public class Policy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_no")
    private String policyNo;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return policy_no
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * @param policyNo
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }
}