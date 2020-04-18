package com.co.prueba.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.co.prueba.exception.ResourceNotFoundException;
import com.co.prueba.model.Familiar;
import com.co.prueba.model.LogAuditoria;
import com.co.prueba.repository.DaoRepositoryFamiliar;
import com.co.prueba.repository.DaoRepositoryLogAuditoria;

@Service
public class FamiliaService {
	
	@Autowired
	private DaoRepositoryFamiliar familiarRepository;
	
	@Autowired
	private DaoRepositoryLogAuditoria logAuditoriaRepository;
	
	/**
	 * Metodo para devolver todos los familiares asociados a una persona
	 * @return
	 */
	public List<Familiar> getAllfams() {
		return familiarRepository.findAll();
	}
	
	/**
	 * Devuelve un familiar determinado por id
	 * @param famId
	 * @return
	 * @throws com.co.prueba.exception.ResourceNotFoundException
	 */
	public ResponseEntity<Familiar> getFamById(Long famId)
			throws com.co.prueba.exception.ResourceNotFoundException {
		Familiar fam = familiarRepository.findById(famId)
				.orElseThrow(() -> new ResourceNotFoundException("fam not found for this id :: " + famId));
		logAuditoriaRepository.save(new LogAuditoria(famId.toString(), fam.toString()));
		return ResponseEntity.ok().body(fam);
	}

	/**
	 * Crear Familiar
	 * @param fam
	 * @return
	 */
	public Familiar createFam(Familiar fam) {
		logAuditoriaRepository.save(new LogAuditoria(fam.toString(), fam.toString()));
		return familiarRepository.save(fam);
	}

	/**
	 * Metodo para modificar familiar por id
	 * @param famId
	 * @param famDetails
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public ResponseEntity<Familiar> updateFam(Long famId,Familiar famDetails) throws ResourceNotFoundException {
		Familiar fam = familiarRepository.findById(famId)
				.orElseThrow(() -> new ResourceNotFoundException("fam not found for this id :: " + famId));

		fam.setId(famDetails.getId());
		fam.setNombre(famDetails.getNombre());
		fam.setApellido(famDetails.getApellido());
		fam.setCelular(famDetails.getCelular());
		fam.setDireccion(famDetails.getDireccion());
		fam.setUsuario(famDetails.getUsuario());
		final Familiar updatedfam = familiarRepository.save(fam);
		logAuditoriaRepository.save(new LogAuditoria(famDetails.toString(), updatedfam.toString()));
		return ResponseEntity.ok(updatedfam);
	}


	/**
	 * Metodo para eliminar familiar
	 * @param famId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	public Map<String, Boolean> deleteFam(Long famId)
			throws ResourceNotFoundException {
		Familiar fam = familiarRepository.findById(famId)
				.orElseThrow(() -> new ResourceNotFoundException("fam not found for this id :: " + famId));

		familiarRepository.delete(fam);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		logAuditoriaRepository.save(new LogAuditoria(famId.toString(), Boolean.TRUE.toString()));
		return response;
	}
}
