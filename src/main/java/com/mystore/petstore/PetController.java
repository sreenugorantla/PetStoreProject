package com.mystore.petstore;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.*;


@RestController
public class PetController {

	@Autowired
	private PetService service;
	
	private PetStoreLog petlog;

	Logger log= org.slf4j.LoggerFactory.getLogger(PetService.class);
	@PostMapping("/pet")
	public void add(@RequestBody Pet pet) {
		log.info("Post method accessed");
		PetStoreLog.mylog("Post method accessed");
		service.save(pet);
	}

	@GetMapping("/pets")
	public List<Pet> list() {
		log.info("Get all pets method accessed");
		PetStoreLog.mylog("Get method accessed");
		return service.listPets();
	}

	@GetMapping("/pets/{id}")
	public ResponseEntity<Pet> get(@PathVariable Integer id) {
		try {
			log.info("Get 1 pet method accessed");
			PetStoreLog.mylog("Get 1 pet method accessed");
			Pet pet = service.get(id);
			return new ResponseEntity<Pet>(pet, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/petupdate/{id}")
	public ResponseEntity<?> update(@RequestBody Pet pet, @PathVariable Integer id) {
		try {
			log.info("Pet data update method accessed");
			PetStoreLog.mylog("Pet data update method accessed");
			pet.setPetid(id);
			service.save(pet);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/petdelete/{id}")
	public void delete(@PathVariable Integer id) {
		log.info("Delete has been method accessed ");
		PetStoreLog.mylog("Delete method accessed");
		service.delete(id);
	}

}
