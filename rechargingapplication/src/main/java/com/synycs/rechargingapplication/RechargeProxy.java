package com.synycs.rechargingapplication;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "rechargingapplication")
@RibbonClient(name = "rechargingapplication")
public interface RechargeProxy {

    @GetMapping("/getDetails/{mobNum}")
    RechargeBean rechargeDetails(@PathVariable("mobNum")String mobNum);
}
