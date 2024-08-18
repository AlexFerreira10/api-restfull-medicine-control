package com.alexferreira10.demo.model.entities.medicine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexferreira10.demo.model.repositories.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository repository;

	public List<Medicine> findAll() {
		return repository.findAll();
	}

	public Medicine findById(Long id) {
		var medicine = repository.getReferenceById(id);
		return medicine;
	}

	public Medicine insert(Medicine obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {

		repository.deleteById(id);

	}

	public Medicine update(Long id, MedicineUpdateDTO obj) {
		Medicine entity = repository.getReferenceById(id);
		entity.updateData(obj);
		return repository.save(entity);
	}

	public Medicine getReferenceById(Long id) {
		return repository.getReferenceById(id);
	}

	public List<Medicine> findAllByActiveTrue() {
		return repository.findAll().stream().filter(x -> x.getActive() == true).toList();

	}
}