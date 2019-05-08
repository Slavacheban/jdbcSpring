package service;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository repository;

    @Autowired
    public void setRepository(PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addUser(Person person) {
        repository.save(person);
    }

    @Override
    public Optional<Person> findPersonById(Long id) {
        return Optional.ofNullable(repository.getOne(id));
    }

    @Override
    public void updatePerson(Person person) {
        repository.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return repository.findAll();
    }
}
