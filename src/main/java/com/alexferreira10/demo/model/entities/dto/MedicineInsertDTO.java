package com.alexferreira10.demo.model.entities.dto;

import java.time.LocalDate;

import com.alexferreira10.demo.model.enums.Laboratory;
import com.alexferreira10.demo.model.enums.TypeWay;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

//DTO : show only what I want
public record MedicineInsertDTO(
		//Not permit to save empty values
		@NotBlank
		String name,
		@Enumerated
		TypeWay way,
		@NotBlank
		String batch,
		int quantify,
		//Not permit to add date late the date now
		@Future
		LocalDate validaty,
		@Enumerated
		Laboratory laboratory) {
}
