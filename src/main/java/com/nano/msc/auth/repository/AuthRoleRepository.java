package com.nano.msc.auth.repository;

import com.nano.msc.auth.po.AuthRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRoleRepository extends JpaRepository<AuthRole, Integer> {

    /**
     * 通过角色ID查找角色
     */
    AuthRole findByRoleId(Integer roleId);

}
