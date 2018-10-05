package com.synycs.telecomnetworkservice;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RegistrationRepository extends CrudRepository<MobNumRegistration,Long>{

    Optional<MobNumRegistration> findByMobileNumber(String mobileNumber);
}
