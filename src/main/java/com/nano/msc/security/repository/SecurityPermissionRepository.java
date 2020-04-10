package com.nano.msc.security.repository;

import com.nano.msc.security.bo.SecurityPermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SecurityPermissionRepository extends JpaRepository<SecurityPermission, Integer> {



}
