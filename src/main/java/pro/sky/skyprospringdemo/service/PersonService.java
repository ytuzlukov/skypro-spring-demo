package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Person;

public interface PersonService {

    String getPersonByPassport(String passport);

    String addPerson(Person person);

    void addProfession(String passport, Integer profession);
}
