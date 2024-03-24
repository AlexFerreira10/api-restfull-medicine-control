package com.alexferreira10.demo.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.alexferreira10.demo.model.entities.dto.MedicineInsertDTO;
import com.alexferreira10.demo.model.enums.Laboratory;
import com.alexferreira10.demo.model.enums.TypeWay;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_medicine")
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medicine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer way;
	private String batch;
	private Integer quantify;
	private LocalDate validaty;
	private Integer laboratory;

	private Boolean active;

	public Medicine() {
	}

	public Medicine(MedicineInsertDTO data) {
		this.setActive(true);
		this.name = data.name();
		setWay(data.way());
		this.batch = data.batch();
		this.quantify = data.quantify();
		this.validaty = data.validaty();
		setLaboratory(data.laboratory());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeWay getWay() {
		return TypeWay.valueOf(way);
	}

	public void setWay(TypeWay way) {
		if (way != null) {
			this.way = way.getCode();
		}
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public Integer getQuantify() {
		return quantify;
	}

	public void setQuantify(Integer quantify) {
		this.quantify = quantify;
	}

	public LocalDate getValidaty() {
		return validaty;
	}

	public void setValidaty(LocalDate validaty) {
		this.validaty = validaty;
	}

	public Laboratory getLaboratory() {
		return Laboratory.valueOf(laboratory);
	}

	public void setLaboratory(Laboratory laboratory) {
		if (laboratory != null) {
			this.laboratory = laboratory.getCode();
		}
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void inactivate() {
		this.active = false;
	}

	public void activate() {
		this.active = true;
	}
}