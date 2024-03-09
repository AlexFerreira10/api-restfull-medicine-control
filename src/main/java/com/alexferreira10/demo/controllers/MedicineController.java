package com.alexferreira10.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexferreira10.demo.model.entities.Medicine;
import com.alexferreira10.demo.model.entities.dto.MedicineFindDTO;
import com.alexferreira10.demo.model.entities.dto.MedicineInsertDTO;
import com.alexferreira10.demo.model.entities.dto.MedicineUpdateDTO;
import com.alexferreira10.demo.model.services.MedicineService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

	@Autowired
	private MedicineService service;

	@PostMapping
	@Transactional
	public ResponseEntity<MedicineInsertDTO> insert(@RequestBody @Valid MedicineInsertDTO data) {
		service.insert(new Medicine(data));
		return ResponseEntity.ok().body(data);
	}

	@GetMapping
	public ResponseEntity<List<MedicineFindDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll().stream().map(MedicineFindDTO::new).toList());
	}

	// @PathVariable show spring the restriction clause
	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicineFindDTO> findById(@PathVariable Long id) {
		MedicineFindDTO obj = new MedicineFindDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	// Do rollback, case need
	@Transactional
	public ResponseEntity<MedicineFindDTO> update(@PathVariable Long id, @RequestBody @Valid MedicineUpdateDTO data) {
		MedicineFindDTO obj = new  MedicineFindDTO(service.update(id, data));
		return ResponseEntity.ok().body(obj);
	}
}