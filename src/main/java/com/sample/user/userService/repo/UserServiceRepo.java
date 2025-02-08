package com.sample.user.userService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.user.userService.entity.User;

@Repository
public interface UserServiceRepo extends JpaRepository<User, String> {

}
