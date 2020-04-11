package com.nano.msc.auth.repository;

import com.nano.msc.auth.po.AuthPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthPermissionRepository extends JpaRepository<AuthPermission, Integer> {



}
