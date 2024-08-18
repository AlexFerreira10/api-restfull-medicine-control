package com.alexferreira10.demo.model.entities.medicine;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository repository;

	public Medicine findById(Long id) {
		verifyId(id);
		return repository.getReferenceById(id);
	}

	@Transactional
	public Medicine insert(RegisterMedicinetDTO data) {
		var medicine = new Medicine(data);

		return repository.save(medicine);
	}

	@Transactional
	public Medicine update(MedicineUpdateDTO data) {
		verifyId(data.id());
		Medicine entity = repository.getReferenceById(data.id());
		entity.updateData(data);
		return repository.save(entity);
	}

	public List<Medicine> findAllByActiveTrue() {
		return repository.findAll().stream().filter(x -> x.getActive().equals(true)).toList();
	}

	@Transactional
	public Medicine activate(Long id) {
		verifyId(id);
		Medicine obj = repository.getReferenceById(id);
		obj.setActive(true);
		return obj;
	}

	@Transactional
	public void inactivate(Long id) {
		verifyId(id);
		Medicine obj = repository.getReferenceById(id);
		obj.setActive(false);
	}

	public void verifyId(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Medicine not found");
		}
	}
}