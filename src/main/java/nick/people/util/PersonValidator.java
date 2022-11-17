package nick.people.util;

import nick.people.dao.PersonDAO;
import nick.people.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidator(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        //человек с таким же email есть в бд
        if (personDAO.show(person.getName()).isPresent())
            errors.rejectValue("name", "","ФИО уже зарегистрировано");
    }
}
