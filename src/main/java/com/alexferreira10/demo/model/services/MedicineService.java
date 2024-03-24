package com.alexferreira10.demo.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexferreira10.demo.model.entities.Medicine;
import com.alexferreira10.demo.model.entities.dto.MedicineUpdateDTO;
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
		// Does not go to the database, just monitors
		Medicine entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Medicine entity, MedicineUpdateDTO obj) {
		entity.setName(obj.name());
		entity.setWay(obj.way());
		// entity.setBatch(obj.getBatch());
		// entity.setValidaty(obj.getValidaty());
		entity.setLaboratory(obj.laboratory());
	}

	public Medicine getReferenceById(Long id) {
		return repository.getReferenceById(id);
	}

	public List<Medicine> findAllByActiveTrue() {
		return repository.findAll().stream().filter(x -> x.getActive() == true).toList();

	}
}