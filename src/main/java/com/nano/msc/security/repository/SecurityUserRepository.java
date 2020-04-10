package com.nano.msc.security.repository;

import com.nano.msc.security.bo.SecurityUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Integer> {

    SecurityUser findByUserId(Long userId);

    SecurityUser findByUsername(String userName);

}
