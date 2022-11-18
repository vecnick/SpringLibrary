package nick.people.util;

import nick.people.dao.BookDAO;
import nick.people.dao.PersonDAO;
import nick.people.models.Book;
import nick.people.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator {
    private final BookDAO bookDAO;

    @Autowired
    public BookValidator(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

        //человек с таким же email есть в бд
//        if (bookDAO.show(person.getName()).isPresent())
//            errors.rejectValue("name", "","ФИО уже зарегистрировано");
    }
}