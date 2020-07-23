package de.leuphana.mensaplus.controller;

import de.leuphana.mensaplus.model.Essensplan;
import de.leuphana.mensaplus.service.EssensplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Essensplan> addEssensplan(@RequestBody Essensplan essensplan) {
        essensplanService.addEssensplan(essensplan);
        return new ResponseEntity<>(essensplan, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Essensplan> updateEssen(@RequestBody Essensplan essensplan) {
        essensplanService.updateEssensplan(essensplan);
        return new ResponseEntity<>(essensplan, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEssensplanById(@PathVariable("id") int id) {
        essensplanService.deleteEssensplanById(id);
    }

    @PostMapping(path = "/{essensplanId}/add/{essenId}/wt={wochentag}")
    public ResponseEntity<Essensplan> addEssenToEssensplan(@PathVariable("essensplanId") int essensplanId, @PathVariable("essenId") int essenId, @PathVariable("wochentag") int wochentag) {
        return essensplanService.addEssenToEssensplan(essensplanId, essenId, wochentag);
    }


    @DeleteMapping(path = "/{essensplanId}/remove/{essenId}/wt={wochentag}")
    public ResponseEntity<Essensplan> removeEssenFromEssensplan(@PathVariable("essensplanId") int id, @PathVariable("essenId") int essenId, @PathVariable("wochentag") int wochentag) {
        return essensplanService.removeEssenFromEssensplan(id, essenId, wochentag);
    }
}
