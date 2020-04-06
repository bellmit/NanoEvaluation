package com.nano.msc.login.repository;

import com.nano.msc.login.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhone(String phone);

    User findById(Integer id);

    User findByPhoneAndPassword(String phone, String password);

    User findByUserNameAndPassword(String userName, String password);
}
