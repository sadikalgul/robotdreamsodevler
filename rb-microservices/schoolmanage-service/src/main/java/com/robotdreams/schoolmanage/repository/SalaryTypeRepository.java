package com.robotdreams.schoolmanage.repository;


import com.robotdreams.schoolmanage.models.SalaryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryTypeRepository extends JpaRepository<SalaryType,Long> {
}
