package br.com.rflwgnr.rest_api_spring_boot.repository;

import br.com.rflwgnr.rest_api_spring_boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}