package com.nano.msc.evaluation.info.repository;

import com.nano.msc.evaluation.info.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhone(String phone);

    User findById(Integer id);
}
