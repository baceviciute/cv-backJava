package lt.codeacademy.cv.contact;

import lt.codeacademy.cv.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/contact")
@CrossOrigin(methods = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET})
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping(path = "/contacts")
    public List<ContactView> getContacts() {
        return service.getContactViews();
    }

    @PostMapping(path = "/add-contact")
    public ContactView addContact(@RequestBody ContactView contactView) {
       return service.addContact(contactView);
    }

    @PutMapping(path = "/update/{contactId}")
    public void updateContact(@RequestBody ContactView contactView, @PathVariable(name = "contactId") int contactId) {
        service.updateContact(contactView, contactId);
    }

    @DeleteMapping(path = "/delete/{contactId}")
    public void deleteContact(@PathVariable(name = "contactId") int contactId) {
        service.deleteContact(contactId);
    }

    @GetMapping(path = "/types")
    public List<ContactType> getContactTypes () {
        return Arrays.asList(ContactType.values());
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundError() {
    }
}
