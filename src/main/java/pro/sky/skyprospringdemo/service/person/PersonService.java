package pro.sky.skyprospringdemo.service.person;

import pro.sky.skyprospringdemo.domain.Person;

import java.util.List;
import java.util.Set;

public interface PersonService {

    List<Person> getPersonsByProfession(Integer professionNumber);

    List<Person> getPersonsByProfessions(List<Integer> professionNumbers);

    String getPersonByPassport(String passport);

    String addPerson(Person person);

    void addProfession(String passport, Integer profession);

    String getProfessionNames(Set<Integer> professionNumbers);
}
