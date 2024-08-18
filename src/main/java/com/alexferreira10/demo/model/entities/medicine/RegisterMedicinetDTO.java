package com.alexferreira10.demo.model.entities.medicine;

import java.time.LocalDate;
import com.alexferreira10.demo.model.entities.enums.Laboratory;
import com.alexferreira10.demo.model.entities.enums.TypeWay;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterMedicinetDTO(
		@NotBlank(message = "This field can't be empty")
		String name,

		@NotNull(message = "This field can't be empty")
		@Enumerated(EnumType.STRING)
		TypeWay way,

		@NotBlank(message = "This field can't be empty")
		String batch,

		@NotNull(message = "This field can't be empty")
		int quantify,

		@Future(message = "The date need to be in the future")
		LocalDate validaty,

		@NotNull(message = "This field can't be empty")
		@Enumerated(EnumType.STRING)
		Laboratory laboratory) {
}
