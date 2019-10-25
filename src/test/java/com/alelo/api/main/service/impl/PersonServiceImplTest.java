package com.alelo.api.main.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.alelo.api.main.entity.Person;

public class PersonServiceImplTest extends JPALocalDbConfig {

	@Test
	public void testReturnPersonById() {
		Person book = em.find(Person.class, 1);
		assertNotNull(book);
	}

	@Test
	public void testReturnAllPerson() {
		List<Person> person = em.createNamedQuery("Person.getAll", Person.class).getResultList();
		assertEquals(1, person.size());
	}

	@Test
	public void testeDeletePerson() {
		Person person = em.find(Person.class, 1);

		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();

		List<Person> personList = em.createNamedQuery("Person.getAll", Person.class).getResultList();
		assertEquals(0, personList.size());
	}

	@Test
	public void testPersist_success() {
		em.getTransaction().begin();
		em.persist(new Person("ddvfd"));
		em.getTransaction().commit();

		List<Person> personList = em.createNamedQuery("Person.getAll",Person.class).getResultList();

		assertNotNull(personList);
		assertEquals(2, personList.size());
	}

}
