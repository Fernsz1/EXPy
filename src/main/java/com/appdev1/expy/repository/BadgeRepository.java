package com.appdev1.expy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev1.expy.entity.BadgeEntity;

@Repository
public interface BadgeRepository extends JpaRepository<BadgeEntity, Integer> {

}
