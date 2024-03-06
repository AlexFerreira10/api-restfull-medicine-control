package com.alexferreira10.demo.model.entities.dto;

import com.alexferreira10.demo.model.enums.Laboratory;
import com.alexferreira10.demo.model.enums.TypeWay;

//DTO : show only what I want
public record MedicineDTO(
		String name,
		TypeWay way,
		String batch,
		String validaty,
		Laboratory laboratory) {
}
