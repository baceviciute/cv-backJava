package lt.codeacademy.cv.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository repository;

    @Autowired
    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    List<SkillView> getSkills () {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void addSkill (SkillView skillView) {
        repository.save(mapFromView(skillView));

    }

    void updateSkill (SkillView skillView, long id) {
        Skill skill = findById(id);
        if(skillView.getType() != null) {
            skill.setType(skillView.getType());
        }
        if(skillView.getSkillText() != null) {
            skill.setSkillText(skillView.getSkillText());
        }
        repository.save(skill);
    }

    void deleteSkill (long id) {
        repository.deleteById(id);
    }



    private Skill mapFromView (SkillView skillView) {
        return new Skill(skillView.getType(), skillView.getSkillText());
    }

    private SkillView mapToView (Skill skill) {
        return new SkillView (skill.getId(), skill.getType(), skill.getSkillText());
    }

    private Skill findById (long id) {
        return repository.findById(id).orElseThrow(()->new RuntimeException("Skill was not found"));
    }

}
