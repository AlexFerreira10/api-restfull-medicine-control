package com.alexferreira10.demo.model.entities.medicine;

import com.alexferreira10.demo.model.entities.enums.Laboratory;
import com.alexferreira10.demo.model.entities.enums.TypeWay;

public record MedicineUpdateDTO(

		String name, TypeWay way, Laboratory laboratory) {
}
