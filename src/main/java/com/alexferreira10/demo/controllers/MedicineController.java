package com.alexferreira10.demo.controllers;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alexferreira10.demo.model.entities.medicine.Medicine;
import com.alexferreira10.demo.model.entities.medicine.MedicineFindDTO;
import com.alexferreira10.demo.model.entities.medicine.RegisterMedicinetDTO;
import com.alexferreira10.demo.model.entities.medicine.MedicineUpdateDTO;
import com.alexferreira10.demo.model.entities.medicine.MedicineService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

	@Autowired
	private MedicineService service;

	@PostMapping
	@Transactional
	public ResponseEntity<RegisterMedicinetDTO> insert(@RequestBody @Valid RegisterMedicinetDTO data) {
		Medicine obj = service.insert(new Medicine(data));
		// Return 201 code in insertion
		// Rest Default
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(data);
	}

	@GetMapping
	public ResponseEntity<List<MedicineFindDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAllByActiveTrue().stream().map(MedicineFindDTO::new).toList());
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
		MedicineFindDTO obj = new MedicineFindDTO(service.update(id, data));
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/inactivate/{id}")
	@Transactional
	public ResponseEntity<Void> inactivate(@PathVariable Long id) {
		Medicine obj = service.getReferenceById(id);
		obj.inactivate();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/activate/{id}")
	@Transactional
	public ResponseEntity<Void> activate(@PathVariable Long id) {
		// Raise an exception; Throw EntityNotFoundException
		// Spring get and use 500 error
		Medicine obj = service.getReferenceById(id);
		obj.activate();
		return ResponseEntity.noContent().build();
	}

}