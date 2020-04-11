package com.nano.msc.security.repository;

import com.nano.msc.security.po.AuthUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Integer> {

    AuthUser findByUserId(Long userId);

    AuthUser findByUsername(String userName);

}
