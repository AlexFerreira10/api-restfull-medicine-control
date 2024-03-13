package com.alexferreira10.demo.model.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.alexferreira10.demo.model.entities.Medicine;
import com.alexferreira10.demo.model.entities.dto.MedicineFindDTO;
import com.alexferreira10.demo.model.entities.dto.MedicineUpdateDTO;
import com.alexferreira10.demo.model.repositories.MedicineRepository;
import com.alexferreira10.demo.model.services.exceptions.ResourceNotFoundException;


@Service
public class MedicineService {
	
	@Autowired
	MedicineRepository repository;
	
	public List<Medicine> findAll(){
		return repository.findAll();
	}
	
	public Medicine findById(Long id) {
		Optional<Medicine> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("\"Medicine not found with id: \" + id"));
	}
	
	public Medicine insert(Medicine obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Medicine update(Long id, MedicineUpdateDTO obj) {
		try {
			// Does not go to the database, just monitors
			Medicine entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Medicine entity, MedicineUpdateDTO obj) {
		entity.setName(obj.name());
		entity.setWay(obj.way());
	//	entity.setBatch(obj.getBatch());
	//	entity.setValidaty(obj.getValidaty());
		entity.setLaboratory(obj.laboratory());
	}
	
	public Medicine getReferenceById(Long id) {
		return repository.getReferenceById(id);
	}

	public List<Medicine> findAllByActiveTrue(){
		return repository.findAll().stream().filter(x -> x.getActive() == true).toList();
	
	}
}