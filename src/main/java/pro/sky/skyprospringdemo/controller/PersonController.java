package pro.sky.skyprospringdemo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyprospringdemo.domain.Person;
import pro.sky.skyprospringdemo.service.person.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/person/by_passport")
    public String getPersonInfo(@RequestParam("passport") String passport) {
        return personService.getPersonByPassport(passport);
    }

    @GetMapping(path = "/person/profession/add")
    public String addProfession(@RequestParam("passport") String passport,
                                @RequestParam("profession") Integer profession) {
        personService.addProfession(passport, profession);
        return "профессия добавлена";
    }

    @GetMapping(path = "/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("passport") String passport,
                            @RequestParam("professionNumber") Integer professionNumber) {
        Person person = new Person(
                name,
                surname,
                passport,
                professionNumber);
        personService.addPerson(person);
        return "Person added";
    }

    @GetMapping(path = "/persons/by-profession")
    public String getByProfession(@RequestParam("profession") int profession) {
        final List<Person> personsByProfession = personService.getPersonsByProfession(profession);
//        String forPassport = null;
//        for (Person person : personsByProfession) {
//            String passport = person.getPassport();
//            if (passport.startsWith("4")) {
//                forPassport = ("~" + person.getPassport() + "~");
//            }
//        }
//        if (forPassport == null) {
//            throw new RuntimeException("Person not found");
//        }

        final Optional<String> passport = personsByProfession.stream()
                .map(e -> e.getPassport())
                .filter(p -> p.startsWith(String.valueOf(profession)))
                .map(p -> "~" + p + "~")
                .findAny()
                ;
        return passport.orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
