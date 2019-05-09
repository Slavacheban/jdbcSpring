package service;

import model.Person;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;


@RunWith(Arquillian.class)
public class PersonServiceImplTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(PersonServiceImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    @Autowired
    private PersonService service;

    @Test
    public void addPerson() {
        Person person = new Person().setAge(25).setCity("Odessa").setName("Slava");
        service.addPerson(person);
        Assert.assertEquals(person, service.findPersonById(person.getId()));
    }

    @Test
    public void findPersonById() {
        Person person = new Person().setAge(25).setCity("Odessa").setName("Slava");
        service.addPerson(person);
        Assert.assertEquals(person, service.findPersonById(person.getId()));
    }

    @Test
    public void updatePerson() {
        Person person = new Person().setAge(25).setCity("Odessa").setName("Slava");
        service.addPerson(person);
        person.setAge(26).setCity("Kyev");
        service.updatePerson(person);
        Assert.assertEquals(person, service.findPersonById(person.getId()));
    }

    @Test
    public void deletePersonById() {
        Person person = new Person().setAge(25).setCity("Odessa").setName("Slava");
        service.addPerson(person);
        service.deletePersonById(person.getId());
        Assert.assertFalse(service.getAllPersons().contains(person));
    }

    @Test
    public void getAllPersons() {
        Person person = new Person().setAge(25).setCity("Odessa").setName("Slava");
        service.addPerson(person);
        Assert.assertEquals(service.getAllPersons(), new ArrayList<>().add(person));
    }
}
