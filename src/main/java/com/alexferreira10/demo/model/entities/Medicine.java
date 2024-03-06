package com.alexferreira10.demo.model.entities;

import java.io.Serializable;

import com.alexferreira10.demo.model.entities.dto.MedicineDTO;
import com.alexferreira10.demo.model.enums.Laboratory;
import com.alexferreira10.demo.model.enums.TypeWay;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@EqualsAndHashCode
public class Medicine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private TypeWay way;
	private String batch;
	private String validaty;
	
	@Enumerated(EnumType.STRING)
	private Laboratory laboratory;
	
	public Medicine() {
	}
	
	public Medicine(MedicineDTO data) {
		this.name = data.name();
		this.way = data.way();
		this.batch = data.batch();
		this.validaty = data.validaty();
		this.laboratory = data.laboratory();
	}

	public Medicine(Long id, String name, TypeWay way, String batch, String validaty, Laboratory laboratory) {
		super();
		this.id = id;
		this.name = name;
		this.way = way;
		this.batch = batch;
		this.validaty = validaty;
		this.laboratory = laboratory;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getValidaty() {
        return validaty;
    }

    public void setValidaty(String validaty) {
        this.validaty = validaty;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeWay getWay() {
		return way;
	}

	public void setWay(TypeWay way) {
		this.way = way;
	}

	public Laboratory getLaboratory() {
		return laboratory;
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory = laboratory;
	} 
}