package com.alexferreira10.demo.model.entities.medicine;

import com.alexferreira10.demo.model.entities.medicine.enums.Laboratory;
import com.alexferreira10.demo.model.entities.medicine.enums.TypeWay;

public record MedicineUpdateDTO(
		Long id,
		String name,
		TypeWay way,
		Laboratory laboratory) {
}
