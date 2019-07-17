package lt.codeacademy.cv.education;

import java.util.Objects;

public class EducationView {

    private int id;
    private String degree;
    private String university;
    private String startYear;
    private String endYear;

    public EducationView() {
    }

    public EducationView(int id, String degree, String university, String startYear, String endYear) {
        this.id = id;
        this.degree = degree;
        this.university = university;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        if(Integer.parseInt(endYear) > Integer.parseInt(this.startYear)){
            this.endYear = endYear;
        }
        else{
            throw new RuntimeException("Negerai");
        }
    }

    @Override
    public String toString() {
        return "EducationView{" +
                "id=" + id +
                ", degree='" + degree + '\'' +
                ", university='" + university + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationView that = (EducationView) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
