package com.robotdreams.repository;

import com.robotdreams.model.ConversionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversionRepository extends JpaRepository<ConversionEntity,Long> {
}
