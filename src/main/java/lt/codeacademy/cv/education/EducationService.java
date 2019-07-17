package lt.codeacademy.cv.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    private final EducationRepository repository;

    @Autowired
    public EducationService(EducationRepository repository) {
        this.repository = repository;
    }

    List<EducationView> getEducationViews () {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void addEducation (EducationView educationView) {
        repository.save(mapFromView(educationView));
    }

    void updateEducation (EducationView updatedEducationView, long educationId) {
        Education education = findById(educationId);
        if(updatedEducationView.getUniversity() != null) {
            education.setUniversity(updatedEducationView.getUniversity());
        }
        if(updatedEducationView.getDegree() != null) {
            education.setDegree(updatedEducationView.getDegree());
        }
        if(updatedEducationView.getStartYear() != null) {
            education.setStartYear(updatedEducationView.getStartYear());
        }
        if(updatedEducationView.getEndYear() != null) {
            education.setEndYear(updatedEducationView.getEndYear());
        }
    }

    void deleteEducation (long educationId) {
        repository.deleteById(educationId);
    }

    private EducationView mapToView(Education education) {
        return new EducationView(education.getId(),
                education.getDegree(),
                education.getUniversity(),
                education.getStartYear(),
                education.getEndYear());
    }

    private Education mapFromView(EducationView educationView) {
        return new Education(educationView.getDegree(),
                educationView.getUniversity(),
                educationView.getStartYear(),
                educationView.getEndYear());
    }

    private Education findById (long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("education not found"));
    }
}
