package com.synycs.telecomnetworkservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBSeeder implements CommandLineRunner{


    @Autowired
    private RegistrationRepository repository;

    @Override
    public void run(String... args) throws Exception {
        MobNumRegistration registration1=new MobNumRegistration
                (101,"AirTel","9883245183","Pratik", "WB", "Kolkata");

        MobNumRegistration registration2=new MobNumRegistration
                (102,"Idea","7560239875","Ramesh", "TS", "Hyderabad");

        MobNumRegistration registration3=new MobNumRegistration
                (103,"JIO","8240639360","Sudhir", "UP", "Varanasi");


        repository.save(registration1);
        repository.save(registration2);
        repository.save(registration3);

    }
}
