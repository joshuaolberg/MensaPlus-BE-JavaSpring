package de.leuphana.mensaplus.controller;

import de.leuphana.mensaplus.model.Essensplan;
import de.leuphana.mensaplus.service.EssensplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/essensplan")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EssensplanController {

    @Autowired
    private EssensplanService essensplanService;

    @GetMapping
    public List<Essensplan> getEssensplan() {
        return essensplanService.getEssensplan();
    }

    @GetMapping(value = "/{id}")
    public Optional<Essensplan> getEssensplanById(@PathVariable("id") int id) {
        return essensplanService.getEssensplanById(id);
    }

    @PostMapping
    public void addEssensplan(@RequestBody Essensplan essensplan) {
        essensplanService.addEssensplan(essensplan);
    }

    @PutMapping
    public Essensplan updateEssen(@RequestBody Essensplan essensplan) {
        return essensplanService.updateEssensplan(essensplan);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEssensplanById(@PathVariable("id") int id) {
        essensplanService.deleteEssensplanById(id);
    }

    @PostMapping(path = "/{essensplanId}/add/{essenId}/wt={wochentag}")
    public void addEssenToEssensplan(@PathVariable("essensplanId") int essensplanId, @PathVariable("essenId") int essenId, @PathVariable("wochentag") int wochentag) {
        essensplanService.addEssenToEssensplan(essensplanId, essenId, wochentag);
    }


    @DeleteMapping(path = "/{essensplanId}/delete/{essenId}/wt={wochentag}")
    public void deleteEssenFromEssensplan(@PathVariable("essensplanId") int id, @PathVariable("essenId") int essenId, @PathVariable("wochentag") int wochentag) {
        essensplanService.deleteEssenFromEssensplan(id, essenId, wochentag);
    }
}
