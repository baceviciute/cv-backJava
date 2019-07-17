package lt.codeacademy.cv.education;

import lt.codeacademy.cv.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/education")
public class EducationController {

    private final EducationService service;

    @Autowired
    public EducationController(EducationService service) {
        this.service = service;
    }

    @GetMapping
    public List<EducationView> getEducation () {
        return service.getEducationViews();
    }

    @PostMapping(path = "/add-education")
    public void addEducation (@RequestBody EducationView educationView) {
        service.addEducation(educationView);
    }

    @PutMapping(path = "/update/{id}")
    public void updateEducation (@RequestBody EducationView educationView, @PathVariable(name="id") long educationId) {
        service.updateEducation(educationView, educationId);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteEducation (@PathVariable(name = "id") long id) {
        service.deleteEducation(id);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundError() {
    }
}
