package com.nano.msc.security.repository;

import com.nano.msc.security.bo.SecurityRolePermissionRelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色与权限DAO
 * @author nano
 */
@Repository
public interface SecurityRolePermissionRepository extends JpaRepository <SecurityRolePermissionRelation, Integer>{

    List<SecurityRolePermissionRelation> findAllByRoleId(Long roleId);

}
