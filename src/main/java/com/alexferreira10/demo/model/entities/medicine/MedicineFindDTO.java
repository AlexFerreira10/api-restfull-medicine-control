package com.alexferreira10.demo.model.entities.medicine;

import java.time.LocalDate;
import com.alexferreira10.demo.model.entities.medicine.enums.Laboratory;
import com.alexferreira10.demo.model.entities.medicine.enums.TypeWay;

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