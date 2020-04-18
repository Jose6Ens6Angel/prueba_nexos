package com.co.prueba.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.exception.ResourceNotFoundException;
import com.co.prueba.model.Familiar;
import com.co.prueba.service.FamiliaService;

@RestController
@RequestMapping("/api/v1")
public class FamiliarController {
	
	@Autowired
	private FamiliaService familiarService;
	
	@GetMapping("/familia")
	public List<Familiar> getAllusus() {
		return familiarService.getAllfams();
	}
	
	@GetMapping("/familia/{id}")
	public ResponseEntity<Familiar> getusuById(@PathVariable(value = "id") Long usuId)
			throws com.co.prueba.exception.ResourceNotFoundException {
		return familiarService.getFamById(usuId);
	}

	@PostMapping("/familia")
	public Familiar createusu(@Valid @RequestBody Familiar usu) {
		return familiarService.createFam(usu);
	}

	@PutMapping("/familia/{id}")
	public ResponseEntity<Familiar> updateusu(@PathVariable(value = "id") Long usuId,
			@Valid @RequestBody Familiar usuDetails) throws ResourceNotFoundException {
		return familiarService.updateFam(usuId, usuDetails);
	}

	@DeleteMapping("/familia/{id}")
	public Map<String, Boolean> deleteusu(@PathVariable(value = "id") Long usuId)
			throws ResourceNotFoundException {
		return familiarService.deleteFam(usuId);
	}
}
