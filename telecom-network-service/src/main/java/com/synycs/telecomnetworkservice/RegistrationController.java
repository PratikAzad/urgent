package com.synycs.telecomnetworkservice;


import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationRepository repository;

    @Autowired
    private Environment environment;


    @GetMapping("/getDetails/{mobNum}")
    public MobNumRegistration getDetails(@PathVariable("mobNum")String mobNum){

        val result=repository.findByMobileNumber(mobNum);

        if(result.isPresent()){
            result.get().setPort(environment.getProperty("server.port"));
            return result.get();
        }
        return new MobNumRegistration();

    }
}
