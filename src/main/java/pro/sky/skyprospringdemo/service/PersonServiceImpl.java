package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    Map<String, Person> persons = new HashMap<>(Map.of(
            "12345",
            new Person(
                    "Жан",
                    "Рено",
                    "12345",
                    3
            ),
            "54321",
            new Person(
                    "Люк",
                    "Бессон",
                    "54321",
                    2
            ),
            "14125",
            new Person(
                    "Жерар",
                    "Депардье",
                    "14125",
                    1
            ),
            "12315",
            new Driver(
                    "Джейсон",
                    "Стетхем",
                    "12315",
                    "1235",
                    2
            ),
            "12344",
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "12344",
                    "2353",
                    2)

    ));
    List<String> professions = List.of(
            "безработный",
            "водитель",
            "плотник",
            "столяр",
            "актер"
    );

    @Override
    public String getPersonByPassport(String passport) {
        Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с таким паспортом не найден");
        }

        final String personDescription = ""
                + person.getName() + " "
                + person.getSurname() + " "
                + person.getPassport() + " "
                + getProfessionNames(person.getProfessionNumbers());
        return personDescription;
    }

    @Override
    public String addPerson(Person person) {
        persons.put(person.getPassport(), person);
        return null;
    }

    @Override
    public void addProfession(String passport, Integer profession) {
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с таким номером паспорта не найден");
        }
        person.getProfessionNumbers().add(profession);
    }

    private String getProfessionNames(Set<Integer> professionNumbers) {
        String result = "";
        for (Integer professionNumber : professionNumbers) {
            result = result + " " + professions.get(professionNumber);
        }
        return result;
    }
}
