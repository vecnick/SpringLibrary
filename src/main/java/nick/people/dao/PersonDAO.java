package nick.people.dao;

import nick.people.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT=0;
    private static List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Nick", 20,"nick@mail.ru", "89169297788"));
        people.add(new Person(++PEOPLE_COUNT,"Gena",30,"gena@mail.ru", "89169398899"));
        people.add(new Person(++PEOPLE_COUNT,"Zhenya",40,"bob@mail.ru", "89169491122"));
        people.add(new Person(++PEOPLE_COUNT,"Ilham",50,"ilham@mail.ru", "89169592233"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person person){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setNumber(person.getNumber());
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public static void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
