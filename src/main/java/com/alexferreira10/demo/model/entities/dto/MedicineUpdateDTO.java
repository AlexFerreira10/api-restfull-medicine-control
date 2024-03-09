package com.alexferreira10.demo.model.entities.dto;

import com.alexferreira10.demo.model.enums.Laboratory;
import com.alexferreira10.demo.model.enums.TypeWay;

public record MedicineUpdateDTO(

		String name, TypeWay way, Laboratory laboratory) {
}
