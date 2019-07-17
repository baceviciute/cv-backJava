package lt.codeacademy.cv.skill;

import java.util.Objects;

public class SkillView {

    private long id;
    private SkillType type;
    private String skillText;

    public SkillView() {
    }

    public SkillView(long id, SkillType type, String skillText) {
        this.id = id;
        this.type = type;
        this.skillText = skillText;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public String getSkillText() {
        return skillText;
    }

    public void setSkillText(String skillText) {
        this.skillText = skillText;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillView skillView = (SkillView) o;
        return id == skillView.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SkillView{" +
                "id=" + id +
                ", type=" + type +
                ", skillText='" + skillText + '\'' +
                '}';
    }
}
