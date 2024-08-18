package com.alexferreira10.demo.model.entities.medicine;

import java.time.LocalDate;
import com.alexferreira10.demo.model.entities.medicine.enums.Laboratory;
import com.alexferreira10.demo.model.entities.medicine.enums.TypeWay;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Medicine")
@Table(name = "tb_medicine")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "way")
	@Enumerated(EnumType.STRING)
	private TypeWay way;

	@Column(name = "batch")
	private String batch;

	@Column(name = "quantify")
	private Integer quantify;

	@Column(name = "validaty")
	private LocalDate validaty;

	@Column(name = "laboratory")
	@Enumerated(EnumType.STRING)
	private Laboratory laboratory;

	@Column(name = "active")
	private Boolean active;

	public Medicine(RegisterMedicinetDTO data) {
		this.name = data.name();
		this.way = data.way();
		this.batch = data.batch();
		this.quantify = data.quantify();
		this.validaty = data.validaty();
		this.laboratory = data.laboratory();
		this.active = true;
	}

	public void activate() {
		this.active = true;
	}

	public void inactivate() {
		this.active = false;
	}

	public void updateData(MedicineUpdateDTO data) {
		if(!data.name().equals(getName())) {
			setName(data.name());
		}
		if(!data.way().equals(getWay())) {
			setWay(data.way());
		}
		if(!data.laboratory().equals(getLaboratory())) {
			setLaboratory(data.laboratory());
		}
	}
}