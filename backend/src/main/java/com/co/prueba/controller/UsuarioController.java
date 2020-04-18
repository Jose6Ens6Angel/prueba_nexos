package com.co.prueba.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.co.prueba.exception.ResourceNotFoundException;
import com.co.prueba.model.Usuario;
import com.co.prueba.service.UsuarioService;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuario")
	public List<Usuario> getAllusus() {
		return usuarioService.getAllusus();
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getusuById(@PathVariable(value = "id") Long usuId) throws ResourceNotFoundException{
		return usuarioService.getusuById(usuId);
	}

	@PostMapping("/usuario")
	public Usuario createusu(@Valid @RequestBody Usuario usu) {
		return usuarioService.createusu(usu);
	}

	@PutMapping(value = "/usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> updateusu(@PathVariable(value = "id") Long usuId,
			@Valid @RequestBody Usuario usuDetails) throws ResourceNotFoundException {

		return usuarioService.updateusu(usuId, usuDetails);
	}

	@DeleteMapping("/usuario/{id}")
	public Map<String, Boolean> deleteusu(@PathVariable(value = "id") Long usuId)
			throws ResourceNotFoundException {
		return usuarioService.deleteusu(usuId);
	}
}
