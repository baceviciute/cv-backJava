package lt.codeacademy.cv.contact;

import lt.codeacademy.cv.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    List<ContactView> getContactViews() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    ContactView addContact(ContactView contactView) {
        return mapToView(repository.save(mapFromView(contactView)));
    }

    void updateContact(ContactView updatedContactView, int contactId) {
        Contact contact = findContact(contactId);
        if (updatedContactView.getValue() != null) {
            contact.setValue(updatedContactView.getValue());
        }

        if (updatedContactView.getType() != null) {
            contact.setType(updatedContactView.getType());
        }

        if(updatedContactView.getUrl() != null) {
            contact.setUrl(updatedContactView.getUrl());
        }

        repository.save(contact);
    }

    void deleteContact(int contactId) {
        repository.deleteById(contactId);
    }


    private Contact findContact(int contactId) {
        return repository.findById(contactId)
                .orElseThrow(() -> new NotFoundException("Contact not found"));
    }

    private ContactView mapToView(Contact contact) {
        return new ContactView(contact.getId(), contact.getValue(), contact.getType(), contact.getUrl());
    }

    private Contact mapFromView(ContactView contactView) {
        return new Contact(contactView.getValue(), contactView.getType(), contactView.getUrl());
    }

}
