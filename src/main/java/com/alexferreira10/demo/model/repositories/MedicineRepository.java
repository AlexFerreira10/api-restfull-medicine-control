package com.alexferreira10.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexferreira10.demo.model.entities.medicine.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Long>{
}
