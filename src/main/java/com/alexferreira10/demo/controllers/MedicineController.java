package com.alexferreira10.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexferreira10.demo.model.entities.Medicine;
import com.alexferreira10.demo.model.entities.dto.MedicineDTO;
import com.alexferreira10.demo.model.services.MedicineService;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
	
	@Autowired
	private MedicineService service;
	
	@PostMapping
	public ResponseEntity<Medicine> insert(@RequestBody MedicineDTO data) {
		Medicine obj = service.insert(new Medicine(data));
		return ResponseEntity.ok().body(obj);
	}
}
