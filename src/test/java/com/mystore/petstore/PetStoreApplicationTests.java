package com.mystore.petstore;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class PetStoreApplicationTests {

	@Autowired
	private PetRepository repo;
	
	@SuppressWarnings("deprecation")
	@Test
	@Order(1)
	public void testCreate() {
		Pet p =new Pet();
		p.setPetid(10);
		p.setPetname("husky");
		p.setPettype("dog");
		p.setPetprice(123);
		repo.save(p);
		assertNotNull(repo.findById(10).get());
	}
	
	@Test
	@Order(2)
	public void getAllPets() {
		List<Pet> pets=repo.findAll();
		assertThat(pets).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void getPetId() {
		Pet p=repo.findById(10).get();
		assertEquals(123,p.getPetprice(),0);	
		
	}
	@Test
	@Order(4)
	public void testPetUpdate() {
		Pet p=repo.findById(10).get();
		p.setPetprice(125);
		repo.save(p);
		assertNotEquals(123,repo.findById(10).get().getPetprice());
	}
	@Test
	@Order(5)
	public void getPetDelete() {
		repo.deleteById(10);
		assertThat(repo.existsById(10)).isFalse();
	}

}
