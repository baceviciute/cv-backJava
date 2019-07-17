package lt.codeacademy.cv.employer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String position;

    @ManyToOne
    private Employer employer;

    public Activity() {
    }

    public Activity(String description, LocalDate startDate, LocalDate endDate, String position) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
    }

    public Activity(String description, LocalDate startDate, LocalDate endDate, String position, Employer employer) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.employer = employer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", position='" + position + '\'' +
                ", employer=" + employer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
