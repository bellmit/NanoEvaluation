package com.nano.msc.auth.repository;

import com.nano.msc.auth.po.AuthRolePermissionRelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色与权限DAO
 * @author nano
 */
@Repository
public interface AuthRolePermissionRepository extends JpaRepository <AuthRolePermissionRelation, Integer>{

    List<AuthRolePermissionRelation> findAllByRoleId(Long roleId);

}
