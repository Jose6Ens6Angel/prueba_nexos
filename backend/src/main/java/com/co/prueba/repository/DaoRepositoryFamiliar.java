package com.co.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.prueba.model.Familiar;


@Repository
public interface DaoRepositoryFamiliar extends JpaRepository<Familiar, Long>{

}
