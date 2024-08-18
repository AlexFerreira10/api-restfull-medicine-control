package com.alexferreira10.demo.controllers;

import java.net.URI;
import java.util.List;
import com.alexferreira10.demo.model.entities.medicine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

	@Autowired
	private MedicineService service;

	@PostMapping
	public ResponseEntity<DataMedicineDto> insert(@RequestBody @Valid RegisterMedicinetDTO data) {
		Medicine obj = service.insert(data);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(new DataMedicineDto(obj.getId(),obj.getName(), obj.getWay(), obj.getBatch()));
	}

	@GetMapping
	public ResponseEntity<List<MedicineFindDTO>> findAll() {
		var lista = service.findAllByActiveTrue().stream().map(MedicineFindDTO::new).toList();

		return ResponseEntity.ok(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicineFindDTO> findById(@PathVariable Long id) {
		var obj = new MedicineFindDTO(service.findById(id));

		return ResponseEntity.ok(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MedicineFindDTO> update(@RequestBody @Valid MedicineUpdateDTO data) {
		var obj = new MedicineFindDTO(service.update(data));

		return ResponseEntity.ok(obj);
	}

	@DeleteMapping("/inactivate/{id}")
	public ResponseEntity<Void> inactivate(@PathVariable Long id) {
		service.inactivate(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/activate/{id}")
	public ResponseEntity<MedicineFindDTO> activate(@PathVariable Long id) {
		var obj = new MedicineFindDTO(service.activate(id));

		return ResponseEntity.ok(obj);
	}
}