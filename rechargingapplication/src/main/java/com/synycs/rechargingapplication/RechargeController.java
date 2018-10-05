package com.synycs.rechargingapplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RechargeController {


    /**
     * Communication Between two service through RestTemplate
     * @param mobNum
     * @return
     */
    /*@GetMapping("/recharge/{mobNum}")
    public RechargeMsgBean rechargeMsgBean(@PathVariable("mobNum")String mobNum){

        RechargeBean rechargeBean= new RestTemplate().getForObject("http://localhost:8049/getDetails/{mobNum}",
                RechargeBean.class,mobNum);

        RechargeMsgBean msgBean=new RechargeMsgBean();
        if(rechargeBean.getMobileNumber()==null){
            msgBean.setMobileNumber("N/A");
            msgBean.setWishMsg("Mobile number not Register...");
            return msgBean;
        }

        msgBean.setMobileNumber(rechargeBean.getMobileNumber());
        msgBean.setWishMsg("Hi "+rechargeBean.getUserName()+"("+
                rechargeBean.getArea()+")"+" Recharge Successful. Thanks to choosing '"+
                rechargeBean.getNetworkName()+"'");
        return msgBean;
    }*/

    @Autowired
    private RechargeProxy  proxy;

    /**
     * Communication between micro-service through Feign.
     * @param mobNum
     * @return
     */
    @GetMapping("/recharge/{mobNum}")
    public RechargeMsgBean rechargeMsgBean(@PathVariable("mobNum")String mobNum){
        RechargeBean rechargeBean= proxy.rechargeDetails(mobNum);

        RechargeMsgBean msgBean=new RechargeMsgBean();
        msgBean.setPort(rechargeBean.getPort());

        if(rechargeBean.getMobileNumber()==null){
            msgBean.setMobileNumber("N/A");
            msgBean.setWishMsg("Mobile number not Register...");
            return msgBean;
        }

        msgBean.setMobileNumber(rechargeBean.getMobileNumber());
        msgBean.setWishMsg("Hi "+rechargeBean.getUserName()+"("+
                rechargeBean.getArea()+")"+" Recharge Successful. Thanks to choosing '"+
                rechargeBean.getNetworkName()+"'");
        return msgBean;
    }
}
