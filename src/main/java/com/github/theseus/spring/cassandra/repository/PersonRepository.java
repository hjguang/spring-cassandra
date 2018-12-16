package com.github.theseus.spring.cassandra.repository;

import com.github.theseus.spring.cassandra.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> findByNameLike(String name);

}
