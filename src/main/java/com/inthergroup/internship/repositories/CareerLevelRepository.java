package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.CareerLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerLevelRepository extends JpaRepository<CareerLevel, Long> {
}