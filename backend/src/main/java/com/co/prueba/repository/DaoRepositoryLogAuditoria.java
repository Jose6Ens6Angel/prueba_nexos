package com.co.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.prueba.model.LogAuditoria;

@Repository
public interface DaoRepositoryLogAuditoria extends JpaRepository<LogAuditoria, Long>{

}
