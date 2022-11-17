package nick.people.dao;

import nick.people.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private static JdbcTemplate jdbcTemplate = null;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        PersonDAO.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return  jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class) );
    }

    public Optional<Person> show(String name){
        return jdbcTemplate.query("SELECT * FROM Person WHERE name=?", new Object[] {name},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show(int person_id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE person_id=?", new Object[]{person_id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person(name,year_of_birth) VALUES(?,?)",person.getName(),
                person.getYearOfBirth());
    }
    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE Person SET name=?,year_of_birth=? WHERE person_id=?",
                person.getName(),person.getYearOfBirth(),id);
    }

    public static void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE person_id=?",id);
    }
}
