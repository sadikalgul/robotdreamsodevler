package com.robotdreams.repository;

import com.robotdreams.models.SalaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryTypeRepository extends JpaRepository<SalaryType,Long> {
}
