package com.mystore.petstore;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PetService {
	@Autowired
    private PetRepository repo;
	 public void save(Pet pet) {
	        repo.save(pet);
	    }
	 public Pet get(Integer id) {
	        return repo.findById(id).get();
	    }
	 public List<Pet> listPets() {
	        return repo.findAll();
	    }
	 public void delete(Integer id) {
	        repo.deleteById(id);
	    }
}
