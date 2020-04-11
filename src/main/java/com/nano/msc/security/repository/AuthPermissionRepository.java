package com.nano.msc.security.repository;

import com.nano.msc.security.po.AuthPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthPermissionRepository extends JpaRepository<AuthPermission, Integer> {



}
