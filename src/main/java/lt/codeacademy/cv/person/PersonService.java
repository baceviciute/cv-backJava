package lt.codeacademy.cv.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    PersonView getPersonView() {
        return mapToView(repository.getOne(1));
    }

    void addPersonInfo (PersonView personView) {
        repository.save(mapFromView(personView));
    }

    public void updatePerson (PersonView updatedPersonView) {
        Person person = repository.getOne(1);
        if (updatedPersonView.getFirstName() != null){
            person.setFirstName(updatedPersonView.getFirstName());
        }
        if(updatedPersonView.getLastName() != null) {
            person.setLastName(updatedPersonView.getLastName());
        }
        if(updatedPersonView.getAboutMe() != null) {
            person.setAboutMe(updatedPersonView.getAboutMe());
        }

        repository.save(person);
    }

    private PersonView mapToView(Person person) {
        return new PersonView(person.getId(), person.getFirstName(), person.getLastName(), person.getAboutMe());
    }

    private Person mapFromView (PersonView personView) {
        return new Person (personView.getId(), personView.getFirstName(), personView.getLastName(), personView.getAboutMe());
    }

}
