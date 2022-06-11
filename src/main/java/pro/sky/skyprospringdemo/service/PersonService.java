package pro.sky.skyprospringdemo.service;

import pro.sky.skyprospringdemo.domain.Person;

public interface PersonService {
    String getPerson(Integer number);

    String addPerson(Person person);
}
