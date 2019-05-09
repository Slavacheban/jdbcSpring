package repository;

import model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {
    void addUser(Person person);

    Optional<Person> findPersonById(Integer id);

    void updatePerson(Person person);

    void deletePersonById(Integer id);

    List<Person> getAllPersons();
}
