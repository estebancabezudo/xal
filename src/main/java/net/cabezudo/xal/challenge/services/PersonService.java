package net.cabezudo.xal.challenge.services;

import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import net.cabezudo.xal.challenge.database.entities.PersonEntity;
import net.cabezudo.xal.challenge.database.repositories.PersonRepository;
import net.cabezudo.xal.challenge.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Service
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  Person save(Person person) {
    PersonEntity personEntity = new PersonEntity(person);
    return new Person(personRepository.save(personEntity));
  }

  public List<Person> findAll() {
    List<PersonEntity> list = (List<PersonEntity>) personRepository.findAll();
    return list.stream().map(personEntity -> createPerson(personEntity)).collect(toList());
  }

  private Person createPerson(PersonEntity entity) {
    return new Person(entity);
  }

  public Person get(Integer id) {
    Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
    if (optionalPersonEntity.isPresent()) {
      return new Person(optionalPersonEntity.get());
    }
    return null;
  }
}
