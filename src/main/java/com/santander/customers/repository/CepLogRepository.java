package com.santander.customers.repository;

import com.santander.customers.model.CepLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepLogRepository extends JpaRepository<CepLog, String> {
}
