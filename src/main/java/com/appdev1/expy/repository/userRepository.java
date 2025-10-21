package com.appdev1.expy.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.appdev1.expy.entity.UserEntity;
public interface userRepository extends JpaRepository<UserEntity, Integer> {

}
