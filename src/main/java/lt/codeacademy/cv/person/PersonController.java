package lt.codeacademy.cv.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/person")
public class PersonController {

    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping(path = "/info")
    // GetMapping yra tas pats kas RequestMapping (GET)
    public PersonView getPersonInfo () {
        return service.getPersonView();
    }

    @PostMapping(path = "/create-info")
    public void createPersonInfo (@RequestBody PersonView personView) {
        this.service.addPersonInfo(personView);
    }

    @PutMapping(path = "/update-info")
    public void updatePersonInfo(@RequestBody PersonView personView) {
        service.updatePerson(personView);
    }


}
