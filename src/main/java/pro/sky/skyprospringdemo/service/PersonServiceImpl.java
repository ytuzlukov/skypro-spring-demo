package pro.sky.skyprospringdemo.service;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringdemo.domain.Driver;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.domain.TruckDriver;
import pro.sky.skyprospringdemo.exceptions.BadPersonNumberException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    List<Person> persons = new ArrayList<>(List.of(
            new Person(
                    "Жан",
                    "Рено",
                    "12345",
                    3
            ),
            new Person(
                    "Люк",
                    "Бессон",
                    "54321",
                    2
            ),
            new Person(
                    "Жерар",
                    "Депардье",
                    "14125",
                    1
            ),
            new Driver(
                    "Джейсон",
                    "Стетхем",
                    "12315",
                    "1235",
                    2
            ),
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "12345",
                    "2353",
                    2)

    ));
    List<String> professions = List.of(
            "безработный",
            "водитель",
            "плотник",
            "столяр"
    );

    @Override
    public String getPerson(Integer number) {
        final Person person;
        if(number>=persons.size()) {
            throw new BadPersonNumberException("номер человека больше количества элементов");
        }
        person = persons.get(number);
        final String personDescription = ""
                + person.getName() + " "
                + person.getSurname() + " "
                + person.getPassport() + " "
                + professions.get(person.getProfessionNumber());
        return personDescription;
    }

    @Override
    public String addPerson(Person person) {
        persons.add(person);
        return null;
    }
}
