package com.robotdreams.repository;

import com.robotdreams.model.ExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeEntity,Long> {

    ExchangeEntity findExchangeEntityBySourceAndTarget(String source,String target);
}
