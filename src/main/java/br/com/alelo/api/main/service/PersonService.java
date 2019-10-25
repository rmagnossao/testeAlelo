package br.com.alelo.api.main.service;

import java.util.List;

import br.com.alelo.api.main.entity.Person;

public interface PersonService {

	List<Person> retornaPerson();

	Person retornaPersonById(Integer id);

	void inserePerson(Person personRequest);

	void deletePerson(Integer id);

	void atualizaPerson(Person personRequest);

}
