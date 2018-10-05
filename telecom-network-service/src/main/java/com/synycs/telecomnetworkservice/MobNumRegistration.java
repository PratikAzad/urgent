package com.synycs.telecomnetworkservice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mobile_number_registration")
public class MobNumRegistration {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "network_name")
    private String networkName;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_add")
    private String userAdd;

    @Column(name = "area")
    private String area;

    @Transient
    private String port;

    public MobNumRegistration() {
    }

    public MobNumRegistration(int id, String networkName, String mobileNumber, String userName, String userAdd, String area) {
        this.id = id;
        this.networkName = networkName;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.userAdd = userAdd;
        this.area = area;
    }
}
