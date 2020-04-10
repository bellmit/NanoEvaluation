package com.nano.msc.security.repository;

import com.nano.msc.security.bo.SecurityRole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRoleRepository extends JpaRepository<SecurityRole, Integer> {

    /**
     * 通过角色ID查找角色
     */
    SecurityRole findByRoleId(Integer roleId);

}
