package lt.codeacademy.cv.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/employer")
public class EmployerController {

    private final EmployerRepository repository;

    @Autowired
    public EmployerController(EmployerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EmployerView> getEmployers() {
        return repository.findAll().stream()
                .map(this::mapFromEmployer)
                .collect(Collectors.toList());
    }

    @PostMapping(path = "/add-employer")
    public void addEmployer(@RequestBody @Valid EmployerView employerView) {
        repository.save(mapToEmployer(employerView));
    }

    @PostMapping(path = "/add-activity/{employerId}")
    public void addActivity(@PathVariable("employerId") long employerId, @RequestBody @Valid ActivityView activityView) {
        Activity activity = mapToActivity(activityView);
        Employer employer = repository.findById(employerId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong employer ID"));

        employer.addActivity(activity);
        repository.save(employer);
    }

    private Activity mapToActivity(ActivityView activityView) {
        return new Activity(activityView.getDescription(),
                activityView.getStartDate(),
                activityView.getEndDate(),
                activityView.getPosition());
    }

    private Employer mapToEmployer(EmployerView employerView) {
        return new Employer(employerView.getName(),
                employerView.getStartDate(),
                employerView.getEndDate(),
                Collections.emptyList());
    }

    private EmployerView mapFromEmployer(Employer employer) {
        List<ActivityView> activityViews = employer.getActivities().stream()
                .map(this::mapFromActivity)
                .collect(Collectors.toList());
        return new EmployerView(employer.getId(),
                employer.getName(),
                employer.getStartDate(),
                employer.getEndDate(),
                activityViews);
    }

    private ActivityView mapFromActivity(Activity activity) {
        return new ActivityView(activity.getId(),
                activity.getDescription(),
                activity.getStartDate(),
                activity.getEndDate(),
                activity.getPosition());
    }

}
