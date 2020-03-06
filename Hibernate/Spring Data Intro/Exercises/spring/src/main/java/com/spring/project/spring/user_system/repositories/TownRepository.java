package com.spring.project.spring.user_system.repositories;

import com.spring.project.spring.user_system.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
}
