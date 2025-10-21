package com.appdev1.expy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appdev1.expy.entity.ModuleEntity;

@Repository
public interface moduleRepository extends JpaRepository<ModuleEntity, Integer> {
}
