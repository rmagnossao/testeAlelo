package br.com.alelo.api.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alelo.api.main.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	Person findById(Integer id);

}
