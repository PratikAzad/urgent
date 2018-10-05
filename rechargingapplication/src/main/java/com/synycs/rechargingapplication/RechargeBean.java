package com.synycs.rechargingapplication;


import lombok.Data;

import javax.persistence.Column;


@Data
public class RechargeBean {

    private String networkName;
    private String mobileNumber;
    private String userName;
    private String userAdd;
    private String area;
    private String port;
}
