package repository;

import model.Person;

import java.util.List;

public interface PersonDao {
    Long createUser(Person person);

    Person findUserById(Integer id);

    void updateUser(Person user);

    void deleteUserByReference(Person user);

    void deleteUserById(Long id);

    List<Person> getAllUsers();
}
