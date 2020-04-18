package com.co.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.prueba.exception.ResourceNotFoundException;
import com.co.prueba.model.LogAuditoria;
import com.co.prueba.repository.DaoRepositoryLogAuditoria;

@Service
public class LogAuditoriaService {
	@Autowired
	private DaoRepositoryLogAuditoria logAuditoriaRepository;
	
	public List<LogAuditoria> getAllusus() {
		return logAuditoriaRepository.findAll();
	}
	
	public ResponseEntity<LogAuditoria> getusuById(Long usuId)
			throws com.co.prueba.exception.ResourceNotFoundException {
		LogAuditoria usu = logAuditoriaRepository.findById(usuId)
				.orElseThrow(() -> new ResourceNotFoundException("usu not found for this id :: " + usuId));
		return ResponseEntity.ok().body(usu);
	}
	
	public LogAuditoria createFam(LogAuditoria  log) {
		return logAuditoriaRepository.save(log);
	}
}
