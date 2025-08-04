package br.com.rflwgnr.rest_api_spring_boot.services;

import br.com.rflwgnr.rest_api_spring_boot.data.dto.v1.PersonDTO;
import br.com.rflwgnr.rest_api_spring_boot.data.dto.v2.PersonDTOV2;
import br.com.rflwgnr.rest_api_spring_boot.exception.ResourceNotFoundException;
import br.com.rflwgnr.rest_api_spring_boot.mapper.custom.PersonMapper;
import br.com.rflwgnr.rest_api_spring_boot.model.Person;
import br.com.rflwgnr.rest_api_spring_boot.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static br.com.rflwgnr.rest_api_spring_boot.mapper.ObjectMapper.parseListObjects;
import static br.com.rflwgnr.rest_api_spring_boot.mapper.ObjectMapper.parseObject;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");

        return parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        Person person = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(person, PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one Person!");

        Person entity = parseObject(personDTO, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 personDTO) {
        logger.info("Creating one Person V2!");

        Person entity = mapper.convertDTOToEntity(personDTO);

        return mapper.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(personDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        Person personUpdated = repository.save(entity);

        return parseObject(personUpdated, PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }

}
