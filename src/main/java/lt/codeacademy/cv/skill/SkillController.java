package lt.codeacademy.cv.skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService service;

    @Autowired
    public SkillController(SkillService service) {
        this.service = service;
    }

    @GetMapping
    public List<SkillView> getSkills () {
        return service.getSkills();
    }

    @PostMapping(path = "/add-skill")
    public void addSkill (@RequestBody SkillView skillView) {
        service.addSkill(skillView);
    }

    @PutMapping(path = "/update/{id}")
    public void updateSkill (@RequestBody SkillView skillView, @PathVariable(name="id") long id) {
        service.updateSkill(skillView, id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteSkill (@PathVariable(name="id") long id) {
        service.deleteSkill(id);
    }
}
