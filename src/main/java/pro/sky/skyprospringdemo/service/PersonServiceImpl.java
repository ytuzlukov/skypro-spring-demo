package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;

import java.util.*;
import java.util.stream.Collectors;

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
                    0
            ),
            "12344",
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "12344",
                    "2353",
                    0)

    ));
    List<String> professions = List.of(
            "безработный",
            "водитель",
            "плотник",
            "столяр",
            "актер"
    );

    Map<String, Integer> professionsCodes = Map.of(
            "безработный", 0,
            "водитель", 1,
            "плотник", 2,
            "столяр", 3,
            "актер", 4
    );

    @Override
    public List<Person> getPersonsByProfession(Integer professionNumber) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().contains(professionNumber)) {
                result.add(person);
            }
        }

        return persons.values().stream()
                .filter(e -> e.getProfessionNumbers().contains(professionNumber))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getPersonsByProfessions(List<Integer> professionNumbers) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().containsAll(professionNumbers)) {
                result.add(person);
            }
        }
        return result;
    }

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

    @Override
    public String getProfessionNames(Set<Integer> professionNumbers) {
        String result = "";
        for (Integer professionNumber : professionNumbers) {
            result = result + " " + professions.get(professionNumber);
        }
        return result;
    }
}
