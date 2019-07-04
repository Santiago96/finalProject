package com.globant.bootcamp.airlines.repositories;

import com.globant.bootcamp.airlines.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person,Long> {


    Person findByNumDocument(String numDocument);
}
