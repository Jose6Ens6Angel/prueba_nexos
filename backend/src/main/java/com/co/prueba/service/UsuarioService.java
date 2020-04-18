package com.co.prueba.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.prueba.exception.ResourceNotFoundException;
import com.co.prueba.model.LogAuditoria;
import com.co.prueba.model.Usuario;
import com.co.prueba.repository.DaoRepositoryLogAuditoria;
import com.co.prueba.repository.DaoRepositoryUsuario;

@Service
public class UsuarioService {
	@Autowired
	private DaoRepositoryUsuario usuarioRepository;
	
	@Autowired
	private DaoRepositoryLogAuditoria logAuditoriaRepository;
	
	public List<Usuario> getAllusus() {
		return usuarioRepository.findAll();
	}
	
	public ResponseEntity<Usuario> getusuById(Long usuId)
			throws com.co.prueba.exception.ResourceNotFoundException {
		Usuario usu = usuarioRepository.findById(usuId)
				.orElseThrow(() -> new ResourceNotFoundException("usu not found for this id :: " + usuId));
		logAuditoriaRepository.save(new LogAuditoria(usuId.toString(), usu.toString()));
		return ResponseEntity.ok().body(usu);
	}
	
	public Usuario createusu(Usuario usu) {
		return usuarioRepository.save(usu);
	}
	
	public ResponseEntity<Usuario> updateusu(Long usuId, Usuario usuDetails) throws ResourceNotFoundException {
		Usuario usu = usuarioRepository.findById(usuId)
				.orElseThrow(() -> new ResourceNotFoundException("usu not found for this id :: " + usuId));

		usu.setId(usuDetails.getId());
		usu.setNombre(usuDetails.getNombre());
		usu.setApellido(usuDetails.getApellido());
		usu.setCantidad_Personas(usuDetails.getCantidad_Personas());
		usu.setCelular(usuDetails.getCelular());
		usu.setCiudad(usuDetails.getCiudad());
		usu.setDireccion(usuDetails.getDireccion());
		usu.setDocumento(usuDetails.getDocumento());
		usu.setFecha_Naci(usuDetails.getFecha_Naci());
		usu.setOcupacion(usuDetails.getOcupacion());
		usu.setTipo_Doc(usuDetails.getTipo_Doc());
		final Usuario updatedusu = usuarioRepository.save(usu);
		logAuditoriaRepository.save(new LogAuditoria(usuDetails.toString(), updatedusu.toString()));
		return ResponseEntity.ok(updatedusu);
	}
	
	public Map<String, Boolean> deleteusu(Long usuId)
			throws ResourceNotFoundException {
		Usuario usu = usuarioRepository.findById(usuId)
				.orElseThrow(() -> new ResourceNotFoundException("usu not found for this id :: " + usuId));

		usuarioRepository.delete(usu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logAuditoriaRepository.save(new LogAuditoria(usu.toString(), Boolean.TRUE.toString()));
		return response;
	}
}
