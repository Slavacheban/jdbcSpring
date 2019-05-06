package repository;

import model.Person;

import java.util.List;

public interface PersonDao {
    void addUser(Person person);

    Person findPersonById(Integer id);

    void updatePerson(Person person);

    void deletePersonById(Integer id);

    List<Person> getAllPersons();
}
