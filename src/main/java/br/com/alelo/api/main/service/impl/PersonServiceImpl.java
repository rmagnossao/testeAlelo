package br.com.alelo.api.main.service.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alelo.api.main.entity.Person;
import br.com.alelo.api.main.repository.PersonRepository;
import br.com.alelo.api.main.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> retornaPerson() {

		List<Person> allPerson = personRepository.findAll();
		return allPerson;

	}

	@Override
	public Person retornaPersonById(Integer id) {
		Person person = personRepository.findById(id);
		return person;
	}

	@Override
	public void atualizaPerson(Person personRequest) {
		personRepository.save(personRequest);

	}

	@Override
	public void inserePerson(Person personRequest) {
		try {
			personRepository.save(personRequest);
		} catch (ConstraintViolationException cve) {
			System.out.println("Erro ao inserir na tabela " + cve.getConstraintName());
		}

	}

	@Override
	public void deletePerson(Integer id) {
		personRepository.delete(id);

	}

}
