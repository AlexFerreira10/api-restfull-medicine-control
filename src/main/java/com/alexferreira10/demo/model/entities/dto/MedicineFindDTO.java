package com.alexferreira10.demo.model.entities.dto;

import java.time.LocalDate;

import com.alexferreira10.demo.model.entities.Medicine;
import com.alexferreira10.demo.model.enums.Laboratory;
import com.alexferreira10.demo.model.enums.TypeWay;

public record MedicineFindDTO(
        Long id,
		String name,
        TypeWay way,
        String batch,
        Laboratory laboratory,
        LocalDate validaty
) {
    public MedicineFindDTO(Medicine medicine) {
        this(medicine.getId(), medicine.getName(), medicine.getWay(), medicine.getBatch(), medicine.getLaboratory(), medicine.getValidaty());
    }
}