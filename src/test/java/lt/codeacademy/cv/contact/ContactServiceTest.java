//package lt.codeacademy.cv.contact;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.validation.constraints.Null;
//
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = ContactService.class)
//@EnableAutoConfiguration
//@DataJpaTest
//public class ContactServiceTest {
//
//    @Autowired
//    private ContactRepository repository;
//
//    @Autowired
//    private ContactService service;
//
//
//    @Test
//    public void testContactService_updateExistingContact_willUpdateProvidedField(){
//        Contact savedContact = repository.save(new Contact("test-value", ContactType.FaEnvelope, "test-url"));
//        ContactView updatedContact = new ContactView(0,
//                "updated-value", null, null);
//
//        service.updateContact(updatedContact, savedContact.getId());
//
//        Contact actualResult = repository.getOne(savedContact.getId());
//
//        assertEquals("updated-value", actualResult.getValue());
//        assertEquals(ContactType.FaEnvelope, actualResult.getType());
//        assertEquals("test-url", actualResult.getUrl());
//    }
//
//
//
//}