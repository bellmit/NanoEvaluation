package com.nano.msc.login.repository;

import com.nano.msc.login.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhone(String phone);

    User findById(Integer id);

    User findByPhoneAndUserPassword(String phone, String password);

    User findByUserNameAndUserPassword(String userName, String password);
}
