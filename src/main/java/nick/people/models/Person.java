package nick.people.models;


import javax.validation.constraints.*;

public class Person {



    private int id;



    @NotEmpty(message = "Введите ФИО")
    @Size(min = 2, max = 30, message = "Фио должно быть от 2 до 30 символов")
    private String name;

    @Min(value = 1900,message = "Год рождения должен быть больше  1900" )
    private int yearOfBirth;

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Person(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Person(String name,int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }
}
