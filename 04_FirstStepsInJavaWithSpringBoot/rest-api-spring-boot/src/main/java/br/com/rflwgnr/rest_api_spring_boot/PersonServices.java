package br.com.rflwgnr.rest_api_spring_boot;

import br.com.rflwgnr.rest_api_spring_boot.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Rafael");
        person.setLastName("Trindade");
        person.setAddress("Marília, São Paulo - Brasil");
        person.setGender("Male");
        return person;
    }

}
