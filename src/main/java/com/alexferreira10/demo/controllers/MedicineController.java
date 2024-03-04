package com.alexferreira10.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexferreira10.demo.model.dto.MedicineDTO;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
	
	@PostMapping
	public void insert(@RequestBody MedicineDTO data) {
		System.out.println(data);
	}
}
