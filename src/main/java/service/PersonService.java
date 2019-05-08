package service;

import model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void addUser(Person person);

    Optional<Person> findPersonById(Long id);

    void updatePerson(Person person);

    void deletePersonById(Long id);

    List<Person> getAllPersons();
}
