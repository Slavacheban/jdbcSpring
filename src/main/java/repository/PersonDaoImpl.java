package repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j
@Repository
@Qualifier("personDao")
@RequiredArgsConstructor
public class PersonDaoImpl implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(Person person) {
        jdbcTemplate.update("INSERT INTO persons (name, age, city) VALUES (?, ?, ?)", person.getName(), person.getAge(), person.getCity());
    }

    public Optional<Person> findPersonById(Integer id) {
        return Optional.ofNullable((Person)jdbcTemplate.queryForObject("SELECT * FROM persons where id = ?",
                new Object[]{id}, new BeanPropertyRowMapper(Person.class)));
    }

    public void updatePerson(Person person) {
        jdbcTemplate.update("UPDATE persons SET name = ? , age = ? , city = ? WHERE id = ?", person.getName(), person.getAge(), person.getCity());
    }

    public void deletePersonById(Integer id) {
        jdbcTemplate.update("DELETE from persons WHERE id = ?", id);
    }

    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT * FROM person", new BeanPropertyRowMapper(Person.class));
    }
}
