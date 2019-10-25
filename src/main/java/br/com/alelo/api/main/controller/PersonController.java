package br.com.alelo.api.main.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alelo.api.main.entity.Person;
import br.com.alelo.api.main.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonService personService;

	final static Logger logger = Logger.getLogger(PersonService.class);

	@RequestMapping(value = "/retornaPerson", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<Iterable<Person>> retornaPerson() {
		return ResponseEntity.ok(personService.retornaPerson());

	}

	@RequestMapping(value = "/retornaPerson/{id}", method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<Person> retornaPersonById(@PathVariable Integer id) {

		Person person = personService.retornaPersonById(id);
		if (person == null) {
			logger.error("Pessoa não encontrada");
		}
		return ResponseEntity.ok(person);

	}

	@PutMapping(value = "/atualizaPerson")
	public ResponseEntity<Person> atualizaPerson(@RequestBody Person personRequest) {

		Person findPerson = personService.retornaPersonById(personRequest.getId());

		if (findPerson == null) {
			logger.error("Pessoa não encontrada para alteração");
			return ResponseEntity.notFound().build();
		} else {
			personService.atualizaPerson(personRequest);
			return ResponseEntity.ok().build();
		}

	}

	@PostMapping(value = "/inserePerson")
	public ResponseEntity<Person> inserePerson(@RequestBody Person personRequest) {

		personService.inserePerson(personRequest);
		return ResponseEntity.ok().build();

	}

	@DeleteMapping(value = "/deletePerson/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable Integer id) {

		Person findPerson = personService.retornaPersonById(id);
		
		if (findPerson == null) {
			logger.error("Pessoa não encontrada para exclusão");
			return ResponseEntity.notFound().build();
		} else {
			personService.deletePerson(id);
			return ResponseEntity.ok().build();
		}

	}

}
