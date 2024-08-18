package com.alexferreira10.demo.model.entities.medicine;

import com.alexferreira10.demo.model.entities.medicine.enums.TypeWay;

public record DataMedicineDto(
        Long id,
        String name,
        TypeWay way,
        String batch
) {
    public DataMedicineDto(Medicine medicine) {
        this(medicine.getId(), medicine.getName(), medicine.getWay(), medicine.getBatch());
    }
}